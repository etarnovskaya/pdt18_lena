package com.example.tests;

public class GroupData implements Comparable<GroupData> {
	private String name;
	private String header;
	private String footer;
	

	public GroupData() {
	}
	
	public GroupData(String groupname, String header, String footer) {
		this.name = groupname;
		this.header = header;
		this.footer = footer;
	}

	@Override
	public String toString() {
		return "GroupData [name=" + name + "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		GroupData other = (GroupData) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	//@Override
	public int compareTo(GroupData other) {
//		int name = this.name.compareTo(other.name);
//		if (name != 0) {
//			return 0;
//		}
//		else {
			return this.name.toLowerCase().compareTo(other.name.toLowerCase());
		}
//		return this.name.toLowerCase().compareTo(other.name.toLowerCase());
//	}
//	
//	int fileld1result = this.field1.compareTo(other.field1);
//	if (fileld1result != 0) {
//	  return fileld1result;
//	} else {
//	  return this.field2.compareTo(other.field2);
//	}
//	

	public GroupData withName(String name) {
		this.name = name;
		return this;
	}

	public GroupData withHeader(String header) {
		this.header = header;
		return this;
	}

	public GroupData withFooter(String footer) {
		this.footer = footer;
		return this;
	}

	public String getName() {
		return name;
	}

	public String getHeader() {
		return header;
	}

	public String getFooter() {
		return footer;
	}

	
}