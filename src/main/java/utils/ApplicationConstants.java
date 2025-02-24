package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplicationConstants {

    public static final String ENV = "env";
    public static final String UAT = "uat";

    public static final String VALID_ID = "1";
    public static final String INVALID_ID = "&";
    public static final int VALID_LIMIT = 10;
    public static final int VALID_SKIP = 10;
    public static final String VALID_SELECT = "title,price";

    public static final String VALID_NAME = "phone";
    public static final String VALID_CATEGORY = "smartphones";
    public static final String VALID_ORDER = "asc";
    public static final String INVALID_ORDER = "random";

    private static final String SCHEMA_BASE_PATH = "src/test/resources/schemas";
    private static final String PRODUCT_SCHEMA_PATH = SCHEMA_BASE_PATH + "/product";
    private static final String USER_SCHEMA_PATH = SCHEMA_BASE_PATH + "/user";

    public static final String POST_PRODUCT_SCHEMA = PRODUCT_SCHEMA_PATH + "/POST-product-contract.json";
    public static final String GET_PRODUCTS_SCHEMA = PRODUCT_SCHEMA_PATH + "/GET-products-contract.json";
    public static final String GET_PRODUCT_SCHEMA = PRODUCT_SCHEMA_PATH + "/GET-product-contract.json";
    public static final String DELETE_PRODUCT_SCHEMA = PRODUCT_SCHEMA_PATH + "/DELETE-product-contract.json";
    public static final String PUT_PRODUCT_SCHEMA = PRODUCT_SCHEMA_PATH + "/PUT-product-contract.json";
    public static final String DELETE_GET_INVALID_PRODUCT_SCHEMA = PRODUCT_SCHEMA_PATH + "/GET-DELETE-invalid-product-contract.json";
    public static final String GET_SEARCH_PRODUCT_SCHEMA = PRODUCT_SCHEMA_PATH + "/GET-search-product-contract.json";
    public static final String GET_LIMIT_PRODUCT_SCHEMA = PRODUCT_SCHEMA_PATH + "/GET-limit-product-contract.json";
    public static final String GET_CATEGORY_PRODUCT_SCHEMA = PRODUCT_SCHEMA_PATH + "/GET-category-product-contract.json";
    public static final String GET_ORDER_PRODUCT_SCHEMA = PRODUCT_SCHEMA_PATH + "/GET-order-product-contract.json";
    public static final String GET_INVALID_ORDER_PRODUCT_SCHEMA = PRODUCT_SCHEMA_PATH + "/GET-invalid-order-product-contract.json";

    public static final String POST_USER_SCHEMA = USER_SCHEMA_PATH + "/POST-user-contract.json";
    public static final String GET_USER_SCHEMA = USER_SCHEMA_PATH + "/GET-user-contract.json";
    public static final String GET_USERS_SCHEMA = USER_SCHEMA_PATH + "/GET-users-contract.json";
    public static final String DELETE_USER_SCHEMA = USER_SCHEMA_PATH + "/DELETE-user-contract.json";
    public static final String PUT_USER_SCHEMA = USER_SCHEMA_PATH + "/PUT-user-contract.json";
    public static final String GET_ORDER_USER_SCHEMA = USER_SCHEMA_PATH + "/GET-order-user-contract.json";
    public static final String GET_LIMIT_USER_SCHEMA = USER_SCHEMA_PATH + "/GET-limit-user-contract.json";
}