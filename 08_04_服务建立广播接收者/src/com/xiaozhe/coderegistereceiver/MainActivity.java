package com.xiaozhe.coderegistereceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	
    private Intent intent;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        intent = new Intent(this, ScreenOnOffService.class);
    }
    
    
    public void onopen(View v){
    	
    	
    	startService(intent);
    }
    
    public void onclose(View v){
    	//¹Ø±Õ·þÎñ
    	
    	stopService(intent);
    }


}
