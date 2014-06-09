package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTestsWithPencil extends TestBase {
	@Test
	public void modifySomeContact1(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().openEditContact();
		ContactData contact = new ContactData();
		contact.firstname = "newUpdated";
		app.getContactHelper().fillContactForm(contact );
		app.getContactHelper().updateContact();
	    app.getContactHelper().returnToHomePage();
	}
			
			
			
	

}
