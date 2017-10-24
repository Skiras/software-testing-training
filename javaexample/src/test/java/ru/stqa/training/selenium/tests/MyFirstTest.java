package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest extends BaseHelper {

    @Test
    public void myFirstTest() {
        driver.get("https://www.google.ru/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        wait.until(titleIs("webdriver - Поиск в Google"));
    }
}
