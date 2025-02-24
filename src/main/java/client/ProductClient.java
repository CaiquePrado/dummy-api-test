package client;

import dto.Product;
import factory.ProductFactory;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static utils.ApplicationConstants.*;
import static utils.EndpointConstants.*;

public class ProductClient {

    private final RequestSpecification requestSpec;

    public ProductClient(RequestSpecification requestSpec) {
        this.requestSpec = requestSpec;
    }

    public ValidatableResponse getHealth() {
        return executeGetRequest(PRODUCT_STATUS);
    }

    public ValidatableResponse createValidProduct() {
        return createProduct(ProductFactory.validProductFactory());
    }

    public ValidatableResponse deleteProductById(String productId) {
        return executeDeleteRequest(productId);
    }

    public ValidatableResponse listAllProducts() {
        return executeGetRequest(PRODUCT_LIST);
    }

    public ValidatableResponse listProductById(String productId) {
        return executeGetRequest(PRODUCT_BY_ID, productId);
    }

    public ValidatableResponse updateProductById(String productId) {
        return executePutRequest(ProductFactory.validUpdateProductFactory(), productId);
    }

    public ValidatableResponse createProductWithAttributes(Product product) {
        return createProduct(product);
    }

    public ValidatableResponse searchProductByName(String search) {
        return executeGetRequest(String.format(PRODUCT_SEARCH, search));
    }

    public ValidatableResponse searchProductsByPage(int limit) {
        return executeGetRequest(String.format(PRODUCT_LIMIT, limit));
    }

    public ValidatableResponse searchProductsByPage() {
        return executeGetRequest(PRODUCT_LIMIT_INVALID);
    }

    public ValidatableResponse skipProductsByPage() {
        return executeGetRequest(PRODUCT_SKIP_INVALID);
    }

    public ValidatableResponse skipProductsByPage(int skip) {
        return executeGetRequest(String.format(PRODUCT_SKIP, skip));
    }

    public ValidatableResponse selectProductByAttribute(String attribute) {
        return executeGetRequest(String.format(PRODUCT_SELECT, attribute));
    }

    public ValidatableResponse selectLimitSkipProducts() {
        return executeGetRequest(String.format(PRODUCT_LIST_PAGINATED, VALID_LIMIT, VALID_SKIP, VALID_SELECT));
    }

    public ValidatableResponse listAllCategories() {
        return executeGetRequest(PRODUCT_CATEGORIES);
    }

    public ValidatableResponse listProductsByCategory(String category) {
        return executeGetRequest(String.format(PRODUCT_BY_CATEGORY, category));
    }

    public ValidatableResponse listProductsByOrder(String order) {
        return executeGetRequest(String.format(PRODUCT_SORT, order));
    }

    // Private helper methods
    private ValidatableResponse createProduct(Object body) {
        return given().spec(requestSpec)
                .body(body)
                .when()
                .post(PRODUCT_CREATE)
                .then();
    }

    private ValidatableResponse executeDeleteRequest(Object... pathParams) {
        return given().spec(requestSpec)
                .when()
                .delete(PRODUCT_BY_ID, pathParams)
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
                .put(PRODUCT_BY_ID, pathParams)
                .then();
    }
}