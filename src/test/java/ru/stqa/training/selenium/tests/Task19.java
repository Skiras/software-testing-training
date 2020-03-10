/**
 * Created by Anton on 23 Окт., 2017.
 */
package ru.stqa.training.selenium.tests;

import org.testng.annotations.Test;

/**
 * лекция: 11. PageObjects и другие шаблоны проектирования
 * задание: Задание 19. Реализовать многослойную архитектуру
 */
public class Task19 extends BaseHelperNew {

  @Test
  public void cartTest() {
    for (int i = 0; i < 3; i++) {
      app.chooseFirstProduct();
      app.addProductToCart();
    }
    app.removeProductFromCart();
  }
}
