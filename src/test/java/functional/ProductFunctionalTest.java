package functional;

import base.BaseTest;
import dto.Category;
import dto.Message;
import dto.Product;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static factory.CategoryFactory.validCategoryResponse;
import static factory.ProductFactory.*;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static smoke.UserSmokeTest.shouldLoginUserTest;
import static utils.ApplicationConstants.EXPIRED_TOKEN;
import static utils.ApplicationConstants.INVALID_TOKEN;

public class ProductFunctionalTest extends BaseTest {

    @BeforeClass
    public void setup() {
        shouldLoginUserTest();
    }

    @Test(description = "CT003.002", dataProvider = "productAttributes")
    public void shouldCreateProductWithSingleAttribute(Product product) {
        productClient
                .createProductWithAttributes(product)
                .statusCode(SC_CREATED);
    }

    @Test(description = "CT006.002", dataProvider = "invalidIds")
    public void shouldNotUpdateProductWithInvalidId(String invalidId) {
        var response = productClient
                .updateProductById(invalidId)
                .statusCode(SC_NOT_FOUND)
                .extract()
                .as(Message.class);

        assertThat(response.message(), is(String.format("Product with id '%s' not found", invalidId)));
    }

    @Test(description = "CT002.003", dataProvider = "invalidIds")
    public void shouldNotFindProductByInvalidIdTest(String invalidId) {
        var expectedMessage = productClient
                .listProductById(invalidId)
                .statusCode(SC_NOT_FOUND)
                .extract()
                .as(Message.class);

        String expectedErrorMessage = String.format("Product with id '%s' not found", invalidId);

        assertThat(expectedMessage.message(), is(expectedErrorMessage));
    }

    @Test(description = "CT004.002", dataProvider = "invalidIds")
    public void shouldNotDeleteProductWithInvalidId(String invalidId) {
        var response = productClient
                .deleteProductById(invalidId)
                .statusCode(SC_NOT_FOUND)
                .extract()
                .as(Message.class);

        assertThat(response.message(), is(String.format("Product with id '%s' not found", invalidId)));
    }

    @Test(description = "CT002.004", dataProvider = "searchTerms")
    public void shouldSearchProductsByName(String searchTerm) {
        productClient
                .searchProductByName(searchTerm)
                .statusCode(SC_OK)
                .body("products.size()", greaterThan(0));
    }

    @Test(description = "CT002.013", dataProvider = "limitValues")
    public void shouldListProductsWithPagination(int limit) {
        productClient
                .searchProductsByPage(limit)
                .statusCode(SC_OK)
                .body("products.size()", greaterThan(0))
                .body("limit", notNullValue());
    }

    @Test(description = "CT002.007", dataProvider = "categories")
    public void shouldListProductsByCategory(String category) {
        productClient
                .listProductsByCategory(category)
                .statusCode(SC_OK)
                .body("products.size()", greaterThan(0));
    }

    @Test(description = "CT002.018", dataProvider = "sortOrders")
    public void shouldListProductsWithOrder(String order) {
        productClient
                .listProductsByOrder(order)
                .statusCode(SC_OK)
                .body("products.size()", greaterThan(0));
    }

    @Test(description = "Não deve listar produtos com ordem inválida", dataProvider = "invalidOrders")
    public void shouldNotListProductsWithInvalidOrder(String order) {
        var response = productClient
                .listProductsByOrder(order)
                .statusCode(SC_BAD_REQUEST)
                .extract()
                .as(Message.class);

        assertThat(response.message(), is("Order can be: 'asc' or 'desc'"));
    }

    @Test(description = "CT002.016 CT002.017", dataProvider = "invalidTokens")
    public void shouldNotAccessWithInvalidOrExpiredToken(String token, String expectedMessage) {
        var response = productClient
                .listAllProductsWithToken(token)
                .statusCode(SC_INTERNAL_SERVER_ERROR)
                .extract()
                .as(Message.class);

        assertThat(response.message(), is(expectedMessage));
    }

    @Test(description = "CT002.014")
    public void shouldSelectSkipAndLimitProductsTest() {
        productClient
                .selectLimitSkipProducts()
                .statusCode(SC_OK)
                .body("products.size()", greaterThan(0))
                .body("skip", notNullValue())
                .body("limit", notNullValue());
    }

    @Test(description = "CT002.015", dataProvider = "skipFactory")
    public void shouldSkipProductsTest(int skip) {
        productClient
                .skipProductsByPage(skip)
                .statusCode(SC_OK)
                .body("products.size()", greaterThan(0))
                .body("skip", notNullValue());
    }

