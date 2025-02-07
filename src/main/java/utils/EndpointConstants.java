package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EndpointConstants {
    public static final String HTTP_200_UP = "http/200/UP";
    public static final String HTTP_201_CREATED = "/products/add";
    public static final String HTTP_200_DELETED = "/products/{id}";
    public static final String HTTP_200_LIST = "/products";
    public static final String HTTP_200_BY_ID = "/products/{id}";
    public static final String HTTP_200_SEARCH = "/products/search?q=%s";
    public static final String HTTP_200_LIMIT = "/products?limit=%d";
}