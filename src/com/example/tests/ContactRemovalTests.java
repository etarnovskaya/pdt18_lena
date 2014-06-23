package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
//Deleting contact, using "Details" icon
public class ContactRemovalTests extends TestBase {
	@Test
	public void deleteSomeContactDetails() {
		
	app.getNavigationHelper().openMainPage();
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
	app.getContactHelper().openDetailesContactByIndex(0);
	app.getContactHelper().initModifyContact();
	app.getContactHelper().deleteContact();
	app.getContactHelper().returnToHomePage();
	List<ContactData> newList = app.getContactHelper().getContacts();
	oldList.remove(0);
	Collections.sort(oldList);
	assertEquals(newList, oldList);


}
	
	@Test
	public void deleteSomeContactEdit() {
		
	app.getNavigationHelper().openMainPage();
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
	app.getContactHelper().openEditContactByIndex(0);
	app.getContactHelper().deleteContact();
	app.getContactHelper().returnToHomePage();
	List<ContactData> newList = app.getContactHelper().getContacts();
	oldList.remove(0);
	Collections.sort(oldList);
	assertEquals(newList, oldList);

	}
}
