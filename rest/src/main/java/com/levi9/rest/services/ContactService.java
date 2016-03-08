package com.levi9.rest.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.levi9.rest.memoryDB.Database;
import com.levi9.rest.models.Contact;
import com.levi9.rest.resources.filterbeans.ContactsFilterBean;

public class ContactService {

	private static Map<Long, Long> contactIdsByUser = new HashMap<>();

	private Map<Long, Map<Long, Contact>> contacts = Database.getContacts();

	public Contact add(Long userId, Contact contact) {
		Map<Long, Contact> currentUserContacts = contacts.get(userId);
		long currentContactId = 0;
		if (contactIdsByUser.containsKey(userId)) {
			currentContactId = contactIdsByUser.get(userId);
		}
		contactIdsByUser.put(userId, ++currentContactId);
		contact.setId(currentContactId);
		currentUserContacts.put(contact.getId(), contact);
		return contact;
	}

	public List<Contact> getAll(Long userId, ContactsFilterBean filter) {
		Map<Long, Contact> contactMap = contacts.get(userId);
		if (filter.getName() != null && !filter.getName().isEmpty()) {
			return getContactsByName(filter.getName(), contactMap);
		}
		if (filter.getPhoneNumber() != null && !filter.getPhoneNumber().isEmpty()) {
			return getContactsByPhoneNumber(filter.getPhoneNumber(), contactMap);
		}
		return new ArrayList<>(contactMap.values());
	}

	public Contact get(Long userId, Long contactId) {
		return contacts.get(userId).get(contactId);
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

	public Contact update(Long userId, Contact contact) {
		Map<Long, Contact> contactMap = contacts.get(userId);
		if (!contactMap.containsKey(contact.getId())) {
			return null;
		}
		contactMap.put(contact.getId(), contact);
		return contact;
	}

	public Contact removeContact(Long userId, Long contactId) {
		return contacts.get(userId).remove(contactId);
	}
}