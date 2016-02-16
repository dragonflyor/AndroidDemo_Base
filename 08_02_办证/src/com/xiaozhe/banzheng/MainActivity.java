package com.xiaozhe.banzheng;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity {

	MyServiceConnection connection =null;
	Intent intent =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
    	intent = new Intent(this, BanZhengService.class);
    	connection = new MyServiceConnection();
    }
    
    public void onclick(View v){
    
    	
    	bindService(intent,connection, BIND_AUTO_CREATE);
    }
    
    class MyServiceConnection implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			System.out.println("°ó¶¨³É¹¦");
			PublicBussiness bussiness = (PublicBussiness) service;
			bussiness.QianXain();
			
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
    	
    }


}
