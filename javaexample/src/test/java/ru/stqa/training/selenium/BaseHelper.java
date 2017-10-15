package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Вспомогательный класс
 * содержит объекты драйвера и ожидания а так же
 * необходимые методы запуска и остановки теста
 */
public class BaseHelper {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void start() {
        driver = new ChromeDriver();
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(FirefoxDriver.MARIONETTE, false);
//        driver = new FirefoxDriver(
//                new FirefoxBinary(new File("C:\\Program Files\\Nightly\\firefox.exe")),
//                new FirefoxProfile(), capabilities);
        //      driver = new InternetExplorerDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void stop() {
        driver.quit();
    }

    /**
     * получение XPath
     *
     * @param attribute название арибута
     * @param value     значение атрибута
     * @return
     */
    public String getXPathByAtt(String attribute, String value) {
        return "//*[@" + attribute + "='" + value + "']";
    }

    /**
     * получение XPath с атрибутом @name
     *
     * @param value значение атрибута @name
     * @return
     */
    public String getXPathByNameAtt(String value) {
        return getXPathByAtt("name", value);
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean areElementsPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
}
