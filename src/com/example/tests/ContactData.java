package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	public String firstname;
	public String lastname;
	public String address1;
	public String homephone;
	public String mobilephone;
	public String workphone;
	public String email1;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String togroup;
	public String address2;
	public String homephone2;

	public ContactData() {
	}
	
	public ContactData(String firstname, String lastname, String address1,
			String homephone, String mobilephone, String workphone,
			String email1, String email2, String bday, String bmonth,
			String byear, String togroup, String address2, String homephone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address1 = address1;
		this.homephone = homephone;
		this.mobilephone = mobilephone;
		this.workphone = workphone;
		this.email1 = email1;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.togroup = togroup;
		this.address2 = address2;
		this.homephone2 = homephone2;
	}




	@Override
	public String toString() {
		//return "ContactData [firstname=" + firstname + ", lastname=" + lastname	+ "]";
		return "ContactData [lastname=" + lastname	+ ", firstname=" + firstname + "]";
	}

	@Override
	public int compareTo(ContactData other) {
		int lastname = this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
		if (lastname != 0) {
		  return lastname;
		} else {
		return this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
		}
	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
//		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
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
	
	
}