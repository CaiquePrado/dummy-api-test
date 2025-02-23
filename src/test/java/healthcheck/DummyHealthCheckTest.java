package healthcheck;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;

public class DummyHealthCheckTest extends BaseTest {

    @Test(description = "HealthCheckTest")
    public void HealthCheckTest() {
        productClient
                .getHealth()
                .statusCode(SC_OK)
                .body("status", is(200))
                .body("message", is("UP"));
    }
}
