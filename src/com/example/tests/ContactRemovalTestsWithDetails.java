package com.example.tests;

import org.testng.annotations.Test;
//Deleting contact, using "Details" icon
public class ContactRemovalTestsWithDetails extends TestBase {
	@Test
	public void deleteSomeContact2() {
		
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().openDetailsContact();
	app.getContactHelper().initModifyContact();
	app.getContactHelper().deleteContact();
	app.getContactHelper().returnToHomePage();

}
}
