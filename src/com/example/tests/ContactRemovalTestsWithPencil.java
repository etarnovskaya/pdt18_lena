package com.example.tests;

import org.testng.annotations.Test;

//Deleting contact, using "Edit" icon
public class ContactRemovalTestsWithPencil extends TestBase {
	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().openEditContact();
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToHomePage();
	}
}
