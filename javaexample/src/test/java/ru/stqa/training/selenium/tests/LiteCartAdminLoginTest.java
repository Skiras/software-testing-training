
package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

/**
 * лекция: 2. Первые шаги: пробежимся по верхам
 * задание: Задание 3. Сделайте сценарий логина
 */
public class LiteCartAdminLoginTest extends BaseHelper {

    private String username = "admin";
    private String password = "admin";

    @Test
    public void loginTest() {
        driver.get("http://localhost:8000/litecart/admin/");
        driver.findElement(By.xpath(getXPathByNameAtt("username"))).sendKeys(username);
        driver.findElement(By.xpath(getXPathByNameAtt("password"))).sendKeys(password);
        driver.findElement(By.xpath(getXPathByNameAtt("login"))).click();
        // ожидаем видимость лого главной страницы
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                getXPathByAtt("class", "logotype")))));
    }
}
