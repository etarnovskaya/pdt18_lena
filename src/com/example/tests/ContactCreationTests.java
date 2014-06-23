
package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;;

public class ContactCreationTests extends TestBase{
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	//old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
	//action
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.firstname = "FAnna";
    contact.lastname = "ovsky";
    contact.address1 = "Tel Aviv";
    contact.homephone = "56677788";
    contact.mobilephone = "111111111";
    contact.workphone = "333333333";
    contact.email1 = "etar@ghh.com";
    contact.email2 = "lena@mail.hk";
    contact.bday = "17";
    contact.bmonth = "May";
    contact.byear = "1999";
    contact.togroup = "group1";
    contact.address2 = "address 2";
    contact.homephone2 = "00000000";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
   
	List<ContactData> newList = app.getContactHelper().getContacts();
//assertEquals(newList.size(), oldList.size() + 1);
oldList.add(contact);
Collections.sort(oldList);
assertEquals(newList, oldList);
}
  
  //@Test
//  public void testEmptyContactCreation() throws Exception {
//	app.getNavigationHelper().openMainPage();
//    app.getContactHelper().initContactCreation();
//    ContactData contact = new ContactData();
//    contact.firstname = "";
//    contact.lastname = "";
//    contact.address1 = "";
//    contact.homephone = "";
//    contact.mobilephone = "";
//    contact.workphone = "";
//    contact.email1 = "";
//    contact.email2 = "";
//    contact.bday = "-";
//    contact.bmonth = "-";
//    contact.byear = "";
//    contact.togroup = "[none]";
//    contact.address2 = "";
//    contact.homephone2 = "";
//	app.getContactHelper().fillContactForm(contact);
//    app.getContactHelper().submitContactCreation();
//    app.getContactHelper().returnToHomePage();
//  }
}
