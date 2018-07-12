package com.addressbook.dao;

import java.util.List;

import com.addressbook.entity.AddressBook;
import com.addressbook.exception.AddressBookException;

public interface AddressBookDao {
	
	AddressBook saveAddressBook(String name) throws AddressBookException;
	
	List<AddressBook> getAddressBooks();
	
	AddressBook getAddressBook(String name);
	
	boolean removeAddressBook(String name);

}
