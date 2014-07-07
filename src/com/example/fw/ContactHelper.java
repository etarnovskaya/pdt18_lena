package com.example.fw;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase{
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<ContactData> cachedContacts;

	public SortedListOf<ContactData> getContacts() {
		if(cachedContacts == null){
			rebuildCache();
		}
		return cachedContacts;
	}

	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (WebElement row : rows) {
		
		String lastname = row.findElement(By.xpath(".//td[2]")).getText();
		String firstname = row.findElement(By.xpath(".//td[3]")).getText();
		
		cachedContacts.add(new ContactData().withFirstname(firstname).withLastname(lastname));
		
	}
}
	
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		initContactCreation();
		fillContactForm(contact, CREATION);
		submitContactCreation();
		returnToHomePage();	
		rebuildCache();
		return this;

	}
	
	public ContactHelper modifyContact(ContactData contact) {
		fillContactForm(contact, MODIFICATION);
		clickOnButtonUpdateContact();
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
	public ContactHelper deleteContact(ContactData contact) {
		clickOnButtonDeleteContact();
		returnToHomePage();
		rebuildCache();
		return this;
	}
	
	//-------------------------------------------------------------------------------------------------------
	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}
	
	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHomephone());
		type(By.name("mobile"), contact.getMobilephone());
		type(By.name("work"), contact.getWorkphone());
		type(By.name("email"), contact.getEmail());
		type(By.name("email2"), contact.getEmail2());
		selectByText(By.name("bday"), contact.getBday());
		selectByText(By.name("bmonth"), contact.getBmonth());
		type(By.name("byear"), contact.getByear());
		if (formType == CREATION){
		    selectByText(By.name("new_group"), contact.getTogroup());
		} else {
			if (driver.findElements(By.name("new group")).size() != 0){
				throw new Error ("Groupselector exists in contact modification form");
			}
		}
			
		type(By.name("address2"), contact.getAddress2());
		type(By.name("phone2"), contact.getHomephone2());
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper clickOnButtonDeleteContact() {
		click(By.xpath("//input[@value='Delete']")); 
		cachedContacts = null;
		return this;
	}

	public ContactHelper initModifyContact() {
		click(By.name("modifiy"));
		
		return this;
	}

	public ContactHelper clickOnButtonUpdateContact() {
		click(By.xpath("//input[@value='Update']")); 
		cachedContacts = null;
		return this;
	}
	 
	public void selectContactByIndex(int index) {
		click(By.xpath("//tr[" + (index + 2) + "]/td[1]"));
	}
		
	public ContactHelper openDetailesContactByIndex(int index) {
		click(By.xpath("(//img[@alt='Details'])[" + (index + 2) + "]"));
		return this;
	}
		
	public ContactHelper openEditContactByIndex(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 2) + "]"));
		return this;
	}
}

