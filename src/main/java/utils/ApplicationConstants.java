package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access =  AccessLevel.PRIVATE)
public class ApplicationConstants {
  public static final String ENV = "env";
  public static final String UAT = "uat";
  public static final String VALID_ID = "1";

  public static final String SCHEMAS = "src/test/resources/schemas";
  public static final String POST_PRODUCT_SCHEMA = "/POST-product-contract.json";
  public static final String GET_PRODUCTS_SCHEMA = "/GET-products-contract.json";
  public static final String GET_PRODUCT_SCHEMA = "/GET-product-contract.json";
  public static final String DELETE_PRODUCT_SCHEMA = "/DELETE-product-contract.json";
  public static final String PUT_PRODUCT_SCHEMA = "/PUT-product-contract.json";
}
