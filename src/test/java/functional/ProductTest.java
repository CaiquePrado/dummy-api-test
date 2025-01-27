package functional;

import static org.apache.http.HttpStatus.*;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import client.BaseTest;

public class ProductTest extends BaseTest {

    @Test(description = "CT003.001")
    public void shouldCreateProduct(){
        dummyClient
        .createValidProduct()
        .statusCode(SC_CREATED);
    }


    @DataProvider(name = "productIds")
    public Object[][] productIds() {
        return new Object[][] {
                { 1 },
                { 2 },
                { 3 }
        };
    }


    @Test(description = "CT004.001")
    public void shouldDeleteProduct(){
        dummyClient
        .deleteProductById()
        .statusCode(SC_OK);
    }
}
