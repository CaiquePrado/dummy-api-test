package healthcheck;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_OK;

public class DummyHealthCheckTest extends BaseTest {

    @Test(description = "HealthCheckTest")
    public void HealthCheckTest() {
        productClient
                .getHealth()
                .statusCode(SC_OK);
    }
}
