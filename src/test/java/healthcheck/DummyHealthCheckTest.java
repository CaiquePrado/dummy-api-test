package healthcheck;

import static org.apache.http.HttpStatus.SC_OK;

import org.testng.annotations.Test;

import base.BaseTest;

public class DummyHealthCheckTest extends BaseTest {

    @Test(description = "HealthCheckTest")
    public void HealthCheckTest(){
        productClient
        .getHealth()
        .statusCode(SC_OK);
    }
}
