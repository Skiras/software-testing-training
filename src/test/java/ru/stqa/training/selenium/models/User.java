/**
 * Created by Anton on 18 Окт., 2017.
 */
package ru.stqa.training.selenium.models;

import ru.stqa.training.selenium.utills.RandomString;

import java.util.Random;

public class User {
  private String taxID;
  private String company;
  private String firstName;
  private String lastName;
  private String address1;
  private String address2;
  private String postcode;
  private String city;
  private String country;
  private String email;
  private String phone;
  private String password;

  public User() {
    Random generator = new Random();
    RandomString randomString = new RandomString();
    taxID = String.valueOf(generator.nextInt(100000));
    company = randomString.nextString();
    firstName = randomString.nextString();
    lastName = randomString.nextString();
    address1 = randomString.nextString();
    address2 = randomString.nextString();
    postcode = String.valueOf(generator.nextInt(90000) + 10000);
    country = "United States";
    city = randomString.nextString();
    email = randomString.nextString() + "@" + randomString.nextString() + ".com";
    phone = String.valueOf(generator.nextInt(90000000) + 10000000);
    password = randomString.nextString();
  }

  public String getTaxID() {
    return taxID;
  }

  public String getCompany() {
    return company;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress1() {
    return address1;
  }

  public String getAddress2() {
    return address2;
  }

  public String getPostcode() {
    return postcode;
  }

  public String getCity() {
    return city;
  }

  public String getCountry() {
    return country;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getPassword() {
    return password;
  }
}
