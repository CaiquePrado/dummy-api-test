package functional;

import base.BaseTest;
import dto.Message;
import dto.Product;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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

    @Test(description = "Deve criar produtos com diferentes atributos", dataProvider = "productAttributes")
    public void shouldCreateProductWithSingleAttribute(Product product) {
        productClient
                .createProductWithAttributes(product)
                .statusCode(SC_CREATED);
    }

    @Test(description = "Não deve atualizar produto com ID inválido", dataProvider = "invalidIds")
    public void shouldNotUpdateProductWithInvalidId(String invalidId) {
        var response = productClient
                .updateProductById(invalidId)
                .statusCode(SC_NOT_FOUND)
                .extract()
                .as(Message.class);

        assertThat(response.message(), is(String.format("Product with id '%s' not found", invalidId)));
    }

    @Test(description = "Não deve deletar produto com ID inválido", dataProvider = "invalidIds")
    public void shouldNotDeleteProductWithInvalidId(String invalidId) {
        var response = productClient
                .deleteProductById(invalidId)
                .statusCode(SC_NOT_FOUND)
                .extract()
                .as(Message.class);

        assertThat(response.message(), is(String.format("Product with id '%s' not found", invalidId)));
    }

    @Test(description = "Deve buscar produtos por nome", dataProvider = "searchTerms")
    public void shouldSearchProductsByName(String searchTerm) {
        productClient
                .searchProductByName(searchTerm)
                .statusCode(SC_OK)
                .body("products.size()", greaterThan(0));
    }

    @Test(description = "Deve listar produtos com paginação", dataProvider = "limitValues")
    public void shouldListProductsWithPagination(int limit) {
        productClient
                .searchProductsByPage(limit)
                .statusCode(SC_OK)
                .body("products.size()", greaterThan(0))
                .body("limit", notNullValue());
    }

    @Test(description = "Deve listar produtos por categoria", dataProvider = "categories")
    public void shouldListProductsByCategory(String category) {
        productClient
                .listProductsByCategory(category)
                .statusCode(SC_OK)
                .body("products.size()", greaterThan(0));
    }

    @Test(description = "Deve listar produtos ordenados", dataProvider = "sortOrders")
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

    @Test(description = "Não deve acessar com token inválido ou expirado", dataProvider = "invalidTokens")
    public void shouldNotAccessWithInvalidOrExpiredToken(String token, String expectedMessage) {
        var response = productClient
                .listAllProductsWithToken(token)
                .statusCode(SC_INTERNAL_SERVER_ERROR)
                .extract()
                .as(Message.class);

        assertThat(response.message(), is(expectedMessage));
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

    @DataProvider(name = "searchTerms")
    public Object[][] getSearchTerms() {
        return new Object[][]{
                {"phone"},
                {"laptop"},
                {""}
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
                {"skincare"},
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
}
