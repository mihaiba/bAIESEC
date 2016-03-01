package com.levi9.rest.Rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.levi9.rest.Rest.memoryDB.Database;
import com.levi9.rest.Rest.models.Contact;
import com.levi9.rest.Rest.models.User;

public class ContactService {

	private Map<String, User> users = Database.getUsers();

	public Contact addContact(String userName, Contact contact) {
		if (!users.get(userName).isAuthenticated()) {
			return null;
		}
		Map<String, Contact> contacts = users.get(userName).getContacts();
		contact.setId(contacts.size() + 1);
		contacts.put(contact.getPhoneNumber(), contact);
		return contact;
	}

	public List<Contact> getContacts(String userName) {
		return new ArrayList<>(users.get(userName).getContacts().values());
	}

	public Contact getContact(String userName, int contactId) {
		Map<String, Contact> contacts = users.get(userName).getContacts();
		for (Contact contact : contacts.values()) {
			if (contactId == contact.getId()) {
				return contact;
			}
		}
		return null;
	}

	public List<Contact> getContactsByName(String userName, String name) {
		Map<String, Contact> contacts = users.get(userName).getContacts();
		List<Contact> filteredContacts = new ArrayList<>();
		for (Contact contact : contacts.values()) {
			if (contact.getFirstName().toUpperCase().contains(name.toUpperCase())
					|| contact.getLastName().toUpperCase().contains(name.toUpperCase())) {
				filteredContacts.add(contact);
			}
		}
		return filteredContacts;
	}

	public List<Contact> getContactsByPhoneNumber(String userName, String phoneNumber) {
		Map<String, Contact> contacts = users.get(userName).getContacts();
		List<Contact> filteredContacts = new ArrayList<>();
		for (Map.Entry<String, Contact> contact : contacts.entrySet()) {
			if (contact.getKey().contains(phoneNumber)) {
				filteredContacts.add(contact.getValue());
			}
		}
		return filteredContacts;
	}
}