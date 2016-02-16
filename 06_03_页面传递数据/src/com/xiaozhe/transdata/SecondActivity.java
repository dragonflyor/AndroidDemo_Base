package com.xiaozhe.transdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_main);
		
		Intent intent = getIntent();
		
		String text = intent.getData().toString();
		
		TextView tv = (TextView) findViewById(R.id.tv);
		tv.setText(text);
	}

}
