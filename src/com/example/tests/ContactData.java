package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String firstname;
	private String lastname;
	private String homephone;
	private String mobilephone;
	private String workphone;
	private String email;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private String togroup;
	private String address2;
	private String homephone2;
	private String address;
	
	


	public ContactData() {
	}
	
	public ContactData(String firstname, String lastname, String address,
			String homephone, String mobilephone, String workphone,
			String email, String email2, String bday, String bmonth,
			String byear, String togroup, String address2, String homephone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.homephone = homephone;
		this.mobilephone = mobilephone;
		this.workphone = workphone;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.togroup = togroup;
		this.address2 = address2;
		this.homephone2 = homephone2;
	}




	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getHomephone() {
		return homephone;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public String getWorkphone() {
		return workphone;
	}

	public String getEmail() {
		return email;
	}

	public String getEmail2() {
		return email2;
	}

	public String getBday() {
		return bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getByear() {
		return byear;
	}

	public String getTogroup() {
		return togroup;
	}

	public String getAddress2() {
		return address2;
	}

	public String getHomephone2() {
		return homephone2;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "ContactData [lastname=" + lastname	+ ", firstname=" + firstname + "]";
	}

	protected String stringForCompare() {
		StringBuffer sb = new StringBuffer("");
		sb.append(this.lastname);
		sb.append(",");
		sb.append(this.firstname);

		return sb.toString();
	}

	@Override
	public int compareTo(ContactData other) {
		return this.stringForCompare().toLowerCase().compareTo(other.stringForCompare().toLowerCase());
	}

	@Override
	public int hashCode() {
		int result = 1;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} 
		else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
			return false;
		} 
		else if (!lastname.equals(other.lastname))
		return false;
		return true;
	}

	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ContactData withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}

	public ContactData withHomephone(String homephone) {
		this.homephone = homephone;
		return this;
	}

	public ContactData withMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
		return this;
	}

	public ContactData withEmail(String email) {
		this.email = email;
		return this;
	}

	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withHomephone2(String homephone2) {
		this.homephone2 = homephone2;
		return this;
	}

	
	
	
}