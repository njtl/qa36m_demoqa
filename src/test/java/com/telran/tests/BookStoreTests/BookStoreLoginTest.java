package com.telran.tests.BookStoreTests;

import com.telran.pages.*;
import com.telran.pages.BookStore.BookStorePage;
import com.telran.pages.BookStore.LoginPage;
import com.telran.pages.BookStore.ProfilePage;
import com.telran.pages.data.LoginData;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreLoginTest extends TestBase {

    //imaksimov2
    //!m@ksimoV2

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).openBookStoreApp();
        new BookStorePage(driver).openLoginPage();
    }

    @Test
    public void positiveAuthTest() {
        new LoginPage(driver).login(LoginData.USERNAME, LoginData.PASSWORD);
        Assert.assertEquals(new ProfilePage(driver).getUserNameValue(), LoginData.USERNAME);
    }

    @Test
    public void negativeAuthTest(){
        new LoginPage(driver).login("qwmklad", "mkalsd");
        String error = "Invalid username or password";
        Assert.assertTrue(new LoginPage(driver).getErrorMessage().contains(error));
    }

    @Test
    public void logOutTest(){
        new LoginPage(driver).login(LoginData.USERNAME, LoginData.PASSWORD);
        new LoginPage(driver).logOut();
        Assert.assertTrue(new LoginPage(driver).getWelcomeMessage().contains("Login in Book Store"));
    }
}
