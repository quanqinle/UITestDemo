package com.netease.qa.orangedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class BarActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bar);

		Spinner sp = (Spinner) findViewById(R.id.spinner1);
		String[] spinnerList = new String[] { "one", "two", "three" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, spinnerList);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// 设置下拉菜单的风格
		sp.setAdapter(adapter);
		// 绑定适配器
		sp.setPrompt("选项");
		sp.setSelection(0, true);

		sp.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				String str = arg0.getItemAtPosition(arg2).toString();
				Toast.makeText(BarActivity.this, "click " + str,
						Toast.LENGTH_LONG).show();
			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
	}
}
