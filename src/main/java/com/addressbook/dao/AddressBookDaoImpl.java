package com.addressbook.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.addressbook.entity.AddressBook;
import com.addressbook.exception.AddressBookException;

public class AddressBookDaoImpl implements AddressBookDao {

	private HashMap<String, AddressBook> addressBooks;

	public AddressBookDaoImpl() {
		this.addressBooks = new HashMap<>();
	}

	@Override
	public AddressBook saveAddressBook(String name) throws AddressBookException {
		AddressBook addressBook = null;
		if (name != null && !name.isEmpty()) {
			if (!addressBooks.containsKey(name)) {
				addressBook = new AddressBook(name);
				addressBooks.put(name, addressBook);
			} else {
				throw new AddressBookException("Address book named " + name + " Already exits");
			}

		} else {
		    throw new AddressBookException("Address book name is empty ");
		}
		return addressBook;
	}

	public List<AddressBook> getAddressBooks() {
		return new ArrayList<AddressBook>(addressBooks.values());
	}

	@Override
	public AddressBook getAddressBook(String name) {
		return addressBooks.get(name);
	}
	
	public boolean removeAddressBook(String name) {
		boolean isRemoved = false;
		if (name != null) {
			AddressBook addressBook = addressBooks.remove(name);
			if (addressBook == null)
				isRemoved = false;
			else
				isRemoved = true;
		}
		return isRemoved;
	}

}
