/**
 * Created by Anton on 24 Окт., 2017.
 */
package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Page {

  public ProductPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath = "(//*[@class='quantity'])[1]")
  public WebElement amountOfProducts;
  
  private int getAmountOfProductsInCart() {
    return Integer.parseInt(amountOfProducts.getText());
  }

  public void addProductToCartAndWait() {
    // получить счетчик товаров и увеличиваем его на единицу
    Integer count = getAmountOfProductsInCart();
    // добавить товар в корзину
    driver.findElement(By.name("add_cart_product")).click();
    // подождать, пока счётчик товаров в корзине обновится
    wait.until(d -> getAmountOfProductsInCart() == count + 1);
  }
}
