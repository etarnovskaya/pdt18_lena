
package com.example.tests;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;

import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase{
 	
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
	}
	
	

	@Test(dataProvider = "contactsFromFile")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	app.navigateTo().mainPage();
	//old state
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	//action
	app.getContactHelper().createContact(contact);
	
	SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	assertThat(newList, equalTo(oldList.withAdded(contact)));
}
  
  
}
