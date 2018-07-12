package com.addressbook.entity;

public class Contact {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;

	public Contact(String firstName, String lastName, String phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n")
		.append("firstName : ").append(firstName).append("\n")
		.append("lastName : ").append(lastName).append("\n")
		.append("phoneNumber : ").append(phoneNumber).append("\n")
		.append("email : ").append(email).append("\n");
		
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Contact contactToCheck = (Contact) obj;
		if (this.firstName == null)
			return false;
		if (this.lastName == null)
			return false;
		if (this.firstName == null)
			return false;
		if (this.phoneNumber == null)
			return false;
		if (this.email == null)
			return false;
		if (contactToCheck.getFirstName() == null)
			return false;
		if (contactToCheck.getLastName() == null)
			return false;
		if (contactToCheck.getPhoneNumber() == null)
			return false;
		if (contactToCheck.getEmail() == null)
			return false;
		
		if (!this.firstName.equalsIgnoreCase(contactToCheck.getFirstName()))
			return false;
		if (!this.lastName.equalsIgnoreCase(contactToCheck.getLastName()))
			return false;
		if (!this.phoneNumber.equalsIgnoreCase(contactToCheck.getPhoneNumber()))
			return false;
		if (!this.email.equalsIgnoreCase(contactToCheck.getEmail()))
			return false;

		return true;
	}
	
	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
		result = prime * result + ((this.phoneNumber == null) ? 0 : this.phoneNumber.hashCode());
		result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
		
		return result;
	}

}
