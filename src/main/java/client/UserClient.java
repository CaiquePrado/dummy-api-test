package client;

import factory.UserFactory;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static utils.ApplicationConstants.VALID_ID;
import static utils.EndpointConstants.*;

public class UserClient {

    private final RequestSpecification requestSpec;

    public UserClient(RequestSpecification requestSpec) {
        this.requestSpec = requestSpec;
    }

    public ValidatableResponse createValidUser(){
        return given().spec(requestSpec)
                .body(UserFactory.createValidUserFactory())
                .when()
                .post(HTTP_USER_201_CREATED)
                .then();
    }

    public ValidatableResponse deleteUserById(String userId){
        return given().spec(requestSpec)
                .when()
                .delete(HTTP_USER_200_DELETED,userId)
                .then();
    }

    public ValidatableResponse listAllUsers(){
        return given().spec(requestSpec)
                .when()
                .get(HTTP_USER_200_LIST)
                .then();
    }

    public ValidatableResponse listUserById(String userId){
        return given().spec(requestSpec)
                .when()
                .get(HTTP_USER_200_BY_ID, userId)
                .then();
    }

    public ValidatableResponse updateUserById(){
        return given().spec(requestSpec)
                .body(UserFactory.validUpdateUserFactory())
                .when()
                .put(HTTP_USER_200_BY_ID, VALID_ID)
                .then();
    }

}