    @Test(description = "CT002.020")
    public void shouldNotSkipProductsTest() {
        var expectedMessage = productClient
                .skipProductsByPage()
                .statusCode(SC_BAD_REQUEST)
                .extract()
                .as(Message.class);

        assertThat(expectedMessage.message(), is("Invalid 'skip' - must be a number"));
    }

    @Test(description = "CT002.021", dataProvider = "selectFactory")
    public void shouldSelectProductsTest(String select) {
        productClient
                .selectProductByAttribute(select)
                .statusCode(SC_OK)
                .body("products.size()", greaterThan(0));
    }

    @Test(description = "CT002.022")
    public void shouldNotPaginateProductsTest() {
        var expectedMessage = productClient
                .searchProductsByPage()
                .statusCode(SC_BAD_REQUEST)
                .extract()
                .as(Message.class);

        assertThat(expectedMessage.message(), is("Invalid 'limit' - must be a number"));
    }

    @Test(description = "CT002.023", dataProvider = "limitFactory")
    public void shouldPaginateProductsTest(int limit) {
        productClient
                .searchProductsByPage(limit)
                .statusCode(SC_OK)
                .body("products.size()", greaterThan(0))
                .body("limit", notNullValue());
    }

    @Test(description = "CT002.007")
    public void shouldListCategoriesTest() {
        var categoriesList = productClient
                .listAllCategories()
                .statusCode(SC_OK)
                .extract()
                .as(Category[].class);

        assertThat(Arrays.asList(categoriesList), is(validCategoryResponse()));
    }

    @Test(description = "CT002.024", dataProvider = "searchFactory")
    public void shouldSearchProductByNameTest(String search) {
        productClient
                .searchProductByName(search)
                .statusCode(SC_OK)
                .body("products.size()", greaterThan(0));
    }


    @DataProvider(name = "invalidTokens")
    public Object[][] invalidTokens() {
        return new Object[][]{
                {INVALID_TOKEN, "invalid signature"},
                {EXPIRED_TOKEN, "invalid signature"}
        };
    }

    @DataProvider(name = "productAttributes")
    public Object[][] getProductAttributes() {
        return new Object[][]{
                {createProductWithTitleFactory()},
                {createProductWithDescriptionFactory()},
                {createProductWithPriceFactory()},
                {createProductWithDiscountPercentageFactory()},
                {createProductWithRatingFactory()},
                {createProductWithStockFactory()},
                {createProductWithBrandFactory()},
                {createProductWithCategoryFactory()},
                {createProductWithThumbnailFactory()}
        };
    }

    @DataProvider(name = "invalidIds")
    public Object[][] getInvalidIds() {
        return new Object[][]{
                {"12345"},
                {"invalid-id"},
                {"!@#$%"}
        };
    }

    @DataProvider(name = "selectFactory")
    public Object[][] selectFactory() {
        return new Object[][]{
                {"title"},
                {"price"},
                {"description"},
                {"discountPercentage"},
                {"rating"},
                {"stock"},
                {"brand"},
                {"category"}
        };
    }

    @DataProvider(name = "searchTerms")
    public Object[][] getSearchTerms() {
        return new Object[][]{
                {"phone"},
                {"laptop"},
                {""}
        };
    }

    @DataProvider(name = "skipFactory")
    public Object[][] skipFactory() {
        return new Object[][]{
                {10},
                {50},
                {100}
        };
    }

    @DataProvider(name = "limitValues")
    public Object[][] getLimitValues() {
        return new Object[][]{
                {10},
                {100},
                {1000}
        };
    }

    @DataProvider(name = "categories")
    public Object[][] getCategories() {
        return new Object[][]{
                {"smartphones"},
                {"laptops"},
                {"fragrances"},
                {"groceries"},
                {"home-decoration"}
        };
    }

    @DataProvider(name = "sortOrders")
    public Object[][] getSortOrders() {
        return new Object[][]{
                {"asc"},
                {"desc"}
        };
    }

    @DataProvider(name = "invalidOrders")
    public Object[][] getInvalidOrders() {
        return new Object[][]{
                {"nulls_first"},
                {"nulls_last"},
                {"random"},
                {"@#@"}
        };
    }

    @DataProvider(name = "limitFactory")
    public Object[][] limitFactory() {
        return new Object[][]{
                {10},
                {100},
                {1000}
        };
    }

    @DataProvider(name = "searchFactory")
    public Object[][] searchFactory() {
        return new Object[][]{
                {"phone"},
                {"laptop"},
                {""}
        };
    }
}
