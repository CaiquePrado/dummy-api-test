package contract;

import base.BaseTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.apache.http.HttpStatus.*;
import static utils.ApplicationConstants.*;

public class UserContractTest extends BaseTest {

    @Test
    public void shouldCreateUserContractTest() {
        userClient
                .createValidUser()
                .statusCode(SC_CREATED)
                .body(matchesJsonSchema(new File(POST_USER_SCHEMA)));
    }

    @Test(description = "CT004.001")
    public void shouldDeleteUserContractTest() {
        userClient
                .deleteUserById(VALID_ID)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(DELETE_USER_SCHEMA)));
    }

    @Test(description = "CT004.001")
    public void shouldListUsersContractTest() {
        userClient
                .listAllUsers()
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(GET_USERS_SCHEMA)));
    }

    @Test(description = "CT006.002")
    public void shouldListUserByIdContractTest() {
        userClient
                .listUserById(VALID_ID)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(GET_USER_SCHEMA)));
    }

    @Test(description = "CT006.002")
    public void updateValidUserContractTest() {
        userClient
                .updateUserById(VALID_ID)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(PUT_USER_SCHEMA)));
    }

    @Test(description = "CT004.001")
    public void shouldNotDeleteUserContractTest() {
        userClient
                .deleteUserById(INVALID_ID)
                .statusCode(SC_BAD_REQUEST)
                .body(matchesJsonSchema(new File(DELETE_GET_INVALID_PRODUCT_SCHEMA)));
    }

    @Test(description = "CT006.002")
    public void shouldNotListUserByIdContractTest() {
        userClient
                .listUserById(INVALID_ID)
                .statusCode(SC_BAD_REQUEST)
                .body(matchesJsonSchema(new File(DELETE_GET_INVALID_PRODUCT_SCHEMA)));
    }

    @Test
    public void shouldPaginateUsersTest() {
        userClient
                .searchUsersByPage(VALID_LIMIT)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(GET_LIMIT_USER_SCHEMA)));
    }

    @Test
    public void shouldListUsersOrderTest() {
        userClient
                .listUsersByOrder(VALID_ORDER)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(GET_ORDER_USER_SCHEMA)));
    }

    @Test
    public void shouldNotListUsersWithInvalidOrderTest() {
        userClient
                .listUsersByOrder(INVALID_ORDER)
                .statusCode(SC_BAD_REQUEST)
                .body(matchesJsonSchema(new File(GET_INVALID_ORDER_PRODUCT_SCHEMA)));
    }
}