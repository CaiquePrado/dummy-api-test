package smoke;

import static org.apache.http.HttpStatus.*;

import org.testng.annotations.Test;

import client.BaseTest;

public class ProductSmokeTest extends BaseTest {

    @Test(description = "CT003.001")
    public void shouldCreateProduct(){
        dummyClient
        .createValidProduct()
        .statusCode(SC_CREATED);
    }

    @Test(description = "CT004.001")
    public void shouldDeleteProduct(){
        dummyClient
        .deleteProductById()
        .statusCode(SC_OK);
    }

    @Test(description = "CT004.001")
    public void shouldListProducts(){
        dummyClient
        .listAllProducts()
        .statusCode(SC_OK);
    }

    @Test(description = "CT006.002")
    public void shouldListProductById(){
        dummyClient
        .listProductById()
        .statusCode(SC_OK);
    }
}
