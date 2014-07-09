package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import com.example.utils.SortedListOf;
import java.util.Date;
import java.util.Random;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase 
{
//	@Test(dataProvider = "randomValidContactGenerator")
//	public void modifySomeContactEdit(ContactData contact) {
	@Test
	public void modifySomeContactEdit() {
		ContactData contact = new ContactData().withFirstname("Ivan" + (new Date()));
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
		app.getContactHelper().openEditContactByIndex(index);
		app.getContactHelper().modifyContact(contact);
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		assertThat(newList.size(), equalTo(oldList.size()));
		assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	}
			
//	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactDetails(ContactData contact) {
		app.navigateTo().mainPage();
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
		
	    app.getContactHelper()
		.openDetailesContactByIndex(index)
		.initModifyContact();
	    app.getContactHelper().modifyContact(contact);
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		assertThat(newList, equalTo(oldList.without(contact).withAdded(contact)));

	}

}
