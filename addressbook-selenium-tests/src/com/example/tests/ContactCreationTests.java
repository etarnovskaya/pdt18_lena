
package com.example.tests;

import org.testng.annotations.Test;
//import org.junit.*;

public class ContactCreationTests extends TestBase {
  @Test 
  public void testNonEmptyContactCreation() throws Exception {
    openMainPage();
    initContactCreation();
    ContactData contact = new ContactData();
    contact.firstname = "firstname";
    contact.lastname = "lastname";
    contact.address = "address";
    contact.homePhone = "7777777777";
    contact.mobilePhone = "8888888888";
    contact.workPhone = "99999999999";
    contact.email = "dsdsd@hjhjhj.com";
    contact.email2 = "ghhjghgjh@hjhjhj.ru";
    contact.bDay = "17";
    contact.bMonth = "November";
    contact.bYear = "2000";
    contact.toGroup = "group1";
    contact.address2 = "New York";
    contact.homePhone2 = "77777779999";
    fillContactForm(contact);
    submitContactCreation();
    goToHomePage();
  }

  @Test
  public void testEmptyContactCreation() throws Exception {
    openMainPage();
    initContactCreation();
    ContactData contact = new ContactData();
    contact.firstname = "";
    contact.lastname = "";
    contact.address = "";
    contact.homePhone = "";
    contact.mobilePhone = "";
    contact.workPhone = "";
    contact.email = "";
    contact.email2 = "";
    contact.bDay = "-";
    contact.bMonth = "-";
    contact.bYear = "";
    contact.toGroup = "[none]";
    contact.address2 = "";
    contact.homePhone2 = "";
    fillContactForm(contact);
    submitContactCreation();
    goToHomePage();
  }
}
