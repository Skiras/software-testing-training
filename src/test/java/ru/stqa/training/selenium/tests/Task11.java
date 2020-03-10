/**
 * Created by Anton on 18 Окт., 2017.
 */
package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.models.User;

/**
 * лекция: 6. Действия с элементами
 * задание: Задание 11. Сделайте сценарий регистрации пользователя
 */
public class Task11 extends BaseHelper {

  @Test
  public void createUserTest() {
    // открыть главную страницу
    driver.get("http://localhost:8000/litecart/en/");
    // нажимаем кнопку регистрации
    driver.findElement(By.xpath("//*[text()='New customers click here']")).click();
    // создаем пользователя
    User user = new User();
    // заполняем форму регистрации
    fillRegistrationForm(user);
    // нажимаем кнопку создать аккаунт
    driver.findElement(By.xpath("//*[@name='create_account']")).click();
    // выходим
    logout();
    // входим
    login(user);
    // выходим
    logout();
  }

  private void fillRegistrationForm(User user){
    fillField(getXPathByNameAtt("tax_id"), user.getTaxID());
    fillField(getXPathByNameAtt("company"), user.getCompany());
    fillField(getXPathByNameAtt("firstname"), user.getFirstName());
    fillField(getXPathByNameAtt("lastname"), user.getLastName());
    fillField(getXPathByNameAtt("address1"), user.getAddress1());
    fillField(getXPathByNameAtt("address2"), user.getAddress2());
    fillField(getXPathByNameAtt("postcode"), user.getPostcode());
    fillField(getXPathByNameAtt("city"), user.getCity());
    selectValue(getXPathByNameAtt("country_code"), user.getCountry());
    selectRandomValue("//select[@name='zone_code']");
    fillField(getXPathByNameAtt("email"), user.getEmail());
    fillField(getXPathByNameAtt("phone"), user.getPhone());
    fillField(getXPathByNameAtt("password"), user.getPassword());
    fillField(getXPathByNameAtt("confirmed_password"), user.getPassword());
  }

  private void logout() {
    driver.findElement(By.xpath("//*[@id='navigation']//a[text()='Logout']")).click();
  }

  private void login(User user) {
    driver.findElement(By.xpath(getXPathByNameAtt("email"))).sendKeys(user.getEmail());
    driver.findElement(By.xpath(getXPathByNameAtt("password"))).sendKeys(user.getPassword());
    driver.findElement(By.xpath(getXPathByNameAtt("login"))).click();
  }
}
