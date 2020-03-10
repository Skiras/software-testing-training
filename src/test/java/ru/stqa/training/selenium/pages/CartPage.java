/**
 * Created by Anton on 24 Окт., 2017.
 */
package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends Page {

  public CartPage(WebDriver driver) {
    super(driver);
  }

  public CartPage open() {
    driver.findElement(By.xpath("//a[contains(text(), 'Checkout')]")).click();
    return this;
  }

  public void removeProductFromCartAndWait() {
    // удалить все товары из корзины один за другим, после каждого удаления подождать, пока внизу обновится таблица
    List<WebElement> removeItems = driver.findElements(By.xpath("//*[@class='dataTable rounded-corners']//td[@class='item']"));
    for (int count = 1; count <= removeItems.size(); count++) {
      WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(
              By.xpath("//li[@class='item'][1]//*[@name='remove_cart_item']")));
      product.click();
      int newSize = removeItems.size() - count;
      wait.until(d -> d.findElements(By.xpath("//*[@class='dataTable rounded-corners']//td[@class='item']")).size() == newSize);
    }
  }
}
