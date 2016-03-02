package com.levi9.rest.Rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.levi9.rest.Rest.memoryDB.Database;
import com.levi9.rest.Rest.models.Contact;
import com.levi9.rest.Rest.models.User;
import com.levi9.rest.Rest.resources.filterbeans.ContactsFilterBean;

public class ContactService {

	private Map<String, User> users = Database.getUsers();

	public Contact addContact(String userName, Contact contact) {
		Map<String, Contact> contactMap = users.get(userName).getContacts();
		contact.setId(contactMap.size() + 1);
		contactMap.put(contact.getPhoneNumber(), contact);
		return contact;
	}

	public List<Contact> getContacts(ContactsFilterBean filter) {
		Map<String, Contact> contactMap = users.get(filter.getUserName()).getContacts();
		if (!filter.getName().isEmpty()) {
			return getContactsByName(filter.getName(), contactMap);
		}
		if (!filter.getPhoneNumber().isEmpty()) {
			return getContactsByPhoneNumber(filter.getPhoneNumber(), contactMap);
		}
		return new ArrayList<>(contactMap.values());
	}

	public Contact getContact(String userName, String phoneNumber) {
		Map<String, Contact> contactMap = users.get(userName).getContacts();
		return contactMap.get(phoneNumber);
	}

	private List<Contact> getContactsByName(String name, Map<String, Contact> contactMap) {
		List<Contact> filteredContacts = new ArrayList<>();
		for (Contact contact : contactMap.values()) {
			if (contact.getFirstName().toUpperCase().contains(name.toUpperCase())
					|| contact.getLastName().toUpperCase().contains(name.toUpperCase())) {
				filteredContacts.add(contact);
			}
		}
		return filteredContacts;
	}

	private List<Contact> getContactsByPhoneNumber(String phoneNumber, Map<String, Contact> contactMap) {
		List<Contact> filteredContacts = new ArrayList<>();
		for (Map.Entry<String, Contact> contact : contactMap.entrySet()) {
			if (contact.getKey().contains(phoneNumber)) {
				filteredContacts.add(contact.getValue());
			}
		}
		return filteredContacts;
	}

	public Contact updateContact(String userName, Contact contact) {
		Map<String, Contact> contactMap = users.get(userName).getContacts();
		if (!contactMap.containsKey(contact.getPhoneNumber())) {
			return null;
		}
		contact.setId(contactMap.get(contact.getPhoneNumber()).getId());
		contactMap.put(contact.getPhoneNumber(), contact);
		return contact;
	}

	public Contact removeContact(String userName, String phoneNumber) {
		Map<String, Contact> contactMap = users.get(userName).getContacts();
		return contactMap.remove(phoneNumber);
	}
}