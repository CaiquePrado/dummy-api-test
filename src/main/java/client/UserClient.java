package client;

import dto.User;
import factory.UserFactory;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static utils.ApplicationConstants.*;
import static utils.EndpointConstants.*;

public class UserClient {

    private final RequestSpecification requestSpec;

    public UserClient(RequestSpecification requestSpec) {
        this.requestSpec = requestSpec;
    }

    public ValidatableResponse createValidUser() {
        return createUser(UserFactory.createValidUserFactory());
    }

    public ValidatableResponse createUserWithAttributes(User user) {
        return createUser(user);
    }

    public ValidatableResponse deleteUserById(String userId) {
        return executeDeleteRequest(userId);
    }

    public ValidatableResponse listAllUsers() {
        return executeGetRequest(USER_LIST);
    }

    public ValidatableResponse listUserById(String userId) {
        return executeGetRequest(USER_BY_ID, userId);
    }

    public ValidatableResponse searchUsersByPage(int limit) {
        return executeGetRequest(String.format(USER_LIMIT, limit));
    }

    public ValidatableResponse searchUsersByPage() {
        return executeGetRequest(USER_LIMIT_INVALID);
    }

    public ValidatableResponse skipUsersByPage() {
        return executeGetRequest(USER_SKIP_INVALID);
    }

    public ValidatableResponse skipUsersByPage(int skip) {
        return executeGetRequest(String.format(USER_SKIP, skip));
    }

    public ValidatableResponse selectUserByAttribute(String attribute) {
        return executeGetRequest(String.format(USER_SELECT, attribute));
    }

    public ValidatableResponse selectLimitSkipUsers() {
        return executeGetRequest(String.format(USER_LIST_PAGINATED, VALID_LIMIT, VALID_SKIP, VALID_SELECT));
    }

    public ValidatableResponse updateUserById(String userId) {
        return executePutRequest(UserFactory.validUpdateUserFactory(), userId);
    }

    public ValidatableResponse listUsersByOrder(String order) {
        return executeGetRequest(String.format(USER_SORT, order));
    }

    private ValidatableResponse createUser(Object body) {
        return given().spec(requestSpec)
                .body(body)
                .when()
                .post(USER_CREATE)
                .then();
    }

    private ValidatableResponse executeDeleteRequest(Object... pathParams) {
        return given().spec(requestSpec)
                .when()
                .delete(USER_DELETE, pathParams)
                .then();
    }

    private ValidatableResponse executeGetRequest(String endpoint, Object... pathParams) {
        return given().spec(requestSpec)
                .when()
                .get(endpoint, pathParams)
                .then();
    }

    private ValidatableResponse executePutRequest(Object body, Object... pathParams) {
        return given().spec(requestSpec)
                .body(body)
                .when()
                .put(USER_BY_ID, pathParams)
                .then();
    }

    public ValidatableResponse login(User user) {
        return given().spec(requestSpec)
                .body(user)
                .when()
                .post(USER_LOGIN)
                .then();
    }
}