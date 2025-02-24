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

    @Test(description = "CT006.002")
    public void shouldNotLoginWithInvalidCredentialsTest() {
        var expectedMessage = userClient
                .login(invalidLoginFactory())
                .statusCode(SC_BAD_REQUEST)
                .extract()
                .as(Message.class);

        String expectedErrorMessage = "Invalid credentials";

        assertThat(expectedMessage.message(), is(expectedErrorMessage));

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

    @Test(dataProvider = "userFactory")
    public void shouldCreateUserWithOneAttributeTest(User user) {
        userClient
                .createUserWithAttributes(user)
                .statusCode(SC_CREATED);
    }

    @DataProvider(name = "invalidIds")
    public Object[][] provideInvalidIds() {
        return new Object[][]{
                {"-"},
                {"invalid-id"},
                {"!@#$%"}
        };
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

    @Test(dataProvider = "invalidIds")
    public void shouldNotDeleteUserByInvalidIdTest(String invalidId) {
        var expectedMessage = userClient
                .deleteUserById(invalidId)
                .statusCode(SC_BAD_REQUEST)
                .extract()
                .as(Message.class);

        String expectedErrorMessage = String.format("Invalid user id '%s'", invalidId);

        assertThat(expectedMessage.message(), is(expectedErrorMessage));
    }

    @Test(dataProvider = "invalidIds")
    public void shouldNotFindUserByInvalidIdTest(String invalidId) {
        var expectedMessage = userClient
                .listUserById(invalidId)
                .statusCode(SC_BAD_REQUEST)
                .extract()
                .as(Message.class);

        String expectedErrorMessage = String.format("Invalid user id '%s'", invalidId);

        assertThat(expectedMessage.message(), is(expectedErrorMessage));
    }


    @Test(dataProvider = "limitFactory", dataProviderClass = ProductFunctionalTest.class)
    public void shouldPaginateUsersTest(int limit) {
        userClient
                .searchUsersByPage(limit)
                .statusCode(SC_OK)
                .body("users.size()", greaterThan(0))
                .body("limit", notNullValue());
    }

    @Test
    public void shouldNotPaginateUsersTest() {
        var expectedMessage = userClient
                .searchUsersByPage()
                .statusCode(SC_BAD_REQUEST)
                .extract()
                .as(Message.class);

        assertThat(expectedMessage.message(), is("Invalid 'limit' - must be a number"));
    }

    @Test(dataProvider = "skipFactory", dataProviderClass = ProductFunctionalTest.class)
    public void shouldSkipUsersTest(int skip) {
        userClient
                .skipUsersByPage(skip)
                .statusCode(SC_OK)
                .body("users.size()", greaterThan(0))
                .body("skip", notNullValue());
    }

    @Test
    public void shouldNotSkipUsersTest() {
        var expectedMessage = userClient
                .skipUsersByPage()
                .statusCode(SC_BAD_REQUEST)
                .extract()
                .as(Message.class);

        assertThat(expectedMessage.message(), is("Invalid 'skip' - must be a number"));
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

    @Test(dataProvider = "selectFactory")
    public void shouldSelectUsersTest(String select) {
        userClient
                .selectUserByAttribute(select)
                .statusCode(SC_OK)
                .body("users.size()", greaterThan(0));
    }

    @Test
    public void shouldSelectSkipAndLimitUsersTest() {
        userClient
                .selectLimitSkipUsers()
                .statusCode(SC_OK)
                .body("users.size()", greaterThan(0))
                .body("skip", notNullValue())
                .body("limit", notNullValue());
    }

    @Test(dataProvider = "orderFactory", dataProviderClass = ProductFunctionalTest.class)
    public void shouldListUsersOrderTest(String order) {
        userClient
                .listUsersByOrder(order)
                .statusCode(SC_OK)
                .body("users.size()", greaterThan(0));
    }

    @Test(dataProvider = "invalidOrderFactory", dataProviderClass = ProductFunctionalTest.class)
    public void shouldNotListUsersWithInvalidOrderTest(String order) {
        var expectedMessage = userClient
                .listUsersByOrder(order)
                .statusCode(SC_BAD_REQUEST)
                .extract()
                .as(Message.class);

        assertThat(expectedMessage.message(), is("Order can be: 'asc' or 'desc'"));
    }
}
