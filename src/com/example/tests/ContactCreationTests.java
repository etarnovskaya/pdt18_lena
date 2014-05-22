package com.example.tests;


import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	openMainPage();
    initCreatingNewContact();
    ContactData contact = new ContactData();
    contact.firstname = "Lena";
    contact.lastname = "Tarnovskaya";
    contact.address = "Moscow";
    contact.homephone = "7778889991";
    contact.mobilephone = "9998887778888";
    contact.workphone = "77889900886655";
    contact.email = "hhh@hhh.com";
    contact.email2 = "mail@mail.mail";
    contact.bday = "17";
    contact.bmonth ="May";
    contact.byear = "1980";
    contact.group = "group 1";
    contact.address2 = "Tel Aviv";
    contact.homephone2 = "11111111111";
	fillContactForm(contact);
    submitContactCreation();
    initCreateNextContact();
  }
  
  @Test
  public void testEmptyContactCreation2() throws Exception {
	openMainPage();
    initCreatingNewContact();
    ContactData contact = new ContactData();
    contact.firstname = "";
    contact.lastname = "";
    contact.address = "";
    contact.homephone = "";
    contact.mobilephone = "";
    contact.workphone = "";
    contact.email = "";
    contact.email2 = "";
    contact.bday = "-";
    contact.bmonth ="-";
    contact.byear = "";
    contact.group = "[none]";
    contact.address2 = "";
    contact.homephone2 = "";
	fillContactForm(contact);
    submitContactCreation();
    initCreateNextContact();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	openMainPage();
    initCreatingNewContact();
    fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "[none]", "", ""));
    submitContactCreation();
    initCreateNextContact();
  }
}
