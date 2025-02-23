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
        return given().spec(requestSpec)
                .body(UserFactory.createValidUserFactory())
                .when()
                .post(HTTP_USER_201_CREATED)
                .then();
    }

    public ValidatableResponse createValidUserOneAttribute(User user) {
        return given().spec(requestSpec)
                .body(user)
                .when()
                .post(HTTP_201_CREATED)
                .then();
    }

    public ValidatableResponse deleteUserById(String userId) {
        return given().spec(requestSpec)
                .when()
                .delete(HTTP_USER_200_DELETED, userId)
                .then();
    }

    public ValidatableResponse listAllUsers() {
        return given().spec(requestSpec)
                .when()
                .get(HTTP_USER_200_LIST)
                .then();
    }

    public ValidatableResponse listUserById(String userId) {
        return given().spec(requestSpec)
                .when()
                .get(HTTP_USER_200_BY_ID, userId)
                .then();
    }

    public ValidatableResponse searchUserByName(String search) {
        return given().spec(requestSpec)
                .when()
                .get(String.format(HTTP_USER_200_SEARCH, search))
                .then();
    }

    public ValidatableResponse searchUsersByPage(int limit) {
        return given().spec(requestSpec)
                .when()
                .get(String.format(HTTP_USER_200_LIMIT, limit))
                .then();
    }

    public ValidatableResponse searchUsersByPage() {
        return given().spec(requestSpec)
                .when()
                .get(String.format(HTTP_USER_400_LIMIT))
                .then();
    }

    public ValidatableResponse skipUsersByPage() {
        return given().spec(requestSpec)
                .when()
                .get(String.format(HTTP_USER_400_SKIP))
                .then();
    }

    public ValidatableResponse skipUsersByPage(int skip) {
        return given().spec(requestSpec)
                .when()
                .get(String.format(HTTP_USER_200_SKIP, skip))
                .then();
    }

    public ValidatableResponse selectUserByAttribute(String attribute) {
        return given().spec(requestSpec)
                .when()
                .get(String.format(HTTP_USER_200_SELECT, attribute))
                .then();
    }

    public ValidatableResponse selectLimitSkipUsers() {
        return given().spec(requestSpec)
                .when()
                .get(String.format(HTTP_200_USER_LIMIT_SKIP_SELECT, VALID_LIMIT, VALID_SKIP, VALID_SELECT))
                .then();
    }

    public ValidatableResponse updateUserById() {
        return given().spec(requestSpec)
                .body(UserFactory.validUpdateUserFactory())
                .when()
                .put(HTTP_USER_200_BY_ID, VALID_ID)
                .then();
    }

    public ValidatableResponse listUsersByOrder(String order) {
        return given().spec(requestSpec)
                .when()
                .get(String.format(HTTP_USER_ORDER, order))
                .then();
    }

}
