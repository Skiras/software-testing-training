/**
 * Created by Anton on 23 Окт., 2017.
 */
package ru.stqa.training.selenium.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.training.selenium.pages.CartPage;
import ru.stqa.training.selenium.pages.ProductChoosePage;
import ru.stqa.training.selenium.pages.ProductPage;

public class Application {

  private WebDriver driver;

  private ProductChoosePage productChoosePage;
  private ProductPage productPage;
  private CartPage cartPage;


  public Application() {
    driver = new ChromeDriver();
    productChoosePage = new ProductChoosePage(driver);
    productPage = new ProductPage(driver);
    cartPage = new CartPage(driver);
  }

  public void quit() {
    driver.quit();
  }

  public void chooseFirstProduct() {
    productChoosePage.open().chooseFirstProduct();
  }

  public void addProductToCart() {
    productPage.addProductToCartAndWait();
  }

  public void removeProductFromCart() {
    cartPage.open().removeProductFromCartAndWait();
  }
}
