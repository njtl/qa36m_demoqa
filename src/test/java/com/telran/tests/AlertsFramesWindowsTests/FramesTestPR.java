package com.telran.tests.AlertsFramesWindowsTests;

import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FramesTestPR extends TestBasePR {

    @Test
    public void switchToFrameById(){
        page.navigate("https://demoqa.com/frames");
        assertThat(page.frameLocator("#frame1").locator("#sampleHeading")).containsText("sample");
    }
}
