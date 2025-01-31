package client;

import static io.restassured.RestAssured.given;
import static utils.ApplicationConstants.VALID_ID;
import static utils.EndpointConstants.*;

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
        .post(HTTP_201_CREATED)
        .then();
    }

    public ValidatableResponse deleteProductById(){
        return given().spec(requestSpec)
        .when()
        .delete(HTTP_200_DELETED,VALID_ID)
        .then();
    }

    public ValidatableResponse listAllProducts(){
        return given().spec(requestSpec)
        .when()
        .get(HTTP_200_LIST)
        .then();
    }

    public ValidatableResponse listProductById(){
        return given().spec(requestSpec)
        .when()
        .get(HTTP_200_BY_ID, VALID_ID)
        .then();
    }

    public ValidatableResponse updateProductById(){
        return given().spec(requestSpec)
        .body(ProductFactory.validUpdateProductFactory())
        .when()
        .put(HTTP_200_BY_ID, VALID_ID)
        .then();
    }
}