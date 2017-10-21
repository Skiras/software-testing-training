/**
 * Created by Anton on 20 Окт., 2017.
 */
package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.models.Product;

/**
 * лекция: 6. Действия с элементами
 * задание: Задание 12. Сделайте сценарий добавления товара
 */
public class Task12 extends LiteCartLoginTest {

  @Test
  public void addNewProductTest() {
    clickOnElement("//*[text()='Catalog']");
    clickOnElement("//*[text()=' Add New Product']");
    Product product = new Product();
    fillNewProductInfo(product);
    clickOnElement(getXPathByNameAtt("save"));
    Assert.assertTrue(isElementPresent(By.xpath("//a[text()='" + product.getName() + "']")));
  }

  private void fillNewProductInfo(Product product) {
    // устанавливаем статус enabled
    clickOnElement("//*[contains(text(), 'Enabled')]/input");
    fillField(getXPathByNameAtt("name[en]"), product.getName());
    fillField(getXPathByNameAtt("code"), product.getCode());
    selectAll(getXPathByNameAtt("categories[]"));
    selectRandomValue(getXPathByNameAtt("default_category_id"));
    selectAll(getXPathByNameAtt("product_groups[]"));
    fillFieldWithClear(getXPathByNameAtt("quantity"), product.getQuantity());
    selectRandomValue(getXPathByNameAtt("quantity_unit_id"));
    selectRandomValue(getXPathByNameAtt("delivery_status_id"));
    selectRandomValue(getXPathByNameAtt("sold_out_status_id"));
    fillField(getXPathByNameAtt("new_images[]"), product.getImagePath());
    fillField(getXPathByNameAtt("date_valid_from"), product.getDateValidFrom());
    fillField(getXPathByNameAtt("date_valid_to"), product.getDateValidTo());
    clickOnElement("//*[text()='Information']");
    wait.until(d -> d.findElement(By.xpath(getXPathByNameAtt("manufacturer_id"))));
    selectRandomValue(getXPathByNameAtt("manufacturer_id"));
    selectRandomValue(getXPathByNameAtt("supplier_id"));
    fillField(getXPathByNameAtt("keywords"), product.getKeywords());
    fillField(getXPathByNameAtt("short_description[en]"), product.getShortDescription());
    fillField("//*[@class='trumbowyg-editor']", product.getDescription());
    fillField(getXPathByNameAtt("head_title[en]"), product.getHeadTitle());
    fillField(getXPathByNameAtt("meta_description[en]"), product.getMetaDescription());
    clickOnElement("//*[text()='Prices']");
    wait.until(d -> d.findElement(By.xpath(getXPathByNameAtt("purchase_price"))));
    fillFieldWithClear(getXPathByNameAtt("purchase_price"), product.getPurchasePrice());
    selectRandomValue(getXPathByNameAtt("purchase_price_currency_code"));
    selectRandomValue(getXPathByNameAtt("tax_class_id"));
    fillField(getXPathByNameAtt("prices[USD]"), product.getPriceUSD());
    fillField(getXPathByNameAtt("prices[EUR]"), product.getPriceEUR());
  }
}
