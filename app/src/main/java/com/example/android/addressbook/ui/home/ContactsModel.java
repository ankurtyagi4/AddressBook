package com.example.android.addressbook.ui.home;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.addressbook.contact.Contact;

import java.util.ArrayList;
import java.util.Collections;

public class ContactsModel extends ViewModel {

	private MutableLiveData<String> mText;
	private static ArrayList<Contact> contacts;

	static {
		contacts = Contact.createContactsList(20);
	}

	public ContactsModel() {
		mText = new MutableLiveData<>();
		mText.setValue("This is home fragment");
	}

	public LiveData<String> getText() {
		return mText;
	}

	public ArrayList getAllContacts(ContentResolver contentResolver) {
		return getContacts(contentResolver, ContactsContract.Contacts.CONTENT_URI);
	}

	public ArrayList getStarredContacts(ContentResolver contentResolver) {
		return getContacts(contentResolver, ContactsContract.Contacts.CONTENT_STREQUENT_URI);
	}

	private ArrayList getContacts(ContentResolver contentResolver, Uri uri) {
		ArrayList<Contact> contacts = new ArrayList<>();
		Cursor cur = contentResolver.query(uri, null, null, null, null);
		if ((cur != null ? cur.getCount() : 0) > 0) {
			while (cur != null && cur.moveToNext()) {
				Contact contact = new Contact();
				String id = cur.getString(cur.getColumnIndex(ContactsContract.Contacts._ID));
				contact.setId(contacts.size() + 1);
				String name = cur.getString(cur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
				contact.setName(name);
				if (cur.getInt(cur.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
					Cursor pCur = contentResolver.query(
							ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
							null,
							ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
							new String[]{id}, null);
					while (pCur.moveToNext()) {
						String phoneNo = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
						contact.setNumbers(phoneNo);
					}
					pCur.close();
				} else {
					contact.setNumbers("0");
				}
				contacts.add(contact);
			}
		}
		if (cur != null) {
			cur.close();
		}

		Collections.sort(contacts, (c1, c2) -> {
			return c1.getName().compareToIgnoreCase(c2.getName());
		});
		return contacts;
	}

}