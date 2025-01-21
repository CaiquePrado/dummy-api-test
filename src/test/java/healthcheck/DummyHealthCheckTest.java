package healthcheck;

import static org.apache.http.HttpStatus.SC_OK;

import org.testng.annotations.Test;

import client.BaseTest;

public class DummyHealthCheckTest extends BaseTest {

    @Test(description = "HealthCheckTest")
    public void HealthCheckTest(){
        dummyClient.getHealth()
        .statusCode(SC_OK);
    }
}
