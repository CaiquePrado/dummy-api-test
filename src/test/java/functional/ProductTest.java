package functional;

import static org.apache.http.HttpStatus.SC_CREATED;

import org.testng.annotations.Test;

import client.BaseTest;

public class ProductTest extends BaseTest {

    @Test
    public void shouldCreateProduct(){
        dummyClient
        .createValidProduct()
        .statusCode(SC_CREATED);
    }
}
