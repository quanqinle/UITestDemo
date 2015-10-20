package com.netease.qa.orangedemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		ListView listview = (ListView) findViewById(R.id.listview);
		// ListView listview = new ListView(this);
		String[] itemList = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
				"20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
				"30" };
		listview.setAdapter(new ListAdapter(R.layout.activity_main,
				R.id.test_item, itemList));
		// TextView txtView = (TextView) findViewById(R.id.testview);
		// txtView.setOnClickListener(new OnClickListener() {
		// public void onClick(View v) {
		// Toast.makeText(ListActivity.this,
		// ((TextView) v).getText().toString(), Toast.LENGTH_LONG)
		// .show();
		// }
		// });
	}

	class ListAdapter extends BaseAdapter {

		private String[] listItem;
		private int resource;
		private int textViewResourceId;

		public ListAdapter(int resource, int textViewResourceId,
				String[] objects) {
			this.listItem = objects;
			this.resource = resource;
			this.textViewResourceId = textViewResourceId;
		}

		public long getItemId(int position) {
			return 0;
		}

		public int getCount() {
			return listItem.length;
		}

		public String getItem(int position) {
			return listItem[position];
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			convertView = ListActivity.this.getLayoutInflater().inflate(
					resource, null);
			TextView txtItem = (TextView) convertView
					.findViewById(textViewResourceId);
			txtItem.setText(listItem[position]);
			txtItem.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					Toast.makeText(ListActivity.this,
							"click on " + ((TextView) v).getText().toString(),
							Toast.LENGTH_LONG).show();
				}

			});
			txtItem.setOnLongClickListener(new OnLongClickListener() {

				public boolean onLongClick(View v) {
					Toast.makeText(
							ListActivity.this,
							"click long on "
									+ ((TextView) v).getText().toString(),
							Toast.LENGTH_LONG).show();
					return true;
				}

			});
			return convertView;
		}

	}
}
