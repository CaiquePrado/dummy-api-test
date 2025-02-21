package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access =  AccessLevel.PRIVATE)
public class ApplicationConstants {
  public static final String ENV = "env";
  public static final String UAT = "uat";
  public static final String VALID_ID = "1";
  public static final String INVALID_ID = "&";
  public static final int VALID_LIMIT = 10;
  public static final int VALID_SKIP = 10;
  public static final String VALID_SELECT = "title,price";
  public static final String VALID_NAME = "phone";

  public static final String SCHEMAS = "src/test/resources/schemas";
  public static final String POST_PRODUCT_SCHEMA = "/POST-product-contract.json";
  public static final String GET_PRODUCTS_SCHEMA = "/GET-products-contract.json";
  public static final String GET_PRODUCT_SCHEMA = "/GET-product-contract.json";
  public static final String DELETE_PRODUCT_SCHEMA = "/DELETE-product-contract.json";
  public static final String PUT_PRODUCT_SCHEMA = "/PUT-product-contract.json";
  public static final String DELETE_GET_INVALID_PRODUCT_SCHEMA = "/GET-DELETE-invalid-product-contract.json";
  public static final String GET_SEARCH_PRODUCT_SCHEMA = "/GET-search-product-contract.json";

  public static final String POST_USER_SCHEMA = "/POST-product-contract.json";
  public static final String GET_USER_SCHEMA = "/GET-user-contract.json";
  public static final String GET_USERS_SCHEMA = "/GET-users-contract.json";
  public static final String DELETE_USER_SCHEMA = "/DELETE-user-contract.json";
  public static final String PUT_USER_SCHEMA = "/PUT-user-contract.json";
}
