package com.xiaozhe.sendmsg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MsgListActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.msglist_main);
		
		ListView lv_msglist = (ListView) findViewById(R.id.lv_msglist);
		final String[] objects = new String[]{"马上回去！","有事回不去了！","待会回电话你"};
		lv_msglist.setAdapter(new ArrayAdapter<String>(this, R.layout.item_list, R.id.item, objects));
		
		lv_msglist.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent data = new Intent();
				data.putExtra("msg", objects[position]);
				
				setResult(12, data);
				finish();
			}
		});
	

	}

}
