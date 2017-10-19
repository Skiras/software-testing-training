/**
 * Created by Anton on 16 Окт., 2017.
 */
package ru.stqa.training.selenium.models;

/**
 * модель товара
 */
public class Goods {

  private String title;

  private String regularPrice;

  private String campaignPrice;

  public Goods() {
  }

  public Goods(String title, String regularPrice, String campaignPrice) {
    this.title = title;
    this.regularPrice = regularPrice;
    this.campaignPrice = campaignPrice;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getRegularPrice() {
    return regularPrice;
  }

  public void setRegularPrice(String regularPrice) {
    this.regularPrice = regularPrice;
  }

  public String getCampaignPrice() {
    return campaignPrice;
  }

  public void setCampaignPrice(String campaignPrice) {
    this.campaignPrice = campaignPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Goods)) return false;

    Goods goods = (Goods) o;

    if (getTitle() != null ? !getTitle().equals(goods.getTitle()) : goods.getTitle() != null) return false;
    if (getRegularPrice() != null ? !getRegularPrice().equals(goods.getRegularPrice()) : goods.getRegularPrice() != null)
      return false;
    return getCampaignPrice() != null ? getCampaignPrice().equals(goods.getCampaignPrice()) : goods.getCampaignPrice() == null;
  }

  @Override
  public int hashCode() {
    int result = getTitle() != null ? getTitle().hashCode() : 0;
    result = 31 * result + (getRegularPrice() != null ? getRegularPrice().hashCode() : 0);
    result = 31 * result + (getCampaignPrice() != null ? getCampaignPrice().hashCode() : 0);
    return result;
  }
}
