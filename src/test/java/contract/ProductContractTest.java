package contract;

import base.BaseTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.apache.http.HttpStatus.*;
import static utils.ApplicationConstants.*;

public class ProductContractTest extends BaseTest {

    @Test
    public void shouldCreateProductContractTest() {
        productClient
                .createValidProduct()
                .statusCode(SC_CREATED)
                .body(matchesJsonSchema(new File(SCHEMAS_PRODUCT + POST_PRODUCT_SCHEMA)));
    }

    @Test(description = "CT004.001")
    public void shouldDeleteProductContractTest() {
        productClient
                .deleteProductById(VALID_ID)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(SCHEMAS_PRODUCT + DELETE_PRODUCT_SCHEMA)));
    }

    @Test(description = "CT004.001")
    public void shouldListProductsContractTest() {
        productClient
                .listAllProducts()
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(SCHEMAS_PRODUCT + GET_PRODUCTS_SCHEMA)));
    }

    @Test(description = "CT006.002")
    public void shouldListProductByIdContractTest() {
        productClient
                .listProductById(VALID_ID)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(SCHEMAS_PRODUCT + GET_PRODUCT_SCHEMA)));
    }

    @Test(description = "CT006.002")
    public void updateValidProductContractTest() {
        productClient
                .updateProductById()
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(SCHEMAS_PRODUCT + PUT_PRODUCT_SCHEMA)));
    }

    @Test(description = "CT004.001")
    public void shouldNotDeleteProductContractTest() {
        productClient
                .deleteProductById(INVALID_ID)
                .statusCode(SC_NOT_FOUND)
                .body(matchesJsonSchema(new File(SCHEMAS_PRODUCT + DELETE_GET_INVALID_PRODUCT_SCHEMA)));
    }

    @Test(description = "CT006.002")
    public void shouldNotListProductByIdContractTest() {
        productClient
                .listProductById(INVALID_ID)
                .statusCode(SC_NOT_FOUND)
                .body(matchesJsonSchema(new File(SCHEMAS_PRODUCT + DELETE_GET_INVALID_PRODUCT_SCHEMA)));
    }

    @Test
    public void shouldSearchProductByNameTest() {
        productClient
                .searchProductByName(VALID_NAME)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(SCHEMAS_PRODUCT + GET_SEARCH_PRODUCT_SCHEMA)));
    }

    @Test
    public void shouldPaginateProductsTest() {
        productClient
                .searchProductsByPage(VALID_LIMIT)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(SCHEMAS_PRODUCT + GET_LIMIT_PRODUCT_SCHEMA)));
    }
}
