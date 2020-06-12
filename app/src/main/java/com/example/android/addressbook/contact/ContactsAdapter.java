package com.example.android.addressbook.contact;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.android.addressbook.R;

import java.util.List;
import java.util.Random;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

	private List<Contact> contacts;
	private int colorResId = R.drawable.ic_contact_head_orange;

	public ContactsAdapter(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

		//FragmentTransaction

		View view;
		switch (viewType) {
			case 0:
				view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_contact, parent, false);
				break;
			default:
				view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_contact, parent, false);
				break;
		}

		ViewHolder viewHolder = new ViewHolder(view);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(final ViewHolder viewHolder, int position) {
		Contact contact = contacts.get(position);

		viewHolder.buttonContactHead.setText(contact.getName().substring(0, 1));
		viewHolder.buttonContactHead.setBackgroundResource(getBackgroundResource());
		viewHolder.buttonContactHead.setWidth(viewHolder.buttonContactHead.getHeight());
		viewHolder.buttonContactHead.setEnabled(true);
		viewHolder.textViewName.setText(contact.getName());

		if (contact.getNumbers().size() > 1) { // TODO
			viewHolder.textViewContactNumberOne.setText(contact.getNumbers().get(0));
			viewHolder.textViewContactNumberTwo.setText(contact.getNumbers().get(1));
		} else {
			viewHolder.textViewContactNumberOne.setText(contact.getNumbers().get(0));
			viewHolder.buttonContactNoTwoMsg.setVisibility(View.INVISIBLE);
			viewHolder.buttonContactNoTwoCall.setVisibility(View.INVISIBLE);
		}
	}

	private int getBackgroundResource() {
		int lastColorResId = colorResId;
		do {
			switch (new Random().nextInt(10)) {
				case 0:
					colorResId = R.drawable.ic_contact_head_orange;
					break;
				case 1:
					colorResId = R.drawable.ic_contact_head_yellow;
					break;
				case 2:
					colorResId = R.drawable.ic_contact_head_green_dark;
					break;
				case 3:
					colorResId = R.drawable.ic_contact_head_green_light;
					break;
				case 4:
					colorResId = R.drawable.ic_contact_head_blue_dark;
					break;
				case 5:
					colorResId = R.drawable.ic_contact_head_blue_light;
					break;
				case 6:
					colorResId = R.drawable.ic_contact_head_red;
					break;
				case 7:
					colorResId = R.drawable.ic_contact_head_pink;
					break;
				case 8:
					colorResId = R.drawable.ic_contact_head_purple;
					break;
				case 9:
					colorResId = R.drawable.ic_contact_head_purple2;
					break;
				default:
					break;
			}
		} while (lastColorResId == colorResId);

		return colorResId;
	}

	@Override
	public int getItemCount() {
		return contacts.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder {
		public Button buttonContactHead;
		public TextView textViewName;
		public TextView textViewContactNumberOne;
		public ImageButton buttonContactNoOneMsg;
		public ImageButton buttonContactNoOneCall;
		public TextView textViewContactNumberTwo;
		public ImageButton buttonContactNoTwoMsg;
		public ImageButton buttonContactNoTwoCall;

		public ViewHolder(View view) {
			super(view);

			buttonContactHead = (Button) view.findViewById(R.id.button_contact_head);
			textViewName = (TextView) view.findViewById(R.id.textview_contact_name);
			textViewContactNumberOne = (TextView) view.findViewById(R.id.textview_contact_number_1);
			buttonContactNoOneMsg = (ImageButton) view.findViewById(R.id.button_message_1);
			buttonContactNoOneCall = (ImageButton) view.findViewById(R.id.button_call_1);
			textViewContactNumberTwo = (TextView) view.findViewById(R.id.textview_contact_number_2);
			buttonContactNoTwoMsg = (ImageButton) view.findViewById(R.id.button_message_2);
			buttonContactNoTwoCall = (ImageButton) view.findViewById(R.id.button_call_2);
		}

		@Override
		public String toString() {
			return "ViewHolder{" +
					"buttonContactHead=" + buttonContactHead +
					", textViewName=" + textViewName +
					", textViewContactNumberOne=" + textViewContactNumberOne +
					", textViewContactNumberTwo=" + textViewContactNumberTwo +
					'}';
		}
	}
}