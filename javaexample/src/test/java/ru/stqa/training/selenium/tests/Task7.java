package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * лекция: 4. Поиск элементов
 * задание: Задание 7. Сделайте сценарий, проходящий по всем разделам админки
 * используем {@link LiteCartLoginTest} в качестве предэтапа
 */
public class Task7 extends LiteCartLoginTest {

    @Test
    public void sectionTest() {
        String menuList = "//ul[@id='box-apps-menu']/li";
        int menuSize = driver.findElements(By.xpath(menuList)).size();
        int subMenuSize;
        // прокликиваем все пункты меню
        for (int i = 1; i <= menuSize; i++) {
            // нажимаем на пункт меню
            driver.findElement(By.xpath(menuList + "[" + i + "]")).click();
            // проверяем наличие заголовка
            Assert.assertTrue(isElementPresent(By.xpath("//h1")));
            // проверяем наличие подменю, если есть -> прокликиваем
            if ((subMenuSize = driver.findElements(
                    By.xpath(menuList + "[" + i + "]//li")).size()) > 0) {
                for (int j = 1; j <= subMenuSize; j++) {
                    driver.findElement(By.xpath(menuList + "[" + i + "]//li[" + j + "]")).click();
                    // проверяем наличие заголовка
                    Assert.assertTrue(isElementPresent(By.xpath("//h1")));
                }
            }
        }
    }
}
