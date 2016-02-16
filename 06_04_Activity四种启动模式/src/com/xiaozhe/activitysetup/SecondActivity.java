package com.xiaozhe.activitysetup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.second_main);
	}
	
	 public void onclick(View v){
	    	Intent intent = new Intent();
	    	intent.setClass(this, MainActivity.class);
	    	startActivity(intent);
	    }
	    public void onclick1(View v){
	    	Intent intent = new Intent();
	    	intent.setClass(this, SecondActivity.class);
	    	startActivity(intent);
	    }

}
