package base;

import client.ProductClient;
import client.UserClient;
import config.PropertiesUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static io.restassured.http.ContentType.JSON;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseTest {
    private static final String DUMMY_URI = "dummy-baseuri";

    protected static final RequestSpecification spec = new RequestSpecBuilder()
            .setContentType(JSON)
            .setAccept(JSON)
            .setBaseUri(PropertiesUtils.getBaseURI(DUMMY_URI))
            .addFilter(new ResponseLoggingFilter())
            .addFilter(new RequestLoggingFilter())
            .build();

    protected static ProductClient productClient = new ProductClient(spec);
    protected static UserClient userClient = new UserClient(spec);

}
