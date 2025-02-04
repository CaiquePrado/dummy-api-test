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
    public void shouldNotDeleteProductByInvalidId(){
        dummyClient
        .deleteProductById(INVALID_ID)
        .statusCode(SC_NOT_FOUND);
    }
}
