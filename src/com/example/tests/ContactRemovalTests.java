package com.example.tests;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {
	@Test(dataProvider = "randomValidContactGenerator")
	
	public void deleteSomeContactDetails(ContactData contact) {
		
	app.navigateTo().mainPage();
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	
	Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
    
	app.getContactHelper()
		.openDetailesContactByIndex(index)
		.initModifyContact();
	app.getContactHelper().deleteContact(contact);
	
	SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	
	assertThat(newList, equalTo(oldList.without(contact)));
	
}
	
	@Test(dataProvider = "randomValidContactGenerator")
	
	public void deleteSomeContactEdit(ContactData contact) {
		
	app.navigateTo().mainPage();
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	Random rnd = new Random();
    int index = rnd.nextInt(oldList.size()-1);
	
    app.getContactHelper()
		.openEditContactByIndex(index);
	app.getContactHelper().deleteContact(contact);

	SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	assertThat(newList, equalTo(oldList.without(contact)));

	}
}
