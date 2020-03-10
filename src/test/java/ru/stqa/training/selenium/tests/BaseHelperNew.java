/**
 * Created by Anton on 24 Окт., 2017.
 */
package ru.stqa.training.selenium.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.stqa.training.selenium.app.Application;

/**
 * <b>Название (ИЗ ПМИ)</b><br/>
 * Проверяемый функционал: <br/>
 * Роль:
 *
 * @author Anton
 * @version 1.0.0
 * @see
 */
public class BaseHelperNew  {

  public Application app;

  @BeforeClass
  public void start() {
    app = new Application();
  }

  @AfterClass
  public void stop() {
    app.quit();
  }
}
