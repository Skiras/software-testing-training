package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Вспомогательный класс
 * содержит объекты драйвера и ожидания а так же
 * необходимые методы запуска и остановки теста
 */
public class BaseHelper {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void start() {
//        driver = new ChromeDriver();
       driver = new FirefoxDriver();
//        driver = new InternetExplorerDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void stop() {
        driver.quit();
    }

    /**
     * получение XPath
     *
     * @param attribute название арибута
     * @param value значение атрибута
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
}
