package com.addressbook.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.addressbook.exception.AddressBookException;

public class AddressBookServiceTest {
	
	private AddressBookService addressBookService;
	
	@Before
    public void oneTimeSetUp() {
		addressBookService = new AddressBookService();       
    }
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	

	@Test
	public void test_add_duplicate_addressBook() throws AddressBookException  {
		expectedEx.expect(AddressBookException.class);
		addressBookService.addNewAddressBook("office contact");
	    addressBookService.addNewAddressBook("office contact");
	}
	
	@Test
	public void test_add_multiple_AddressBook() throws AddressBookException {
		addressBookService.addNewAddressBook("Personal Contacts");
		addressBookService.addNewAddressBook("Work Contacts");
		assertEquals(2, addressBookService.getAllAddressBooks().size());
	}
	
	
	@Test
	public void test_add_single_contact_to_AddressBook() throws AddressBookException {
		addressBookService.addContact("office contact", "vipin", "joseph", "0000", "vjoseph@gmail.com");
		assertEquals(1, addressBookService.getAllContactsSize());
	}
	
	@Test
	public void test_add_multiple_contact_to_AddressBook() throws AddressBookException {
		addressBookService.addContact("office contact", "vipin", "joseph", "0000", "vjoseph@gmail.com");
		addressBookService.addContact("office contact", "john", "doe", "0000", "jd@gmail.com");
		assertEquals(2, addressBookService.getAllContactsSize());
	}
	
	@Test
	public void test_add_duplicate_contact_to_AddressBook() throws AddressBookException {
		addressBookService.addContact("office contact", "vipin", "joseph", "0000", "vjoseph@gmail.com");
		addressBookService.addContact("office contact", "vipin", "joseph", "0000", "vjoseph@gmail.com");
		assertEquals(1, addressBookService.getAllContactsSize());
	}
	
	@Test
	public void test_remove_contact_from_AddressBook() throws AddressBookException {
		addressBookService.addContact("office contact", "vipin", "joseph", "0000", "vjoseph@gmail.com");
		addressBookService.removeContact("office contact", "vipin", "joseph", "0000", "vjoseph@gmail.com");
		assertEquals(0, addressBookService.getAllContactsSize());
	}
	
	@Test
	public void test_remove_addressBook() throws AddressBookException {
		addressBookService.addContact("office contact", "vipin", "joseph", "0000", "vjoseph@gmail.com");
		addressBookService.addContact("office contact", "john", "doe", "0000", "jj@gmail.com");
		addressBookService.removeAddressBook("office contact");
		assertEquals(0, addressBookService.getAllContactsSize());
	}
	
	@Test
	public void test_print_all_contacts() throws AddressBookException  {
		addressBookService.addContact("home contact", "vipin", "joseph", "0000", "vjoseph@gmail.com");
		addressBookService.addContact("personal contact", "vipin", "joseph", "0000", "vjoseph@gmail.com");
		addressBookService.addContact("work contact", "vipin", "joseph", "0000", "vjoseph@gmail.com");
		addressBookService.addContact("work contact", "john", "doe", "0000", "jj@gmail.com");
		assertEquals(4, addressBookService.getAllContactsSize());
	}
	
	@Test
	public void test_unique_contacts() throws AddressBookException  {
		addressBookService.addContact("home contact", "vipin", "joseph", "0000", "vjoseph@gmail.com");
		addressBookService.addContact("personal contact", "vipin", "joseph", "0000", "vjoseph@gmail.com");
		addressBookService.addContact("work contact", "vipin", "joseph", "0000", "vjoseph@gmail.com");
		addressBookService.addContact("work contact", "john", "doe", "0000", "jj@gmail.com");
		assertEquals(2, addressBookService.printUniqueContacts().size());
	}

}
