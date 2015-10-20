package com.netease.qa.orangedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button);
		Button btnButton = (Button) findViewById(R.id.button1);
		btnButton.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Toast.makeText(ButtonActivity.this, "³É¹¦µã»÷Button1",
						Toast.LENGTH_LONG).show();
			}
		});

	}
}
