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
    public static final String HTTP_200_CATEGORY = "/products/category-list";
    public static final String HTTP_200_PRODUCT_CATEGORY = "/products/category/%s";
    public static final String HTTP_ORDER = "/products?sortBy=title&order=%s";

    public static final String HTTP_USER_201_CREATED = "/users/add";
    public static final String HTTP_USER_200_DELETED = "/users/{id}";
    public static final String HTTP_USER_200_LIST = "/users";
    public static final String HTTP_USER_200_BY_ID = "/users/{id}";
    public static final String HTTP_USER_ORDER = "/users?sortBy=firstname&order=%s";
    public static final String HTTP_200_USER_LIMIT_SKIP_SELECT = "/users?limit=%d&skip=%d&select=%s";
    public static final String HTTP_USER_200_SELECT = "/users?select=%s";
    public static final String HTTP_USER_400_SKIP = "/users?skip=''";
    public static final String HTTP_USER_200_SKIP = "/users?skip=%d";
    public static final String HTTP_USER_400_LIMIT = "/users?limit=''";
    public static final String HTTP_USER_200_LIMIT = "/users?limit=%d";
    public static final String HTTP_USER_200_SEARCH = "/users/search?q=%s";
}