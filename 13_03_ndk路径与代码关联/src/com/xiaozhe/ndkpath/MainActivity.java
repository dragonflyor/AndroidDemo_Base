package com.xiaozhe.ndkpath;

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
    	Toast.makeText(MainActivity.this, helloC(), 0).show();
    }
    
    public native String helloC();


}
