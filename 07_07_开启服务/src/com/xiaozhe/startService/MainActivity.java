package com.xiaozhe.startService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);


    }
    
    public void onclick(View v){
    	Intent intent = new Intent(this, MYService.class);
    	
    	startService(intent);
    	
    }
    public void onclick1(View v){
    	Intent intent = new Intent(this, MYService.class);
    	
    	stopService(intent);
    	
    }
    
    


   
}
