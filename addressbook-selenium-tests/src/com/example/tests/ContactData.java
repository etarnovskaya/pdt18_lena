package com.example.tests;

public class ContactData {
	public String firstname;
	public String lastname;
	public String address;
	public String homePhone;
	public String mobilePhone;
	public String workPhone;
	public String email;
	public String email2;
	public String bDay;
	public String bMonth;
	public String bYear;
	public String toGroup;
	public String address2;
	public String homePhone2;

	public ContactData() {
		
	}
	public ContactData(String firstname, String lastname, String address,
			String homePhone, String mobilePhone, String workPhone,
			String email, String email2, String bDay, String bMonth,
			String bYear, String toGroup, String address2, String homePhone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.email = email;
		this.email2 = email2;
		this.bDay = bDay;
		this.bMonth = bMonth;
		this.bYear = bYear;
		this.toGroup = toGroup;
		this.address2 = address2;
		this.homePhone2 = homePhone2;
	}
}