package contract;

import base.BaseTest;
import org.testng.annotations.Test;

import java.io.File;

import static factory.UserFactory.invalidLoginFactory;
import static factory.UserFactory.validLoginFactory;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.apache.http.HttpStatus.*;
import static utils.ApplicationConstants.*;

public class UserContractTest extends BaseTest {

    @Test(description = "should login user with valid credentials")
    public void shouldLoginUserContractTest() {
        userClient
                .login(validLoginFactory())
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(POST_LOGIN_SCHEMA)));
    }

    @Test(description = "should not login user with invalid credentials")
    public void shouldNotLoginUserWithInvalidCredentialsContractTest() {
        userClient
                .login(invalidLoginFactory())
                .statusCode(SC_BAD_REQUEST)
                .body(matchesJsonSchema(new File(POST_INVALID_LOGIN_SCHEMA)));
    }

    @Test(description = "should create a user successfully")
    public void shouldCreateUserContractTest() {
        userClient
                .createValidUser()
                .statusCode(SC_CREATED)
                .body(matchesJsonSchema(new File(POST_USER_SCHEMA)));
    }

    @Test(description = "should delete user by ID")
    public void shouldDeleteUserContractTest() {
        userClient
                .deleteUserById(VALID_ID)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(DELETE_USER_SCHEMA)));
    }

    @Test(description = "should list all users successfully")
    public void shouldListUsersContractTest() {
        userClient
                .listAllUsers()
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(GET_USERS_SCHEMA)));
    }

    @Test(description = "should list user by valid ID")
    public void shouldListUserByIdContractTest() {
        userClient
                .listUserById(VALID_ID)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(GET_USER_SCHEMA)));
    }

    @Test(description = "should update user by valid ID")
    public void updateValidUserContractTest() {
        userClient
                .updateUserById(VALID_ID)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(PUT_USER_SCHEMA)));
    }

    @Test(description = "should not delete user with invalid ID")
    public void shouldNotDeleteUserContractTest() {
        userClient
                .deleteUserById(INVALID_ID)
                .statusCode(SC_BAD_REQUEST)
                .body(matchesJsonSchema(new File(DELETE_GET_INVALID_PRODUCT_SCHEMA)));
    }

    @Test(description = "should not list user with invalid ID")
    public void shouldNotListUserByIdContractTest() {
        userClient
                .listUserById(INVALID_ID)
                .statusCode(SC_BAD_REQUEST)
                .body(matchesJsonSchema(new File(DELETE_GET_INVALID_PRODUCT_SCHEMA)));
    }

    @Test(description = "should paginate users with valid limit")
    public void shouldPaginateUsersContractTest() {
        userClient
                .searchUsersByPage(VALID_LIMIT)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(GET_LIMIT_USER_SCHEMA)));
    }

    @Test(description = "should list users by order")
    public void shouldListUsersOrderContractTest() {
        userClient
                .listUsersByOrder(VALID_ORDER)
                .statusCode(SC_OK)
                .body(matchesJsonSchema(new File(GET_ORDER_USER_SCHEMA)));
    }

    @Test(description = "should not list users with invalid order")
    public void shouldNotListUsersWithInvalidOrderContractTest() {
        userClient
                .listUsersByOrder(INVALID_ORDER)
                .statusCode(SC_BAD_REQUEST)
                .body(matchesJsonSchema(new File(GET_INVALID_ORDER_PRODUCT_SCHEMA)));
    }
}
