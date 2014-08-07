package com.example.fw;


public class ContactHelper extends HelpersBase {

	public ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void createContact(Contact contact) {
		initContactCreation();
		fillContactForm(contact);
		confirmContactCreation();
	}
	
	public void removeContact() {
		selectFirstContact();
		initContactRemoval();
		confirmContactRemoval();
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	private void initContactCreation() {
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5000)
		.click("TRbButton4").winWaitAndActivate("Add Contact", "", 5000);
	}
	
	private void fillContactForm(Contact contact) {
		manager.getAutoItHelper()
		.send("TDBEdit12", contact.firstname)
		.send("TDBEdit11", contact.lastname);
	}

	private void confirmContactCreation() {
		manager.getAutoItHelper()
		.click("TRbButton1").winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	
	public void selectFirstContact(){
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5000)
		.focus("TListView1")
		.send("{DOWN} {SPASE}");
	}
	
	private void initContactRemoval() {
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5000)
		.click("TRbButton2");
	}

	private void confirmContactRemoval() {
		manager.getAutoItHelper()
		.winWaitAndActivate("Confirm", "", 5000)
		.click("TButton2");
	}
	
	public Contact getFirstContact() {
		selectFirstContact();
		manager.getAutoItHelper()
		.click("Edit")
		.winWaitAndActivate("Update Contact", "", 5000);
		Contact contact = new Contact()
		.setFirstName(manager.getAutoItHelper().getText("TDBEdit12"))
		.setLastName(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper().click("Cancel")
		.winWaitAndActivate("AddressBook Portable", "", 5000);
		return contact;		
	}

}
