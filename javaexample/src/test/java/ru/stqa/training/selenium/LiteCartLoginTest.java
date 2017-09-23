
package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * лекция: 2. Первые шаги: пробежимся по верхам
 * задание: Задание 3. Сделайте сценарий логина
 */
public class LiteCartLoginTest extends BaseHelper {

    private String username = "admin";
    private String password = "admin";

    @Test
    public void loginTest() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.xpath(getXPathByNameAtt("username"))).sendKeys(username);
        driver.findElement(By.xpath(getXPathByNameAtt("password"))).sendKeys(password);
        driver.findElement(By.xpath(getXPathByNameAtt("login"))).click();
        // ожидаем видимость лого главной страницы
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                getXPathByAtt("class", "logotype")))));
    }
}
