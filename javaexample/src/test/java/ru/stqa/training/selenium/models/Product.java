/**
 * Created by Anton on 20 Окт., 2017.
 */
package ru.stqa.training.selenium.models;

import ru.stqa.training.selenium.utills.RandomString;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

public class Product {
  // general
  private String name;
  private String code;
  private String quantity;
  private String imagePath;
  private String dateValidFrom;
  private String dateValidTo;
  // information
  private String keywords;
  private String shortDescription;
  private String description;
  private String HeadTitle;
  private String metaDescription;
  // prices
  private String purchasePrice;
  private String priceUSD;
  private String priceEUR;

  public Product() {
    RandomString randomString = new RandomString();
    Random generator = new Random();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    name = randomString.nextString();
    code = String.valueOf(generator.nextInt(90000) + 10000);
    quantity = String.valueOf(generator.nextDouble()*99 + 1);
    imagePath  = Paths.get("duck.jpg").toAbsolutePath().toString();
    dateValidFrom = simpleDateFormat.format(new Date());
    Calendar calendar = GregorianCalendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, generator.nextInt(30));
    dateValidTo = simpleDateFormat.format(calendar.getTime());
    keywords = name + ", " + code;
    shortDescription = randomString.nextString();
    description = randomString.nextString();
    HeadTitle = randomString.nextString();
    metaDescription = randomString.nextString();
    purchasePrice = String.valueOf(generator.nextDouble()*99 + 1);
    priceUSD = String.valueOf(generator.nextDouble()*99 + 1);
    priceEUR = String.valueOf(generator.nextDouble()*99 + 1);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public String getImagePath() {
    return imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  public String getDateValidFrom() {
    return dateValidFrom;
  }

  public void setDateValidFrom(String dateValidFrom) {
    this.dateValidFrom = dateValidFrom;
  }

  public String getDateValidTo() {
    return dateValidTo;
  }

  public void setDateValidTo(String dateValidTo) {
    this.dateValidTo = dateValidTo;
  }

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getHeadTitle() {
    return HeadTitle;
  }

  public void setHeadTitle(String headTitle) {
    HeadTitle = headTitle;
  }

  public String getMetaDescription() {
    return metaDescription;
  }

  public void setMetaDescription(String metaDescription) {
    this.metaDescription = metaDescription;
  }

  public String getPurchasePrice() {
    return purchasePrice;
  }

  public void setPurchasePrice(String purchasePrice) {
    this.purchasePrice = purchasePrice;
  }

  public String getPriceUSD() {
    return priceUSD;
  }

  public String getPriceEUR() {
    return priceEUR;
  }

}
