package functional;

import base.BaseTest;
import dto.Message;
import dto.User;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static factory.UserFactory.*;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserFunctionalTest extends BaseTest {

    @Test(description = "CT001.002 CT001.003 CT001.004", dataProvider = "userLoginFactory")
    public void shouldNotLoginWithInvalidCredentialsTest(User user) {
        var expectedMessage = userClient
                .login(user)
                .statusCode(SC_BAD_REQUEST)
                .extract()
                .as(Message.class);

        String expectedErrorMessage = "Invalid credentials";

        assertThat(expectedMessage.message(), is(expectedErrorMessage));

    }

    @Test(description = "CT008.002 CT008.003 CT008.004 CT008.005 CT008.006 CT008.007 CT008.008 CT008.009 CT008.10",
            dataProvider = "userFactory")
    public void shouldCreateUserWithOneAttributeTest(User user) {
        userClient
                .createUserWithAttributes(user)
                .statusCode(SC_CREATED);
    }

    @Test(dataProvider = "invalidIds")
    public void shouldNotUpdateUserByInvalidIdTest(String invalidId) {
        var expectedMessage = userClient
                .updateUserById(invalidId)
                .statusCode(SC_BAD_REQUEST)
                .extract()
                .as(Message.class);

        String expectedErrorMessage = String.format("Invalid user id '%s'", invalidId);

        assertThat(expectedMessage.message(), is(expectedErrorMessage));
    }

    @Test(description = "CT009.002", dataProvider = "invalidIds")
    public void shouldNotDeleteUserByInvalidIdTest(String invalidId) {
        var expectedMessage = userClient
                .deleteUserById(invalidId)
                .statusCode(SC_BAD_REQUEST)
                .extract()
                .as(Message.class);

        String expectedErrorMessage = String.format("Invalid user id '%s'", invalidId);

        assertThat(expectedMessage.message(), is(expectedErrorMessage));
    }

    @Test(description = "CT007.003", dataProvider = "invalidIds")
    public void shouldNotFindUserByInvalidIdTest(String invalidId) {
        var expectedMessage = userClient
                .listUserById(invalidId)
                .statusCode(SC_BAD_REQUEST)
                .extract()
                .as(Message.class);

        String expectedErrorMessage = String.format("Invalid user id '%s'", invalidId);

        assertThat(expectedMessage.message(), is(expectedErrorMessage));
    }


    @Test(description = "CT007.004", dataProvider = "limitFactory", dataProviderClass = ProductFunctionalTest.class)
    public void shouldPaginateUsersTest(int limit) {
        userClient
                .searchUsersByPage(limit)
                .statusCode(SC_OK)
                .body("users.size()", greaterThan(0))
                .body("limit", notNullValue());
    }

    @Test(description = "CT007.005")
    public void shouldNotPaginateUsersTest() {
        var expectedMessage = userClient
                .searchUsersByPage()
                .statusCode(SC_BAD_REQUEST)
                .extract()
                .as(Message.class);

        assertThat(expectedMessage.message(), is("Invalid 'limit' - must be a number"));
    }

    @Test(description = "CT007.006", dataProvider = "skipFactory", dataProviderClass = ProductFunctionalTest.class)
    public void shouldSkipUsersTest(int skip) {
        userClient
                .skipUsersByPage(skip)
                .statusCode(SC_OK)
                .body("users.size()", greaterThan(0))
                .body("skip", notNullValue());
    }

    @Test(description = "CT007.007")
    public void shouldNotSkipUsersTest() {
        var expectedMessage = userClient
                .skipUsersByPage()
                .statusCode(SC_BAD_REQUEST)
                .extract()
                .as(Message.class);

        assertThat(expectedMessage.message(), is("Invalid 'skip' - must be a number"));
    }

    @Test(description = "CT007.008", dataProvider = "selectFactory")
    public void shouldSelectUsersTest(String select) {
        userClient
                .selectUserByAttribute(select)
                .statusCode(SC_OK)
                .body("users.size()", greaterThan(0));
    }

    @Test(description = "CT007.009")
    public void shouldSelectSkipAndLimitUsersTest() {
        userClient
                .selectLimitSkipUsers()
                .statusCode(SC_OK)
                .body("users.size()", greaterThan(0))
                .body("skip", notNullValue())
                .body("limit", notNullValue());
    }

    @Test(description = "CT007.010", dataProvider = "sortOrders", dataProviderClass = ProductFunctionalTest.class)
    public void shouldListUsersOrderTest(String order) {
        userClient
                .listUsersByOrder(order)
                .statusCode(SC_OK)
                .body("users.size()", greaterThan(0));
    }

    @Test(description = "CT007.011", dataProvider = "invalidOrders", dataProviderClass = ProductFunctionalTest.class)
    public void shouldNotListUsersWithInvalidOrderTest(String order) {
        var expectedMessage = userClient
                .listUsersByOrder(order)
                .statusCode(SC_BAD_REQUEST)
                .extract()
                .as(Message.class);

        assertThat(expectedMessage.message(), is("Order can be: 'asc' or 'desc'"));
    }

    @DataProvider(name = "userLoginFactory")
    public Object[][] userLoginFactory() {
        return new Object[][]{
                {invalidUsernameLoginFactory()},
                {invalidPasswordLoginFactory()},
                {LoginWithoutFieldsFactory()},
                {invalidLoginFactory()}
        };
    }

    @DataProvider(name = "selectFactory")
    public Object[][] selectFactory() {
        return new Object[][]{
                {"firstName"},
                {"lastName"},
                {"maidenName"},
                {"age"},
                {"gender"},
                {"email"},
                {"phone"},
                {"password"},
                {"birthDate"},
                {"username"}
        };
    }

    @DataProvider(name = "invalidIds")
    public Object[][] provideInvalidIds() {
        return new Object[][]{
                {"-"},
                {"invalid-id"},
                {"!@#$%"}
        };
    }

    @DataProvider(name = "invalidOrderFactory")
    public Object[][] invalidOrderFactory() {
        return new Object[][]{
                {"nulls_first"},
                {"nulls_last"},
                {"random"},
                {"@#@"}
        };
    }

    @DataProvider(name = "userFactory")
    public Object[][] userFactory() {
        return new Object[][]{
                {createUserWithFirstName()},
                {createUserWithLastName()},
                {createUserWithMaidenName()},
                {createUserWithAge()},
                {createUserWithGender()},
                {createUserWithEmail()},
                {createUserWithPhone()},
                {createUserWithUsername()},
                {createUserWithPassword()},
                {createUserWithBirthDate()}
        };
    }
}
