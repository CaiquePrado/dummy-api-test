package smoke;

import base.BaseTest;
import dto.User;
import org.testng.annotations.Test;

import static factory.UserFactory.*;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static utils.ApplicationConstants.VALID_ID;

public class UserSmokeTest extends BaseTest {

    @Test(description = "CT003.001")
    public void shouldCreateUserTest() {
        var expectedUser = userClient
                .createValidUser()
                .statusCode(SC_CREATED)
                .extract()
                .as(User.class);

        assertThat(expectedUser, is(createValidUserFactory()));
    }

    @Test(description = "CT004.001")
    public void shouldDeleteUserTest() {
        userClient
                .deleteUserById(VALID_ID)
                .statusCode(SC_OK)
                .body("isDeleted", equalTo(true))
                .body("deletedOn", notNullValue());
    }

    @Test(description = "CT004.001")
    public void shouldListUsersTest() {
        userClient
                .listAllUsers()
                .statusCode(SC_OK)
                .body("users.size()", greaterThan(0));
    }

    @Test(description = "CT006.002")
    public void shouldListUserByIdTest() {
        var expectedUser = userClient
                .listUserById(VALID_ID)
                .statusCode(SC_OK)
                .extract()
                .as(User.class);

        assertThat(expectedUser, is(idOneUserFactory()));
    }

    @Test(description = "CT006.002")
    public void updateValidUserTest() {
        var expectedUser = userClient
                .updateUserById(VALID_ID)
                .statusCode(SC_OK)
                .extract()
                .as(User.class);

        assertThat(expectedUser.firstName(), is(validUpdateUserFactory().firstName()));
        assertThat(expectedUser.lastName(), is(validUpdateUserFactory().lastName()));
    }
}
