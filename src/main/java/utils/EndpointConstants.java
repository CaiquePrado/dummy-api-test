package utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EndpointConstants {
    
    private static final String PRODUCTS_BASE = "/products";
    private static final String USERS_BASE = "/users";
    private static final String ID_PATH = "/{id}";

    private static final String LIMIT_PARAM = "?limit=%d";
    private static final String SKIP_PARAM = "?skip=%d";
    private static final String SELECT_PARAM = "?select=%s";
    private static final String SEARCH_PARAM = "/search?q=%s";

    public static final String PRODUCT_STATUS = "http/200/UP";
    public static final String PRODUCT_CREATE = PRODUCTS_BASE + "/add";
    public static final String PRODUCT_LIST = PRODUCTS_BASE;
    public static final String PRODUCT_BY_ID = PRODUCTS_BASE + ID_PATH;
    public static final String PRODUCT_SEARCH = PRODUCTS_BASE + SEARCH_PARAM;
    public static final String PRODUCT_LIMIT = PRODUCTS_BASE + LIMIT_PARAM;
    public static final String PRODUCT_LIMIT_INVALID = PRODUCTS_BASE + "?limit=''";
    public static final String PRODUCT_SKIP = PRODUCTS_BASE + SKIP_PARAM;
    public static final String PRODUCT_SKIP_INVALID = PRODUCTS_BASE + "?skip=''";
    public static final String PRODUCT_SELECT = PRODUCTS_BASE + SELECT_PARAM;
    public static final String PRODUCT_LIST_PAGINATED = PRODUCTS_BASE + "?limit=%d&skip=%d&select=%s";
    public static final String PRODUCT_CATEGORIES = PRODUCTS_BASE + "/category-list";
    public static final String PRODUCT_BY_CATEGORY = PRODUCTS_BASE + "/category/%s";
    public static final String PRODUCT_SORT = PRODUCTS_BASE + "?sortBy=title&order=%s";

    public static final String USER_CREATE = USERS_BASE + "/add";
    public static final String USER_DELETE = USERS_BASE + ID_PATH;
    public static final String USER_LIST = USERS_BASE;
    public static final String USER_BY_ID = USERS_BASE + ID_PATH;
    public static final String USER_SORT = USERS_BASE + "?sortBy=firstname&order=%s";
    public static final String USER_LIST_PAGINATED = USERS_BASE + "?limit=%d&skip=%d&select=%s";
    public static final String USER_SELECT = USERS_BASE + SELECT_PARAM;
    public static final String USER_SKIP = USERS_BASE + SKIP_PARAM;
    public static final String USER_SKIP_INVALID = USERS_BASE + "?skip=''";
    public static final String USER_LIMIT = USERS_BASE + LIMIT_PARAM;
    public static final String USER_LIMIT_INVALID = USERS_BASE + "?limit=''";
}