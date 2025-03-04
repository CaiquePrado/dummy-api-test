package contract;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.apache.http.HttpStatus.*;
import static smoke.UserSmokeTest.shouldLoginUserTest;
import static utils.ApplicationConstants.*;

public class ProductContractTest extends BaseTest {

    @BeforeClass
    public void setup() {
        shouldLoginUserTest();
    }

    @Test(description = "should create product successfully")
    public void shouldCreateProductContractTest() {
        productClient
                .createValidProduct()
                .statusCode(SC_CREATED)
                .body(matchesJsonSchema(new File(POST_PRODUCT_SCHEMA)));
    }

    @Test(description = "should delete product by valid ID")
    public void shouldDeleteProductContractTest() {
        productClient
                .deleteProductById(VALID_ID)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(DELETE_PRODUCT_SCHEMA)));
    }

    @Test(description = "should list all products successfully")
    public void shouldListProductsContractTest() {
        productClient
                .listAllProducts()
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(GET_PRODUCTS_SCHEMA)));
    }

    @Test(description = "should list product by valid ID")
    public void shouldListProductByIdContractTest() {
        productClient
                .listProductById(VALID_ID)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(GET_PRODUCT_SCHEMA)));
    }

    @Test(description = "should update product by valid ID")
    public void updateValidProductContractTest() {
        productClient
                .updateProductById(VALID_ID)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(PUT_PRODUCT_SCHEMA)));
    }

    @Test(description = "should not delete product with invalid ID")
    public void shouldNotDeleteProductContractTest() {
        productClient
                .deleteProductById(INVALID_ID)
                .statusCode(SC_NOT_FOUND)
                .body(matchesJsonSchema(new File(DELETE_GET_INVALID_PRODUCT_SCHEMA)));
    }

    @Test(description = "should not list product with invalid ID")
    public void shouldNotListProductByIdContractTest() {
        productClient
                .listProductById(INVALID_ID)
                .statusCode(SC_NOT_FOUND)
                .body(matchesJsonSchema(new File(DELETE_GET_INVALID_PRODUCT_SCHEMA)));
    }

    @Test(description = "should search product by name")
    public void shouldSearchProductByNameContractTest() {
        productClient
                .searchProductByName(VALID_NAME)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(GET_SEARCH_PRODUCT_SCHEMA)));
    }

    @Test(description = "should paginate products with valid limit")
    public void shouldPaginateProductsContractTest() {
        productClient
                .searchProductsByPage(VALID_LIMIT)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(GET_LIMIT_PRODUCT_SCHEMA)));
    }

    @Test(description = "should list products by category")
    public void shouldListProductsByCategoryContractTest() {
        productClient
                .listProductsByCategory(VALID_CATEGORY)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(GET_CATEGORY_PRODUCT_SCHEMA)));
    }

    @Test(description = "should list products by order")
    public void shouldListProductsOrderContractTest() {
        productClient
                .listProductsByOrder(VALID_ORDER)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(GET_ORDER_PRODUCT_SCHEMA)));
    }

    @Test(description = "should not list products with invalid order")
    public void shouldNotListProductsWithInvalidOrderContractTest() {
        productClient
                .listProductsByOrder(INVALID_ORDER)
                .statusCode(SC_BAD_REQUEST)
                .body(matchesJsonSchema(new File(GET_INVALID_ORDER_PRODUCT_SCHEMA)));
    }

    @Test(description = "should not access with invalid token")
    public void shouldNotAccessWithInvalidToken() {
        productClient
                .listAllProductsWithToken(INVALID_TOKEN)
                .statusCode(SC_INTERNAL_SERVER_ERROR)
                .body(matchesJsonSchema(new File(DELETE_GET_INVALID_PRODUCT_SCHEMA)));
    }

    @Test(description = "should not access with expired token")
    public void shouldNotAccessWithExpiredToken() {
        productClient
                .listAllProductsWithToken(EXPIRED_TOKEN)
                .statusCode(SC_INTERNAL_SERVER_ERROR)
                .body(matchesJsonSchema(new File(DELETE_GET_INVALID_PRODUCT_SCHEMA)));
    }
}
