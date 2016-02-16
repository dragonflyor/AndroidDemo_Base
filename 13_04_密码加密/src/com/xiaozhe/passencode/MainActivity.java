package com.xiaozhe.passencode;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	static {
		System.loadLibrary("encode");
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

    }

    public void onclick(View v){
    	EditText et = (EditText) findViewById(R.id.pswd);
    	int pass = Integer.parseInt(et.getText().toString());
    	
    	//System.out.println("加密后的密码是："+pass+2);
    	
    	System.out.println("加密后的密码是："+(passencode(pass)));
    }
    
    public native int passencode(int pass);
   
}
