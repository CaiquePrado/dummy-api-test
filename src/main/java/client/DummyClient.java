package client;

import static constants.EndpointConstants.HTTP_200_CREATED;
import static constants.EndpointConstants.HTTP_200_UP;
import static io.restassured.RestAssured.given;

import factory.ProductFactory;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DummyClient {

    private final RequestSpecification requestSpec;

    public DummyClient(RequestSpecification requestSpec) {
        this.requestSpec = requestSpec;
    }

    public ValidatableResponse getHealth(){
        return given().spec(requestSpec)
        .when()
        .get(HTTP_200_UP)
        .then();
    }

    public ValidatableResponse createValidProduct(){
        return given().spec(requestSpec)
        .body(ProductFactory.validProductFactory())
        .when()
        .post(HTTP_200_CREATED)
        .then()
        .log().all();
    }
}