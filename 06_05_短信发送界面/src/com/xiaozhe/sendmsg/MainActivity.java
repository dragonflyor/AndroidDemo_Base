package com.xiaozhe.sendmsg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

    }
    
    public void onselectphone(View v){
    	Intent intent = new Intent(this, PhoneListActivety.class);
    	
    	startActivityForResult(intent, 1);
    }
    
    
    public void onselectmsg(View v){
    	Intent intent = new Intent(this, MsgListActivity.class);
    	
    	startActivityForResult(intent, 2);
    }

    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(requestCode, resultCode, data);
    	if(requestCode == 1){
    		String phone = data.getStringExtra("name");
    		
    		EditText ev_ph = (EditText) findViewById(R.id.ev_ph);
    		ev_ph.setText(phone);
    	}else if(requestCode==2){
    		String msg = data.getStringExtra("msg");
    		
    		EditText ev_ph = (EditText) findViewById(R.id.ev_body);
    		ev_ph.setText(msg);
    	}
    }

 
}
