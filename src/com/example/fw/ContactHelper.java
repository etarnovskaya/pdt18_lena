package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}
	
	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address1);
		type(By.name("home"), contact.homephone);
		type(By.name("mobile"), contact.mobilephone);
		type(By.name("work"), contact.workphone);
		type(By.name("email"), contact.email1);
		type(By.name("email2"), contact.email2);
		selectByText(By.name("bday"), contact.bday);
		selectByText(By.name("bmonth"), contact.bmonth);
		type(By.name("byear"), contact.byear);
	    //selectByText(By.name("new_group"), contact.togroup);
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.homephone2);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void deleteContact() {
		click(By.xpath("//input[@value='Delete']")); 
	}

	public void initModifyContact() {
		click(By.name("modifiy"));
		
	}

	public void updateContact() {
		click(By.xpath("//input[@value='Update']")); 

	}
	 
	public void submitContactModification() {
		click(By.xpath("(//input[@name='update'])[1]"));//button update
	}
	
	public void selectContactByIndex(int index) {
		click(By.xpath("//tr[" + (index + 2) + "]/td[1]"));
	}
		
	public void openDetailesContactByIndex(int index) {
	click(By.xpath("(//img[@alt='Details'])[" + (index + 2) + "]"));
	}
		
	public void openEditContactByIndex(int index) {
	click(By.xpath("(//img[@alt='Edit'])[" + (index + 2) + "]"));
	}
	
	public List<ContactData> getContacts() {
	List<ContactData> contacts = new ArrayList<ContactData>();
	List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
	
	for (WebElement checkbox : checkboxes) {
		ContactData contact = new ContactData();
//		Help!! вопрос. как в contact.lastname & contact.firstname записать данные из ячеек таблицы? (td[3] & td[2])? 
//		у меня не получается, из-за этого я не могу двигаться дальше. тот метод GetContacts, который я написала, 
//		работает только на создание контакта. 
//		Если я с помощью xpath .//*[@id='maintable']/tbody/tr"));//выделила строку, получаем такие данные:
//		
//		<input id="id171" type="checkbox" accept="etar@ghh.com;lena@mail.hk" 
//		alt="Select (Aalena Aarnovsky)" title="Select (Aalena Aarnovsky)" value="171" name="selected[]"/>
//		</td>
//		
//		<td>Aarnovsky</td>
//		<td>Aalena</td>
		
//		contact.lastname = "";
//		contact.firstname = "";
//		
		
		
			
			String title = checkbox.getAttribute("title");
			
			contact.firstname = title.substring("Select (".length(), title.indexOf(" ", "Select (".length()));;
			contact.lastname = title.substring("Select (".length()+contact.firstname.length()+1, title.length()-" ".length());				
		contacts.add(contact);
	}
	
	return contacts;

	}
}

