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
    public static final String HTTP_400_LIMIT = "/products?limit=''";
    public static final String HTTP_200_SKIP = "/products?skip=%d";
    public static final String HTTP_400_SKIP = "/products?skip=''";
    public static final String HTTP_200_SELECT = "/products?select=%s";
    public static final String HTTP_200_LIMIT_SKIP_SELECT = "/products?limit=%d&skip=%d&select=%s";
    public static final String HTTP_200_CATEGORY = "/products/categories";
    public static final String HTTP_200_PRODUCT_CATEGORY = "/products/category-list";
}