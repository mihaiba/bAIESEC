package com.levi9.rest.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.levi9.rest.memoryDB.Database;
import com.levi9.rest.models.Contact;
import com.levi9.rest.resources.filterbeans.ContactsFilterBean;

public class ContactService {

	private static Map<String, Long> contactIdsByUser = new HashMap<>();

	private Map<String, Map<Long, Contact>> contacts = Database.getContacts();

	public Contact add(String userName, Contact contact) {
		Map<Long, Contact> currentUserContacts = contacts.get(userName);
		long currentContactId = 0;
		if (contactIdsByUser.containsKey(userName)) {
			currentContactId = contactIdsByUser.get(userName);
		} else {
			currentContactId = contactIdsByUser.size();
		}
		contactIdsByUser.put(userName, ++currentContactId);
		contact.setId(currentContactId);
		currentUserContacts.put(contact.getId(), contact);
		return contact;
	}

	public List<Contact> getAll(String userName, ContactsFilterBean filter) {
		Map<Long, Contact> contactMap = contacts.get(userName);
		if (filter.getName() != null && !filter.getName().isEmpty()) {
			return getContactsByName(filter.getName(), contactMap);
		}
		if (filter.getPhoneNumber() != null && !filter.getPhoneNumber().isEmpty()) {
			return getContactsByPhoneNumber(filter.getPhoneNumber(), contactMap);
		}
		return new ArrayList<>(contactMap.values());
	}

	public Contact get(String userName, Long contactId) {
		return contacts.get(userName).get(contactId);
	}

	private List<Contact> getContactsByName(String name, Map<Long, Contact> contactMap) {
		List<Contact> filteredContacts = new ArrayList<>();
		for (Contact contact : contactMap.values()) {
			if (contact.getFirstName().toUpperCase().contains(name.toUpperCase())
					|| contact.getLastName().toUpperCase().contains(name.toUpperCase())) {
				filteredContacts.add(contact);
			}
		}
		return filteredContacts;
	}

	private List<Contact> getContactsByPhoneNumber(String phoneNumber, Map<Long, Contact> contactMap) {
		List<Contact> filteredContacts = new ArrayList<>();
		for (Contact contact : contactMap.values()) {
			if (contact.getPhoneNumber().contains(phoneNumber)) {
				filteredContacts.add(contact);
			}
		}
		return filteredContacts;
	}

	public Contact update(String userName, Contact contact) {
		Map<Long, Contact> contactMap = contacts.get(userName);
		if (!contactMap.containsKey(contact.getId())) {
			return null;
		}
		contactMap.put(contact.getId(), contact);
		return contact;
	}

	public Contact removeContact(String userName, Long contactId) {
		return contacts.get(userName).remove(contactId);
	}
}