/**
 * Created by Anton on 15 Окт., 2017.
 */
package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.models.Goods;

/**
 * лекция: 5. Получение свойств элементов
 * задание: Задание 10. Проверить, что открывается правильная страница товара
 */
public class Task10 extends BaseHelper {

  private String firstGoodsPath = "//*[text()='Campaigns']/following-sibling::div/ul/li[1]";

  private String regularPricePath = "//*[@class='regular-price']";

  private String campaignPricePath = "//*[@class='campaign-price']";

  @Test
  public void goodsPageTest() {
    // открыть главную страницу
    driver.get("http://localhost/litecart/en/");
    WebElement title = driver.findElement(By.xpath(firstGoodsPath + "//*[@class='name']"));
    WebElement regularPrice = driver.findElement(By.xpath(firstGoodsPath + regularPricePath));
    WebElement campaignPrice = driver.findElement(By.xpath(firstGoodsPath + campaignPricePath));
    // создаем модель товара (для последующей проверки а) б))
    Goods mainPageGoods = new Goods(title.getText(), regularPrice.getText(), campaignPrice.getText());
    // осуществляем проверки обычной и акционной цены (Задания в) г) д))
    checkRegularPrice(regularPrice);
    checkCampaignPrice(campaignPrice);
    checkSize(campaignPrice, regularPrice);
    // выбрать первый товар в блоке Campaigns
    driver.findElement(By.xpath(firstGoodsPath)).click();
    WebElement goodsTitle = driver.findElement(By.xpath("//h1[@class='title']"));
    WebElement goodsRegularPrice = driver.findElement(By.xpath(regularPricePath));
    WebElement goodsCampaignPrice = driver.findElement(By.xpath(campaignPricePath));
    // создаем модель товара на второй странице
    Goods aboutPageGoods = new Goods(goodsTitle.getText(), goodsRegularPrice.getText(), goodsCampaignPrice.getText());
    // осуществляем проверку на соответствие (Задания а) б))
    Assert.assertTrue(aboutPageGoods.equals(mainPageGoods));
    // осуществляем проверки цен (Задания в) г) д))
    checkRegularPrice(goodsRegularPrice);
    checkCampaignPrice(goodsCampaignPrice);
    checkSize(goodsCampaignPrice, goodsRegularPrice);
  }

  private void checkRegularPrice(WebElement webElement) {
    String color = webElement.getCssValue("color");
    String style = webElement.getTagName();
    String[] rgb = getRGB(color);
    Assert.assertTrue(style.equals("s") && rgb[0].equals(rgb[1]) && rgb[1].equals(rgb[2]));
  }

  private void checkCampaignPrice(WebElement webElement) {
    String color = webElement.getCssValue("color");
    String style = webElement.getTagName();
    String[] rgb = getRGB(color);
    Assert.assertTrue(style.equals("strong") && rgb[1].equals("0") && rgb[2].equals(rgb[1]));
  }

  private void checkSize(WebElement campaign, WebElement regular) {
    // получаем размер веб-элемента акционная цена
    Dimension dimensionCampaign = campaign.getSize();
    // получаем размер веб-элемента обычная цена
    Dimension dimensionRegular = regular.getSize();
    Assert.assertTrue(dimensionCampaign.getHeight() * dimensionCampaign.getWidth()
            > dimensionRegular.getHeight() * dimensionCampaign.getWidth());
  }

  /**
   * Парсер строки, содержащей информацию о цвете
   *
   * @param rgb
   * @return
   */
  private String[] getRGB(String rgb) {
    return rgb.substring(rgb.indexOf('(') + 1, rgb.length()-1).split(", ");
  }
}
