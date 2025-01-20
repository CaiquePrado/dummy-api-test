package spec;

import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.http.ContentType.JSON;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import utils.PropertiesUtils;

@NoArgsConstructor(access =  AccessLevel.PRIVATE)
public class ServerSpecification {
  
  public static final String DUMMY_URI = "dummy-baseuri";

  public static RequestSpecBuilder requestSpecBuilder(){
    return new RequestSpecBuilder()
    .setContentType(JSON)
    .setAccept(JSON)
    .log(ALL);
  }

  public static RequestSpecification getRequestSpecification(){
    return requestSpecBuilder()
    .setAccept(JSON)
    .setBaseUri(PropertiesUtils.getBaseURI(DUMMY_URI))
    .build();
  }
}
