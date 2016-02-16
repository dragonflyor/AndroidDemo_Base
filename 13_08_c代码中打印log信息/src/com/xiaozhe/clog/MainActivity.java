package com.xiaozhe.clog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	static{
		System.loadLibrary("logout");
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
    }
    
    public void onclick(View v){
    	logout();
    }
    
    public native void logout();


}
