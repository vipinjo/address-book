package com.addressbook.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddressBook {

	private String name;
	private Set<Contact> contacts;

	public AddressBook(String name) {
		this.name = name;
		this.contacts = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Contact> getContacts() {
		return new ArrayList<>(contacts);
	}

	public boolean addContact(Contact contact) {
		if (contacts != null) {
			return contacts.add(contact);
		}
		return false;
	}
	
	public boolean removeContact(Contact contact) {
		if (contacts != null) {
			return contacts.remove(contact);
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n")
		.append("Address book name : ")
		.append(name).append("\n")
		.append("--------").append("\n")
		.append(contacts.toString());
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
		AddressBook addressBookToCheck = (AddressBook) obj;
		if (this.name == null)
			return false;
		if (addressBookToCheck.getName() == null)
			return false;
		if (!this.name.equalsIgnoreCase(addressBookToCheck.getName()))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

}
