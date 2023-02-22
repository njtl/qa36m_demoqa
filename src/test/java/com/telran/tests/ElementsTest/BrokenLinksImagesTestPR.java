package com.telran.tests.ElementsTest;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BrokenLinksImagesTestPR extends TestBasePR {

    @Test
    public void checkBrokenLinks() {
        page.navigate("https://demoqa.com/broken");

        for ( Locator link : page.getByRole(AriaRole.LINK).all() ) {
            System.out.println( link.textContent() );
            APIResponse response = page.request().get( link.getAttribute("href") );
            assertThat(response).isOK();
        }
    }

    @Test
    public void checkBrokenImages2() throws URISyntaxException {
        page.navigate("https://demoqa.com/broken");
        for ( Locator image : page.getByRole(AriaRole.IMG).all() ) {
            String src = image.getAttribute("src");
            // http(s) + :// + host  + src
            URI uri = new URI( page.url() );
            // uri.getScheme() -- https
            // uri.getHost() -- demoqa.com
            if ( !src.startsWith("http") ) src = uri.getScheme() + "://" + uri.getHost() + src;
            System.out.println(src);
            APIResponse response = page.request().get(src);
            assertThat(response).isOK();

            assertTrue(response.headers().get("content-type").contains("image"));
            assertFalse( image.evaluate("node => node.naturalWidth").equals(0) ,
                    "Failed: image naturalWidth == 0" );
        }
    }
}
