package com.telran.pages.Elements;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class RadioButtonPage extends PageBase {
    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//label[.='Yes']")
    WebElement labelYes;

    public RadioButtonPage selectYes() {
        hideAds();

        labelYes.click();
        return this;
    }

    @FindBy(xpath="//span[@class='text-success']")
    WebElement textSuccess;
    public String checkSelected() {
        return textSuccess.getText();
    }
}
