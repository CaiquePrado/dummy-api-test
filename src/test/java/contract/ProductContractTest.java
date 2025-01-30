package contract;

import client.BaseTest;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.apache.http.HttpStatus.*;
import java.io.File;
import static constants.ApplicationConstants.*;

public class ProductContractTest extends BaseTest {

    @Test
    public void shouldCreateProductContractTest(){
        dummyClient
        .createValidProduct()
        .statusCode(SC_CREATED)
        .body(matchesJsonSchema(new File(SCHEMAS + POST_PRODUCT_SCHEMA)));
    }

    @Test(description = "CT004.001")
    public void shouldDeleteProductContractTest(){
        dummyClient
        .deleteProductById()
        .statusCode(SC_OK)
        .body(matchesJsonSchema(new File(SCHEMAS + DELETE_PRODUCT_SCHEMA)));
    }

    @Test(description = "CT004.001")
    public void shouldListProductsContractTest(){
        dummyClient
        .listAllProducts()
        .statusCode(SC_OK)
        .body(matchesJsonSchema(new File(SCHEMAS + GET_PRODUCTS_SCHEMA)));
    }

    @Test(description = "CT006.002")
    public void shouldListProductByIdContractTest(){
        dummyClient
        .listProductById()
        .statusCode(SC_OK)
        .body(matchesJsonSchema(new File(SCHEMAS + GET_PRODUCT_SCHEMA)));
    }

    @Test(description = "CT006.002")
    public void updateValidProductContractTest(){
        dummyClient
        .updateProductById()
        .statusCode(SC_OK)
        .body(matchesJsonSchema(new File(SCHEMAS + PUT_PRODUCT_SCHEMA)));
    }

}
