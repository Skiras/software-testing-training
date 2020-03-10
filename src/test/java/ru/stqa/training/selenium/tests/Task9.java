/**
 * Created by Anton on 15 Окт., 2017.
 */
package ru.stqa.training.selenium.tests;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * лекция: 5. Получение свойств элементов
 * задание: Задание 9. Проверить сортировку стран и геозон в админке
 * используем {@link LiteCartAdminLoginTest} в качестве предэтапа
 */
public class Task9 extends LiteCartAdminLoginTest {

  @Test(description = "тест 1) страницы со странами")
  public void sortCountriesTest() {
    driver.get("http://localhost:8000/litecart/admin/?app=countries&doc=countries");
    List<WebElement> countries = driver.findElements(By.xpath("//tr[@class='row']//a[text()!='']"));
    // а) проверяем, расположены ли страны в алфавитном порядке
    Assert.assertTrue(isAlphabetically(countries, WebElement::getText));
    // б) для тех стран, у которых количество зон отлично от нуля -> открываем страницу
    List<WebElement> countriesToOpen = driver.findElements(
            By.xpath("//tr[@class='row']/td[6][text() != 0]"));
    for (WebElement country : countriesToOpen) {
      // открываем вкладку через нажатие на элемент, делаем определенные действия, закрываем вкладку
      switchTabDoSmthClose(country.findElement(
              By.xpath(".//ancestor::tr[@class='row']//a[text()!='']")),
              () -> Assert.assertTrue(isAlphabetically(
                      driver.findElements(By.xpath("//*[@class='dataTable']//tr/td[3]/input[@value!='']")),
                      webElement -> webElement.getAttribute("value"))));
    }
  }

  @Test(description = "тест 2) страницы с зонами")
  public void sortZonesTest() {
    driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    List<WebElement> countries = driver.findElements(By.xpath("//tr[@class='row']//a[text()!='']"));
    for (WebElement country : countries) {
      switchTabDoSmthClose(country, () -> Assert.assertTrue(isAlphabetically(
              driver.findElements(By.xpath("//select[contains(@name,'zone_code')]//*[@selected='selected']")),
              WebElement::getText)));
    }
  }

  /**
   * Проверка раположения элементов в алфавитном порядке
   *
   * @param elements список веб-эдементов
   * @param mapper   функция, с помощью которой получаем текстовое значение эелемента
   * @return {@link boolean}
   */
  private boolean isAlphabetically(List<WebElement> elements,
                                   Function<? super WebElement, ? extends String> mapper) {
    // преобразуем список веб-элементов в список строк
    ArrayList<String> actual = new ArrayList<>(elements.stream().map(mapper).collect(Collectors.toList()));
    return Ordering.natural().isOrdered(actual);
  }
}
