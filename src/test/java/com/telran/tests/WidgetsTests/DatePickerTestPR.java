package com.telran.tests.WidgetsTests;

import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DatePickerTestPR extends TestBasePR {

    @Test
    public void datePickerSelectTomorrow() {
        page.navigate("https://demoqa.com/date-picker");

        page.locator("#datePickerMonthYearInput").click();

        LocalDateTime todayDate = LocalDateTime.now();
        System.out.println(todayDate);
        LocalDateTime tomorrowDate = todayDate.plusDays(1);
        System.out.println(tomorrowDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String tomorrowDateFormatted = tomorrowDate.format(formatter);

        System.out.println(tomorrowDateFormatted);

        page.locator("//div[contains(@class, 'today')]/following-sibling::div[1]").click();
        assertThat( page.locator("#datePickerMonthYearInput")).hasValue(tomorrowDateFormatted);


    }
}
