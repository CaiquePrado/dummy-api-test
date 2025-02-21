package functional;

import base.BaseTest;
import dto.Message;
import dto.Product;
import factory.ProductFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.apache.http.HttpStatus.*;

public class ProductFunctionalTest extends BaseTest {

    @DataProvider(name = "productFactory")
    public Object[][] productFactory() {
        return new Object[][]{
                { ProductFactory.createProductWithTitleFactory() },
                { ProductFactory.createProductWithDescriptionFactory() },
                { ProductFactory.createProductWithPriceFactory() },
                { ProductFactory.createProductWithDiscountPercentageFactory() },
                { ProductFactory.createProductWithRatingFactory() },
                { ProductFactory.createProductWithStockFactory() },
                { ProductFactory.createProductWithBrandFactory() },
                { ProductFactory.createProductWithCategoryFactory() },
                { ProductFactory.createProductWithThumbnailFactory() }
        };
    }

    @Test(dataProvider = "productFactory")
    public void shouldCreateProductWithOneAttributeTest(Product product){
        productClient
        .createValidProductOneAttribute(product)
        .statusCode(SC_CREATED);
    }

    @DataProvider(name = "invalidIds")
    public Object[][] provideInvalidIds() {
        return new Object[][]{
                {"12345"},
                {"invalid-id"},
                {"!@#$%"}
        };
    }

    @Test(dataProvider = "invalidIds")
    public void shouldNotDeleteProductByInvalidIdTest(String invalidId){
        var expectedMessage = productClient
        .deleteProductById(invalidId)
        .statusCode(SC_NOT_FOUND)
        .extract()
        .as(Message.class);

        String expectedErrorMessage = String.format("Product with id '%s' not found", invalidId);

        assertThat(expectedMessage.message(), is(expectedErrorMessage));
    }

    @Test(dataProvider = "invalidIds")
    public void shouldNotFindProductByInvalidIdTest(String invalidId){
        var expectedMessage = productClient
        .listProductById(invalidId)
        .statusCode(SC_NOT_FOUND)
        .extract()
        .as(Message.class);

        String expectedErrorMessage = String.format("Product with id '%s' not found", invalidId);

        assertThat(expectedMessage.message(), is(expectedErrorMessage));
    }

    @DataProvider(name = "searchFactory")
    public Object[][] searchFactory() {
        return new Object[][]{
                {"phone"},
                {"laptop"},
                {""}
        };
    }

    @Test(dataProvider = "searchFactory")
    public void shouldSearchProductByNameTest(String search) {
        productClient
        .searchProductByName(search)
        .statusCode(SC_OK);
    }

    @DataProvider(name = "limitFactory")
    public Object[][] limitFactory() {
        return new Object[][]{
                {10},
                {100},
                {1000}
        };
    }

    @Test(dataProvider = "limitFactory")
    public void shouldPaginateProductsTest(int limit){
        productClient
        .searchProductsByPage(limit)
        .statusCode(SC_OK);
    }

    @Test
    public void shouldNotPaginateProductsTest(){
        var expectedMessage = productClient
        .searchProductsByPage()
        .statusCode(SC_BAD_REQUEST)
        .extract()
        .as(Message.class);

        assertThat(expectedMessage.message(), is("Invalid 'limit' - must be a number"));
    }

    @DataProvider(name = "skipFactory")
    public Object[][] skipFactory() {
        return new Object[][]{
                {10},
                {100},
                {1000}
        };
    }

    @Test(dataProvider = "skipFactory")
    public void shouldSkipProductsTest(int skip){
        productClient
        .skipProductsByPage(skip)
        .statusCode(SC_OK);
    }

    @Test
    public void shouldNotSkipProductsTest(){
        var expectedMessage = productClient
        .skipProductsByPage()
        .statusCode(SC_BAD_REQUEST)
        .extract()
        .as(Message.class);

        assertThat(expectedMessage.message(), is("Invalid 'skip' - must be a number"));
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

    @Test(dataProvider = "selectFactory")
    public void shouldSelectProductsTest(String select){
        productClient
        .selectProductByAttribute(select)
        .statusCode(SC_OK);
    }

    @Test
    public void shouldSelectSkipAndLimitProductsTest(){
        productClient
        .selectLimitSkipProducts()
        .statusCode(SC_OK);
    }

    @Test
    public void shouldListCategoriesTest(){
        productClient
        .listAllCategories()
        .statusCode(SC_OK);

//        assertThat(expectedCategory, is(CategoryResponse.validCategoryResponse()));
    }

    @DataProvider(name = "categoriesFactory")
    public Object[][] categoriesFactory() {
        return new Object[][]{
                {"beauty"},
                {"fragrances"},
                {"furniture"},
                {"groceries"},
                {"home-decoration"},
                {"kitchen-accessories"},
                {"laptops"},
                {"mens-shirts"},
                {"mens-shoes"},
                {"mens-watches"},
                {"mobile-accessories"},
                {"motorcycle"},
                {"skin-care"},
                {"smartphones"},
                {"sports-accessories"},
                {"sunglasses"},
                {"tablets"},
                {"tops"},
                {"vehicle"},
                {"womens-bags"},
                {"womens-dresses"},
                {"womens-jewellery"},
                {"womens-shoes"},
                {"womens-watches"}
        };
    }
    @Test(dataProvider = "categoriesFactory")
    public void shouldListProductsByCategoryTest(String category){
        productClient
        .listProductsByCategory(category)
        .statusCode(SC_OK);
    }

    @DataProvider(name = "orderFactory")
    public Object[][] orderFactory() {
        return new Object[][]{
                {"asc"},
                {"desc"}
        };
    }

    @Test(dataProvider = "orderFactory")
    public void shouldListProductsOrderTest(String order){
        productClient
        .listProductsByOrder(order)
        .statusCode(SC_OK);
    }

    @DataProvider(name = "invalidOrderFactory")
    public Object[][] invalidOrderFactory() {
        return new Object[][]{
                {"nulls_first"},
                {"nulls_last"},
                {"random"},
                {"@#@"}
        };
    }

    @Test(dataProvider = "invalidOrderFactory")
    public void shouldNotListProductsWithInvalidOrderTest(String order){
        productClient
        .listProductsByOrder(order)
        .statusCode(SC_BAD_REQUEST);
    }
}
