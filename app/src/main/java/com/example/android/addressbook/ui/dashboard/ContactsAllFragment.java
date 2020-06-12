package com.example.android.addressbook.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.addressbook.R;
import com.example.android.addressbook.contact.ContactsAdapter;
import com.example.android.addressbook.ui.home.ContactsModel;

public class ContactsAllFragment extends Fragment {

	private ContactsModel contactsModel;

	public View onCreateView(@NonNull LayoutInflater inflater,
	                         ViewGroup container, Bundle savedInstanceState) {
		contactsModel = ViewModelProviders.of(this).get(ContactsModel.class);

		View view = inflater.inflate(R.layout.fragment_contacts_all, container, false);
		RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_contacts);

		ContactsAdapter contactsAdapter = new ContactsAdapter(contactsModel.getAllContacts(getContext().getContentResolver()));
		recyclerView.setAdapter(contactsAdapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

		return view;
	}
}
