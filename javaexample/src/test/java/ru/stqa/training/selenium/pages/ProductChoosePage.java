/**
 * Created by Anton on 24 Окт., 2017.
 */
package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductChoosePage extends Page {

  public ProductChoosePage(WebDriver driver) {
    super(driver);
  }

  public ProductChoosePage open() {
    driver.get("http://localhost/litecart/en/");
    return this;
  }

  public void chooseFirstProduct() {
    // открыть первый товар из списка
    driver.findElement(By.xpath("(//*[@class='product column shadow hover-light'])[1]")).click();
  }
}
