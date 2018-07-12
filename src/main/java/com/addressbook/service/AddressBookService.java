package com.addressbook.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.addressbook.dao.AddressBookDao;
import com.addressbook.dao.AddressBookDaoImpl;
import com.addressbook.entity.AddressBook;
import com.addressbook.entity.Contact;
import com.addressbook.exception.AddressBookException;

public class AddressBookService {

	private AddressBookDao addressBookDao;

	public AddressBookService() {
		this.addressBookDao = new AddressBookDaoImpl();
	}

	/**
	 * Creates a new address book with the given name. If an address book exits with
	 * a given name this method throws an exception
	 * 
	 * @param name
	 * @return
	 * @throws AddressBookException
	 */
	public AddressBook addNewAddressBook(String name) throws AddressBookException {
		return this.addressBookDao.saveAddressBook(name);
	}

	/**
	 * Creates a new contact to the given addressBook. If the address book does not
	 * exists, it creates a new address book with given name.
	 * 
	 * @param addressBookName
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param email
	 * @throws AddressBookException
	 */
	public void addContact(String addressBookName, String firstName, String lastName, String phoneNumber, String email)
			throws AddressBookException {
		if (addressBookName != null && isValidContact(firstName, lastName, phoneNumber, email)) {
			if (addressBookDao.getAddressBook(addressBookName) != null) {
				addressBookDao.getAddressBook(addressBookName)
						.addContact(new Contact(firstName, lastName, phoneNumber, email));
			} else {
				AddressBook addressBook = this.addressBookDao.saveAddressBook(addressBookName);
				addressBook.addContact(new Contact(firstName, lastName, phoneNumber, email));
			}
		} else {
			throw new AddressBookException("Cannot create contact : "
					+ getaddContactErrorMessage(addressBookName, firstName, lastName, phoneNumber, email));
		}
	}

	/**
	 * Returns a list of all the available address books
	 * @return
	 */
	public List<AddressBook> getAllAddressBooks() {
		return this.addressBookDao.getAddressBooks();
	}
	
	/**
	 * Returns a list of all the contacts in the given address book.
	 * @param addressBookName
	 * @return
	 */
	public List<Contact> getContactsInAddressBook(String addressBookName) {
		if (addressBookName != null && addressBookDao.getAddressBook(addressBookName) != null) {
			AddressBook addressBook = addressBookDao.getAddressBook(addressBookName);
			return addressBook.getContacts();
		}
		return null;
	}
	
	/**
	 * Remove contact from the given address book
	 * @param addressBookName
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param email
	 * @return
	 */
	public boolean removeContact(String addressBookName, String firstName, String lastName, String phoneNumber,
			String email) {
		boolean isRemoved = false;
		if (addressBookName != null && isValidContact(firstName, lastName, phoneNumber, email)) {
			AddressBook addressBook = addressBookDao.getAddressBook(addressBookName);
			if (addressBook != null) {
				isRemoved = addressBook.removeContact(new Contact(firstName, lastName, phoneNumber, email));
			}
		}

		return isRemoved;
	}
	
	/**
	 * Removes address book and all its contacts
	 * @param addressBookName
	 * @return
	 */
	public boolean removeAddressBook(String addressBookName) {
		if (addressBookName != null) {
				 return addressBookDao.removeAddressBook(addressBookName);
		}
		
		return false;
	}
	
	/**
	 * Print contacts in all the available address books
	 * @return
	 */
	public List<AddressBook> printAllContacts() {
		return getAllAddressBooks();
	}
	
	/**
	 * Print Unique contacts
	 * @return
	 */
	public Set<Contact> printUniqueContacts() {
		List<AddressBook> allAddressBooks = getAllAddressBooks();
		Set<Contact> uniqueContacts = new HashSet<>();
		for (AddressBook addressBook : allAddressBooks) {
			for(Contact contact : addressBook.getContacts()) {
			    uniqueContacts.add(contact);
			}
		}
		
		return uniqueContacts;
	}
	
	/**
	 * get the count of all contacts
	 * @return
	 */
	public int getAllContactsSize() {
		int contactCount = 0;
		List<AddressBook> allAddressBooks = getAllAddressBooks();
		for (AddressBook addressBook : allAddressBooks) {
			for(Contact contact : addressBook.getContacts()) {
				if (contact != null)
				    contactCount++;
			}
		}
		return contactCount;
	}
	
	public boolean isValidContact(String firstName, String lastName, String phoneNumber, String email) {
		if (firstName != null && lastName != null && phoneNumber != null && email != null) {
			return true;
		}
		return false;
	}
	
	public String getaddContactErrorMessage(String addressBookName, String firstName, String lastName,
			String phoneNumber, String email) {
		StringBuilder message = new StringBuilder();
		if (addressBookName == null) {
			message.append("Address Book name is empty : ");
		}
		if (firstName == null) {
			message.append("Contact first Name is empty : ");
		}
		if (lastName == null) {
			message.append("Contact last name is empty : ");
		}
		if (phoneNumber == null) {
			message.append("Contact phone number is empty : ");
		}
		if (email == null) {
			message.append("Contact email is empty : ");
		}
		return message.toString();
	}
	
	

}
