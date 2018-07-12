package com.addressbook;

import com.addressbook.exception.AddressBookException;
import com.addressbook.service.AddressBookService;

public class AddressBookApplicationTest {
	
	private AddressBookService addressBookSerice;
	
	public AddressBookApplicationTest() {
		this.addressBookSerice = new AddressBookService();
	}
	
	public static void main(String[] args) {
		AddressBookApplicationTest test = new AddressBookApplicationTest();
		test.run();
	}
	
	public void run() {
		addDupicateContactToAddressBook();
		addAddressBooks();
		testRemoveContact();
		testRemoveAddressBook();
		printAllContacts();
		printUniqueContacts();
	}
	
	private void addDupicateContactToAddressBook() {
		try {
			addressBookSerice.addContact("Home Contact", "vipin", "joseph", "0000", "vj@gmail.com");
			addressBookSerice.addContact("Home Contact", "vipin", "joseph", "0000", "vj@gmail.com");
		} catch (AddressBookException e) {
			e.printStackTrace();
		}
		
		System.out.println(addressBookSerice.getContactsInAddressBook("Home Contact"));
	}
	
	private void addAddressBooks() {
		try {
			addressBookSerice.addNewAddressBook("Office Contacts");
		} catch (AddressBookException e) {
			e.printStackTrace();
		}
		
		System.out.println(addressBookSerice.getAllAddressBooks());
	}
	
	private void testRemoveContact() {
		addressBookSerice.removeContact("Home Contact", "vipin", "joseph", "0000", "vj@gmail.com");
		System.out.println(addressBookSerice.getAllAddressBooks());
	}
	
	private void testRemoveAddressBook() {
		System.out.println("----- Removing address books ");
		addressBookSerice.removeAddressBook("Home Contact");
		addressBookSerice.removeAddressBook("Office Contacts");
		System.out.println(addressBookSerice.getAllAddressBooks());
	}
	
	private void printAllContacts() {
		System.out.println("----- Print all contacts ");
		try {
			addressBookSerice.addContact("Home Contact", "vipin", "joseph", "0000", "vj@gmail.com");
			addressBookSerice.addContact("Office Contact", "vipin", "joseph", "0000", "vj@gmail.com");
			addressBookSerice.addContact("Personal Contact", "vipin", "joseph", "0000", "vj@gmail.com");
			addressBookSerice.addContact("Business Contact", "vipin", "joseph", "0000", "vj@gmail.com");
		} catch (AddressBookException e) {
			e.printStackTrace();
		}
		System.out.println(addressBookSerice.printAllContacts());
	}
	
	private void printUniqueContacts() {
		System.out.println("----- Print unique contacts ");
		try {
			addressBookSerice.addContact("Home Contact", "vipin", "joseph", "0000", "vj@gmail.com");
			addressBookSerice.addContact("Office Contact", "vipin", "joseph", "0000", "vj@gmail.com");
			addressBookSerice.addContact("Personal Contact", "vipin", "joseph", "0000", "vj@gmail.com");
			addressBookSerice.addContact("Business Contact", "vipin", "joseph", "0000", "vj@gmail.com");
		} catch (AddressBookException e) {
			e.printStackTrace();
		}
		System.out.println(addressBookSerice.printUniqueContacts());
	}
	
	
	
	

}
