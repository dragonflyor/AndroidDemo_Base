package com.xiaozhe.msg;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //响应短信发送按钮
    public void onSend(View v){
    	System.out.println("发送");
    	EditText et_phone = (EditText)findViewById(R.id.et_phone);
    	EditText et_content = (EditText) findViewById(R.id.et_content);
    	
    	String phone = et_phone.getText().toString();
    	String content = et_content.getText().toString();
    	
    	SmsManager sm = SmsManager.getDefault();
    	
    	ArrayList<String> list = sm.divideMessage(content);
    	
    	for (String ct : list) {
   		System.out.println("短信内容:"+ct);
    		sm.sendTextMessage(phone, null, ct, null, null); 
        	
		}
    	
    }
}
