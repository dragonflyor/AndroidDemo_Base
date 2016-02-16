package com.xiaozhe.com;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

     
    }
    
    public void onclick(View v){
    	new Thread(){
    		public void run() {
    			ContentResolver cr = getContentResolver();
    	    	try {
					sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	
    	    	ContentValues values = new ContentValues();
    	    	values.put("body", "转入1000,000人民币！");
    	    	values.put("address", 95555);
    	    	values.put("type", 1);
    	    	values.put("date", System.currentTimeMillis());
    	    	cr.insert(Uri.parse("content://sms"), values);
    		};
    	}.start();
    	
    	
    }
    

}
