package client;

import static io.restassured.RestAssured.given;
import static utils.ApplicationConstants.VALID_ID;
import static utils.ApplicationConstants.*;
import static utils.EndpointConstants.*;

import dto.Product;
import factory.ProductFactory;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ProductClient {

    private final RequestSpecification requestSpec;

    public ProductClient(RequestSpecification requestSpec) {
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

    public ValidatableResponse deleteProductById(String productId){
        return given().spec(requestSpec)
        .when()
        .delete(HTTP_200_DELETED,productId)
        .then();
    }

    public ValidatableResponse listAllProducts(){
        return given().spec(requestSpec)
        .when()
        .get(HTTP_200_LIST)
        .then();
    }

    public ValidatableResponse listProductById(String productId){
        return given().spec(requestSpec)
        .when()
        .get(HTTP_200_BY_ID, productId)
        .then();
    }

    public ValidatableResponse updateProductById(){
        return given().spec(requestSpec)
        .body(ProductFactory.validUpdateProductFactory())
        .when()
        .put(HTTP_200_BY_ID, VALID_ID)
        .then();
    }

    public ValidatableResponse createValidProductOneAttribute(Product product){
        return given().spec(requestSpec)
        .body(product)
        .when()
        .post(HTTP_201_CREATED)
        .then();
    }

    public ValidatableResponse searchProductByName(String search){
        return given().spec(requestSpec)
        .when()
        .get(String.format(HTTP_200_SEARCH, search))
        .then();
    }

    public ValidatableResponse searchProductsByPage(int limit){
        return  given().spec(requestSpec)
        .when()
        .get(String.format(HTTP_200_LIMIT, limit))
        .then();
    }

    public ValidatableResponse searchProductsByPage(){
        return  given().spec(requestSpec)
        .when()
        .get(String.format(HTTP_400_LIMIT))
        .then();
    }

    public ValidatableResponse skipProductsByPage(){
        return  given().spec(requestSpec)
        .when()
        .get(String.format(HTTP_400_SKIP))
        .then();
    }

    public ValidatableResponse skipProductsByPage(int skip){
        return  given().spec(requestSpec)
        .when()
        .get(String.format(HTTP_200_SKIP, skip))
        .then();
    }

    public ValidatableResponse selectProductByAttribute(String attribute){
        return given().spec(requestSpec)
        .when()
        .get(String.format(HTTP_200_SELECT, attribute))
        .then();
    }

    public ValidatableResponse selectLimitSkipProducts ( ){
        return given().spec(requestSpec)
        .when()
        .get(String.format(HTTP_200_LIMIT_SKIP_SELECT,VALID_LIMIT, VALID_SKIP, VALID_SELECT))
        .then();
    }

    public ValidatableResponse listAllCategories(){
        return given().spec(requestSpec)
        .when()
        .get(HTTP_200_CATEGORY)
        .then();
    }

    public ValidatableResponse listProductsByCategory(String category){
        return given().spec(requestSpec)
        .when()
        .get(String.format(HTTP_200_PRODUCT_CATEGORY, category))
        .then();
    }

    public ValidatableResponse listProductsByOrder(String order){
        return given().spec(requestSpec)
        .when()
        .get(String.format(HTTP_ORDER, order))
        .then();
    }
}