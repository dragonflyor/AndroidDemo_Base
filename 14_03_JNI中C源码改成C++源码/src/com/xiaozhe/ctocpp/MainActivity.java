package com.xiaozhe.ctocpp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	static {
		System.loadLibrary("hello");
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

    }
    
    public void onclick(View v){
    	System.out.println("°´¼üÏìÓ¦");
    	Toast.makeText(this, hello(), 0).show();
    }


    public native String hello();
}
