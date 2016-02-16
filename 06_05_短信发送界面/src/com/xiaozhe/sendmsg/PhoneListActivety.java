package com.xiaozhe.sendmsg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PhoneListActivety extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.phonenum_main);
		
		ListView lv_phone = (ListView) findViewById(R.id.lv_phone);
		
		final String[] objects = new String[]{"小明","项王","艾丝凡","法官"};
		lv_phone.setAdapter(new ArrayAdapter<String>(this, R.layout.item_list, R.id.item, objects));
		
		lv_phone.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent data = new Intent();
				data.putExtra("name", objects[position]);
				
				setResult(11, data);
				finish();
			}
		});
		
	}

}
