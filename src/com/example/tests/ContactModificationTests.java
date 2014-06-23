package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	@Test
	public void modifySomeContactEdit(){
		app.getNavigationHelper().openMainPage();
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		app.getContactHelper().openEditContactByIndex(0);
		ContactData contact = new ContactData();
		contact.firstname = "newUpdated";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().updateContact();
	    app.getContactHelper().returnToHomePage();
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    oldList.remove(0);
		oldList.add(contact);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}
			
			
			
	@Test
	public void modifySomeContactDetails() {
		app.getNavigationHelper().openMainPage();
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		app.getContactHelper().openDetailesContactByIndex(0);
		app.getContactHelper().initModifyContact();
		ContactData contact = new ContactData();
		contact.firstname = "Updated2";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().updateContact();
	    app.getContactHelper().returnToHomePage();
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    oldList.remove(0);
		oldList.add(contact);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}

}
