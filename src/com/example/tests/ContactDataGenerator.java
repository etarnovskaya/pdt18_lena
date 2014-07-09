package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
if(args.length<3){
	System.out.println("Please specify parameters: <amount test data> <file> <format>");
	return;
	}
	int amount = Integer.parseInt(args[0]);
	File file = new File(args[1]);
	String format = args[2];
	
	List<ContactData> contacts = generateRandomContacts(amount);
	if("csv".equals(format)){
		saveContactsToCsvFile(contacts, file);
	} else if ("xml".equals(format)){
		saveContactsToXmlFile(contacts, file);
	} else {
		System.out.println ("Unknoun format" + format);
		return;

	}
	}

	private static void saveContactsToXmlFile(List<ContactData> contacts,
			File file) {
		
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts,
			File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			
			
		}
		writer.close();
		
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++){
			ContactData contact = new ContactData()
			.withFirstname(generateRandomString())
			.withLastname(generateRandomString())
			.withAddress(generateRandomString())
			.withHomephone(generateRandomString())
			.withMobilephone(generateRandomString())
			.withEmail(generateRandomString())
			.withEmail2(generateRandomString())
//			.withBday()
//			.withbmonth()
//			.withByear()
//			.withTogroup()
			.withAddress2(generateRandomString())
			.withHomephone2(generateRandomString());
			
			list.add (contact);
		}
		return list;
	}
	public static String generateRandomString(){
		Random rnd = new Random();
		if (rnd.nextInt(5) == 0){
		return "";
		}
		else {
			return "test" + rnd.nextInt();	
		}
	}
}
