package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
if(args.length<3){
	System.out.println("Please specify parameters: <amount test data> <file> <format>");
	return;
	}
	int amount = Integer.parseInt(args[0]);
	File file = new File(args[1]);
	String format = args[2];
	
	if (file.exists()){
		System.out.println("File exists, please remove it manually: " + file);
	}

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

	public static void saveContactsToXmlFile(List<ContactData> contacts,
			File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	
	}
	
	public static List<ContactData> loadContactsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
				return (List<ContactData>) xstream.fromXML(file);

	}

	private static void saveContactsToCsvFile(List<ContactData> contacts,
			File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstname() + "," + contact.getLastname() + 
					"," + contact.getAddress() + "," + contact.getHomephone() + 
					"," + contact.getMobilephone() + "," + contact.getEmail() + 
					"," + contact.getEmail2() + "," + contact.getBday() + "," + 
					contact.getBmonth()+ "," + contact.getByear() + "," + contact.getTogroup() 
					+ "," + contact.getAddress2() + "," + contact.getHomephone2() + ",!" +"\n");
		}
		writer.close();
		
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
		String[] part = line.split(",")	;
		ContactData contact = new ContactData()
			.withFirstname(part[0])
			.withLastname(part[1])
			.withAddress(part[2])
			.withHomephone(part[3])
			.withMobilephone(part[4])
			.withEmail(part[5])
			.withEmail2(part[6])
			.withBday(part[7])
			.withBmonth(part[8])
			.withByear(part[9])
			.withTogroup(part[10])
			.withAddress2(part[11])
			.withHomephone2(part[12]);
		list.add(contact);
		bufferedReader.readLine();	
		}
		bufferedReader.close();
		return list;
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++){
			ContactData contact =  new ContactData()
			.withFirstname(generateRandomString())
			.withLastname(generateRandomString())
			.withAddress(generateRandomString())
			.withHomephone(generateRandomString())
			.withMobilephone(generateRandomString())
			.withEmail(generateRandomString())
			.withEmail2(generateRandomString())
			.withBday("")
			.withBmonth("")
			.withByear("1099")
			.withTogroup("-")
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
