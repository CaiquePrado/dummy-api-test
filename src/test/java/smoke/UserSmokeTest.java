package smoke;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static utils.ApplicationConstants.VALID_ID;

public class UserSmokeTest extends BaseTest {

    @Test(description = "CT003.001")
    public void shouldCreateUserTest() {
        userClient
                .createValidUser()
                .statusCode(SC_CREATED);
    }

    @Test(description = "CT004.001")
    public void shouldDeleteUserTest() {
        userClient
                .deleteUserById(VALID_ID)
                .statusCode(SC_OK);
    }

    @Test(description = "CT004.001")
    public void shouldListUsersTest() {
        userClient
                .listAllUsers()
                .statusCode(SC_OK);
    }

    @Test(description = "CT006.002")
    public void shouldListUserByIdTest() {
        userClient
                .listUserById(VALID_ID)
                .statusCode(SC_OK);
    }

    @Test(description = "CT006.002")
    public void updateValidUserTest() {
        userClient
                .updateUserById()
                .statusCode(SC_OK);
    }
}
