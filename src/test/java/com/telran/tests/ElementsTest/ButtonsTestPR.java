package com.telran.tests.ElementsTest;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;
import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ButtonsTestPR extends TestBasePR {

    @Test
    public void buttonsClicks() {
        page.navigate("https://demoqa.com/buttons");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Double Click Me") ).dblclick();
        assertThat( page.locator("#doubleClickMessage") ).containsText("double click");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Right Click Me") )
                .click( new Locator.ClickOptions().setButton(MouseButton.RIGHT) );
        assertThat( page.locator("#rightClickMessage") ).containsText("right click");
    }
}
