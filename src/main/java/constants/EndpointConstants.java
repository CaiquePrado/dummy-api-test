package constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EndpointConstants {
    public static final String HTTP_200_UP = "http/200/UP";
    public static final String HTTP_201_CREATED = "/products/add";
    public static final String HTTP_200_DELETED = "/products/{id}";
}
