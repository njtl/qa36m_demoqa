package com.telran.tests.BookStoreTests;

import com.microsoft.playwright.options.AriaRole;
import com.telran.pages.data.LoginData;
import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.*;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BookStoreLoginTestPR extends TestBasePR {

    @Test
    public void positiveAuthTest() {
        page.navigate("https://demoqa.com/");
        page.locator("#app > div > div > div.home-body > div > div:nth-child(6)").click();
        page.getByRole(AriaRole.LIST).getByText("Login").click();

        assertThat(page).hasTitle(Pattern.compile("DEMOQA"));

        page.locator("input[id='userName']").click();
        page.locator("input[id='userName']").fill(LoginData.USERNAME);
        page.getByPlaceholder("Password").click();
        page.getByPlaceholder("Password").fill(LoginData.PASSWORD);

        page.locator("#login").click();

        assertThat(page.locator("#userName-value")).containsText(LoginData.USERNAME);
    }
}
