package contract;

import client.BaseTest;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.apache.http.HttpStatus.SC_CREATED;
import java.io.File;
import static constants.ApplicationConstants.*;

public class ProductContractTest extends BaseTest {

    @Test
    public void shouldCreateProductContractTest(){
        dummyClient
        .createValidProduct()
        .statusCode(SC_CREATED)
        .body(matchesJsonSchema(new File(SCHEMAS + POST_PRODUCT_SCHEMA)));
    }

}
