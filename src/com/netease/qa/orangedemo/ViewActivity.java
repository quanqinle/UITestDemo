package com.netease.qa.orangedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_common_view);
		OnClickListener listener = new OnClickListener() {

			public void onClick(View v) {
				Toast.makeText(ViewActivity.this,
						"click " + v.getClass().getSimpleName(),
						Toast.LENGTH_LONG).show();

			}
		};

		OnLongClickListener LongClicklistener = new OnLongClickListener() {

			public boolean onLongClick(View v) {
				Toast.makeText(ViewActivity.this,
						"click long on " + v.getClass().getSimpleName(),
						Toast.LENGTH_LONG).show();
				return true;
			}
		};
		TextView txtView = (TextView) findViewById(R.id.textView1);
		txtView.setOnClickListener(listener);
		txtView.setOnLongClickListener(LongClicklistener);
		ImageView imgView = (ImageView) findViewById(R.id.imageView1);
		imgView.setOnClickListener(listener);
		imgView.setOnLongClickListener(LongClicklistener);
		Button btnButton = (Button) findViewById(R.id.buttonView1);
		btnButton.setOnClickListener(listener);
		btnButton.setOnLongClickListener(LongClicklistener);
		ImageButton imgButton = (ImageButton) findViewById(R.id.imageButton1);
		imgButton.setOnClickListener(listener);
	}
}
