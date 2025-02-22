package smoke;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static utils.ApplicationConstants.VALID_ID;

public class ProductSmokeTest extends BaseTest {

    @Test(description = "CT003.001")
    public void shouldCreateProductTest() {
        productClient
                .createValidProduct()
                .statusCode(SC_CREATED);
    }

    @Test(description = "CT004.001")
    public void shouldDeleteProductTest() {
        productClient
                .deleteProductById(VALID_ID)
                .statusCode(SC_OK);
    }

    @Test(description = "CT004.001")
    public void shouldListProductsTest() {
        productClient
                .listAllProducts()
                .statusCode(SC_OK);
    }

    @Test(description = "CT006.002")
    public void shouldListProductByIdTest() {
        productClient
                .listProductById(VALID_ID)
                .statusCode(SC_OK);
    }

    @Test(description = "CT006.002")
    public void updateValidProductTest() {
        productClient
                .updateProductById()
                .statusCode(SC_OK);
    }
}
