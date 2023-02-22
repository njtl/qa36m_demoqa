package com.telran.tests.ElementsTest;

import com.microsoft.playwright.Locator;
import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RadioButtonTestPR extends TestBasePR {
    @Test
    public void selectRadioButton() {
        page.navigate("https://demoqa.com/radio-button");
        page.locator("#yesRadio").check( new Locator.CheckOptions().setForce(true) );

        assertThat( page.locator(".text-success") ).containsText("Yes");
    }
}
