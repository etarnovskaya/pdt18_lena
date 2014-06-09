package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTestsWithDetails extends TestBase{
	@Test
	public void ModifySomeContact2() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().openDetailsContact();
		app.getContactHelper().initModifyContact();
		ContactData contact = new ContactData();
		contact.firstname = "Updated2";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().updateContact();
	    app.getContactHelper().returnToHomePage();

	}

}
