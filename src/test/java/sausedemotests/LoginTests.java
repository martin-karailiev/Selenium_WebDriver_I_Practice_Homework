package sausedemotests;

import core.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginTests extends BaseTest {

    @ParameterizedTest
    @CsvSource({
            "standard_user, secret_sauce",   // valid credentials
            "locked_out_user, secret_sauce", // invalid login (locked out user)
            "problem_user, secret_sauce",    // another valid user
            "performance_glitch_user, secret_sauce"  // valid user, performance glitch
    })
    public void userAuthenticated_when_validCredentialsProvided(String username, String password) {
        loginPage.navigate();
        loginPage.fillLoginForm(username, password);
        inventoryPage.waitForPageTitle();
        inventoryPage.assertNavigated();
    }
}
