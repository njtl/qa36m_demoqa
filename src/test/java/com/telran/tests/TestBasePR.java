package com.telran.tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

public class TestBasePR {


    public static Playwright playwright;
    public static Browser browser;

    // New instance for each test method.
    public BrowserContext context;
    public Page page;

    @BeforeAll
    static void launchBrowser() {
        var launchOpts = new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(100);
        playwright = Playwright.create();
        browser = playwright.chromium().launch(launchOpts);
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        var conectOpts = new Browser.NewContextOptions().setViewportSize(width, height);

        context = browser.newContext();
        //context = browser.newContext(conectOpts);
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }
}
