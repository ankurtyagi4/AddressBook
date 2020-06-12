package com.example.android.addressbook.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.addressbook.R;
import com.example.android.addressbook.contact.ContactsAdapter;

public class HomeFragment
		extends Fragment {

	private ContactsModel contactsModel;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		//View view = super.onCreateView(inflater, container, savedInstanceState);
		contactsModel = ViewModelProviders.of(this).get(ContactsModel.class);

		View view = inflater.inflate(R.layout.fragment_home, container, false);
		RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_contacts);

		ContactsAdapter contactsAdapter = new ContactsAdapter(contactsModel.getStarredContacts(getContext().getContentResolver()));
		recyclerView.setAdapter(contactsAdapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

		return view;
	}

}
