package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CalendarTest extends BaseHelper {

    @Test
    public void calendarTest() {
        driver.get("http://jqueryui.com/datepicker/");
        driver.switchTo().frame(
                driver.findElement(By.cssSelector("iframe.demo-frame")));
        setDatepicker(driver, "#datepicker", "02/20/2002");
    }

    public void setDatepicker(WebDriver driver, String cssSelector, String date) {
        new WebDriverWait(driver, 30000).until(
                (WebDriver d) -> d.findElement(By.cssSelector(cssSelector)).isDisplayed());
        JavascriptExecutor.class.cast(driver).executeScript(
                String.format("$('%s').datepicker('setDate', '%s')", cssSelector, date));
    }
}
