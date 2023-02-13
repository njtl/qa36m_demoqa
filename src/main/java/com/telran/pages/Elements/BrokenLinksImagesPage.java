package com.telran.pages.Elements;

import com.telran.pages.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrokenLinksImagesPage extends PageBase {
    public BrokenLinksImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName="img")
    List<WebElement> images;
    public int checkNoBrokenImages() {
        hideAds();

        int numberOfBrokeLImages = 0;
        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String imageURL = image.getAttribute("src");
            try {
                boolean isImageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);",image);

                if (isImageDisplayed)
                {
                    System.out.println("Image displayed: " + imageURL);
                }
                else {
                    System.out.println("Image not displayed: " + imageURL);
                    numberOfBrokeLImages = numberOfBrokeLImages + 1;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
        }
        return numberOfBrokeLImages;
    }

}
