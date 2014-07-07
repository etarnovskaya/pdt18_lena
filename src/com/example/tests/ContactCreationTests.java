
package com.example.tests;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase{
 	
	@Test(dataProvider = "randomValidContactGenerator")
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
