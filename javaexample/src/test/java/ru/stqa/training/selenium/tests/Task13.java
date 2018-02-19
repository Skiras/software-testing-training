/**
 * Created by Anton on 22 Окт., 2017.
 */
package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

/**
 * лекция: 7. Ожидания (WebDriverWait)
 * задание: Задание 13. Сделайте сценарий работы с корзиной
 */
public class Task13 extends BaseHelper {

  private int i = 1;

  @Test
  public void cartTest() {
    // 1) открыть главную страницу
    driver.get("http://localhost:8000/litecart/en/");
    for(; i < 4; i++) {
      // 2) открыть первый товар из списка
      clickOnElement("(//*[@class='product column shadow hover-light'])[1]");
      // 3) добавить его в корзину
      clickOnElement(getXPathByNameAtt("add_cart_product"));
      // 4) подождать, пока счётчик товаров в корзине обновится
      int count  = i;
      wait.until(d -> d.findElement(By.xpath("//a//*[@class='quantity']")).getText().equals(String.valueOf(count)));
      // 3) вернуться на главную страницу, повторить предыдущие шаги ещё два раза, чтобы в общей сложности в корзине было 3 единицы товара
      driver.get("http://localhost/litecart/en/");
    }
    // 5) открыть корзину (в правом верхнем углу кликнуть по ссылке Checkout)
    clickOnElement("//a[contains(text(), 'Checkout')]");
    // 6) удалить все товары из корзины один за другим, после каждого удаления подождать, пока внизу обновится таблица
    String removes = "//*[@name='remove_cart_item']";
    List<WebElement> removeItems;
    while ((removeItems = driver.findElements(By.xpath(removes))).size() > 0){
      WebElement element = removeItems.get(0);
      wait.until(ExpectedConditions.elementToBeClickable(element));
      element.click();
      int count = --i;
      wait.until(d -> d.findElements(By.xpath("//*[@class='dataTable rounded-corners']//td[@class='item']")).size() == count);
    }
  }
}
