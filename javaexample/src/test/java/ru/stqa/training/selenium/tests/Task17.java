/**
 * Created by Anton on 22 Окт., 2017.
 */
package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * лекция: 10. Протоколирование
 * задание: Задание 17. Проверьте отсутствие сообщений в логе браузера
 */
public class Task17 extends LiteCartAdminLoginTest {

  @Test
  public void protocolTest() {
    driver.get("http://localhost:8000/litecart/admin/?app=catalog&doc=catalog&category_id=1");
    List<WebElement> elements = driver.findElements(By.xpath("//*[@class='dataTable']//img/following-sibling::a"));
    for (WebElement element : elements) {
      switchTabDoSmthClose(element, null);
      List<LogEntry> logs = driver.manage().logs().get("browser").getAll();
      Assert.assertTrue(logs.isEmpty());
      logs.forEach(System.out::println);
    }
  }
}
