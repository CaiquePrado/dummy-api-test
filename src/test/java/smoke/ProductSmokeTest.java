package smoke;

import static org.apache.http.HttpStatus.*;

import org.testng.annotations.Test;

import base.BaseTest;

public class ProductSmokeTest extends BaseTest {

    @Test(description = "CT003.001")
    public void shouldCreateProductTest(){
        dummyClient
        .createValidProduct()
        .statusCode(SC_CREATED);
    }

    @Test(description = "CT004.001")
    public void shouldDeleteProductTest(){
        dummyClient
        .deleteProductById()
        .statusCode(SC_OK);
    }

    @Test(description = "CT004.001")
    public void shouldListProductsTest(){
        dummyClient
        .listAllProducts()
        .statusCode(SC_OK);
    }

    @Test(description = "CT006.002")
    public void shouldListProductByIdTest(){
        dummyClient
        .listProductById()
        .statusCode(SC_OK);
    }

    @Test(description = "CT006.002")
    public void updateValidProductTest() {
        dummyClient
        .updateProductById()
        .statusCode(SC_OK);
    }
}
