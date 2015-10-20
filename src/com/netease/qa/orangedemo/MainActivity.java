package com.netease.qa.orangedemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, Menu.FIRST, 0, "退出").setIcon(
				android.R.drawable.ic_menu_delete);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getOrder()) {
		case 0:
			showDialog(0);
			break;
		}
		return false;
	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case 0:
			return new AlertDialog.Builder(this)
					.setTitle("确定退出程序")
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface dialog,
										int which) {
									finish();
									System.exit(0);
								}
							}).setNegativeButton("取消", null).create();
		default:
			return null;
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ListView listview = new ListView(this);
		String[] itemList = { "ViewTest", "ButtonTest", "EditTextTest",
				"BarTest", "ListViewTest", "PickerTest" };
		listview.setAdapter(new CustomizedAdapter(this, R.layout.activity_main,
				itemList));
		setContentView(listview);
	}

	private class CustomizedAdapter extends ArrayAdapter<String> {

		private String[] testItem;
		private int resourceId;

		public CustomizedAdapter(Context context, int textViewResourceId,
				String[] objects) {
			super(context, textViewResourceId, objects);
			this.testItem = objects;
			this.resourceId = textViewResourceId;
		}

		@Override
		public int getCount() {
			return testItem.length;
		}

		@Override
		public String getItem(int position) {
			return testItem[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			final int i = position;
			LinearLayout userListItem = new LinearLayout(getContext());
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater vi = (LayoutInflater) getContext().getSystemService(
					inflater);
			vi.inflate(resourceId, userListItem, true);
			TextView txtItem = (TextView) userListItem
					.findViewById(R.id.test_item);
			txtItem.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent intent = new Intent();
					switch (i) {
					case 0:
						intent.setClass(MainActivity.this, ViewActivity.class);
						startActivityForResult(intent,
								Activity.RESULT_FIRST_USER);
						break;
					case 1:
						intent.setClass(MainActivity.this, ButtonActivity.class);
						startActivityForResult(intent,
								Activity.RESULT_FIRST_USER);
						break;
					case 2:
						intent.setClass(MainActivity.this,
								EditTextActivity.class);
						startActivityForResult(intent,
								Activity.RESULT_FIRST_USER);
						break;
					case 3:
						intent.setClass(MainActivity.this, BarActivity.class);
						startActivityForResult(intent,
								Activity.RESULT_FIRST_USER);
						break;
					case 4:
						intent.setClass(MainActivity.this, ListActivity.class);
						startActivityForResult(intent,
								Activity.RESULT_FIRST_USER);
						break;
					case 5:
						intent.setClass(MainActivity.this, PickerActivity.class);
						startActivityForResult(intent,
								Activity.RESULT_FIRST_USER);
						break;

					}
				}
			});
			txtItem.setText(testItem[position]);
			return userListItem;
		}
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.main, menu);
	// return true;
	// }
}
