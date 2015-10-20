package com.netease.qa.orangedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditTextActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edittext);

		OnLongClickListener listener = new OnLongClickListener() {

			public boolean onLongClick(View v) {
				Toast.makeText(EditTextActivity.this,
						"click long on " + ((TextView) v).getText().toString(),
						Toast.LENGTH_LONG).show();
				return false;
			}
		};
		EditText edtText = (EditText) findViewById(R.id.edittext1);
		TextView txtView = (TextView) findViewById(R.id.edit_textview);
		txtView.setOnLongClickListener(listener);
	}
}
