package ru.stqa.training.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.stqa.training.selenium.Utills.DoSmth;

import java.util.ArrayList;
import java.util.List;

/**
 * Вспомогательный класс
 * содержит объекты драйвера и ожидания а так же
 * необходимые методы запуска и остановки теста
 */
public class BaseHelper {

  WebDriver driver;
  WebDriverWait wait;

  // клавиши для открытия новой вкладки через ссылку
  String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);

  @BeforeClass
  public void start() {
    driver = new ChromeDriver();
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(FirefoxDriver.MARIONETTE, false);
//        driver = new FirefoxDriver(
//                new FirefoxBinary(new File("C:\\Program Files\\Nightly\\firefox.exe")),
//                new FirefoxProfile(), capabilities);
    //      driver = new InternetExplorerDriver();
    wait = new WebDriverWait(driver, 10);
  }

  @AfterClass
  public void stop() {
    driver.quit();
  }

  /**
   * получение XPath
   *
   * @param attribute название арибута
   * @param value     значение атрибута
   * @return
   */
  public String getXPathByAtt(String attribute, String value) {
    return "//*[@" + attribute + "='" + value + "']";
  }

  /**
   * получение XPath с атрибутом @name
   *
   * @param value значение атрибута @name
   * @return
   */
  public String getXPathByNameAtt(String value) {
    return getXPathByAtt("name", value);
  }

  public boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean areElementsPresent(By locator) {
    return driver.findElements(locator).size() > 0;
  }

  public List<String> getCurrentTabs() {
    return new ArrayList<>(driver.getWindowHandles());
  }

  /**
   * Метод, открывающий новую вкладку и осуществляющий полезные действия, вкладку по завершению закрывается
   *
   * @param element элемент, по окторому происходит открытие
   * @param doSmth  полезные действия
   */
  public void switchTabDoSmthClose(WebElement element, DoSmth doSmth) {
    element.sendKeys(selectLinkOpeninNewTab);
    driver.switchTo().window(getCurrentTabs().get(1));
    doSmth.doSomething();
    driver.close();
    driver.switchTo().window(getCurrentTabs().get(0));
  }
}
