package com.xiaozhe.servicestartupmethod;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity {

	Intent intent = null;
	MyServiceConnection myServiceConnection = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        intent = new Intent(this, MyService.class);
        myServiceConnection = new MyServiceConnection();
    }
    
    public void onstart(View v){
    	startService(intent);
    }
    
    public void onstop(View v){
    	stopService(intent);
    }
    
    public void onbind(View v){
    	bindService(intent,myServiceConnection, BIND_AUTO_CREATE );
    }
    
    public void onunbind(View v){
    	unbindService(myServiceConnection);
    }
    
    class MyServiceConnection implements  ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
