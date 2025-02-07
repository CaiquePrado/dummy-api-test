package functional;

import base.BaseTest;
import dto.Product;
import factory.ProductFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
}
