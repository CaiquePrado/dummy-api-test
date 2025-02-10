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
import static utils.ApplicationConstants.*;

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
        dummyClient
        .createValidProductOneAttribute(product)
        .statusCode(SC_CREATED);
    }

    @Test
    public void shouldNotDeleteProductByInvalidIdTest(){
        dummyClient
        .deleteProductById(INVALID_ID)
        .statusCode(SC_NOT_FOUND);
    }

    @Test
    public void shouldNotFindProductByInvalidIdTest(){
        dummyClient
        .listProductById(INVALID_ID)
        .statusCode(SC_NOT_FOUND);
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
    public void shouldSearchProductByNameTest(String search){
        dummyClient
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
        dummyClient
        .searchProductsByPage(limit)
        .statusCode(SC_OK);
    }

    @Test
    public void shouldNotPaginateProductsTest(){
        var expectedMessage = dummyClient
        .searchProductsByPage()
        .statusCode(SC_BAD_REQUEST)
        .extract()
        .as(Message.class);

        assertThat(expectedMessage.getMessage(), is("Invalid 'limit' - must be a number"));
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
        dummyClient
        .skipProductsByPage(skip)
        .statusCode(SC_OK);
    }

    @Test
    public void shouldNotSkipProductsTest(){
        var expectedMessage = dummyClient
        .skipProductsByPage()
        .statusCode(SC_BAD_REQUEST)
        .extract()
        .as(Message.class);

        assertThat(expectedMessage.getMessage(), is("Invalid 'skip' - must be a number"));
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
        dummyClient
        .selectProductByAttribute(select)
        .statusCode(SC_OK);
    }

    @Test
    public void shouldSelectSkipAndLimitProductsTest(){
        dummyClient
        .selectLimitSkipProducts()
        .statusCode(SC_OK);
    }

    @Test
    public void shouldListCategoriesTest(){
        dummyClient
        .listAllCategories()
        .statusCode(SC_OK);
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
        dummyClient
        .listProductsByCategory(category)
        .statusCode(SC_OK);
    }
}
