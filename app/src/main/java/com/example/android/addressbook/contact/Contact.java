package com.example.android.addressbook.contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contact {
	public Integer id;
	public String name;
	public List<String> numbers = new ArrayList<String>(2);//TODO only 2 numbers??
	public String notes;

	private static int lastContactId = 0;

	public Contact() {}

	public Contact(Integer id, String name, String number, String notes) {
		List<String> contacts = new ArrayList<>();
		contacts.add(number);
		new Contact(id, name, contacts, notes);
	}
	public Contact(Integer id, String name, List<String> numbers, String notes) {
		this.id = id;
		this.name = name;
		this.numbers.addAll(numbers);
		this.notes = notes;
	}

	public static ArrayList<Contact> createContactsList(int numContacts) {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		for (int i = 1; i <= numContacts; i++) {
			++lastContactId;
			contacts.add(new Contact(
					lastContactId,
					"Person " + lastContactId,
					String.valueOf(999999000 + lastContactId),
					"Notes for Person " + lastContactId));
		}

		return contacts;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<String> getNumbers() {
		return numbers;
	}
	public void setNumbers(String number) {
		this.numbers.add(number);
	}
	public void setNumbers(List<String> numbers) {
		this.numbers.addAll(numbers);
	}

	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Contact{" +
				"id=" + id +
				", name='" + name + '\'' +
				", primaryNumber='" + numbers + '\'' +
				", notes='" + notes + '\'' +
				'}';
	}
}
