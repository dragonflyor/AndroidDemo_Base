package com.xiaozhe.openremote;

import com.xiaozhe.remoteservice.PublicBusiness;
import com.xiaozhe.remoteservice.PublicBusiness.Stub;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;

public class MainActivity extends Activity {

	
    private Intent intent;
    MyServiceConnenction conn = null;
    
    private PublicBusiness pb;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
    	intent = new Intent();
    	intent.setAction("com.xioazhe.romoteservice");
    	conn = new MyServiceConnenction();

      
    }
    
    public void onclick1(View v){

    	startService(intent);
    }
    public void onclick2(View v){
    	//停止
    	stopService(intent);
    }
    public void onclick3(View v){
    	//绑定 
    	bindService(intent, conn, BIND_AUTO_CREATE);
    }
    public void onclick4(View v){
    	//解绑
    	unbindService(conn);
    }
    
    
    public void onclick5(View v){
    	//办证
    	try {
			pb.QianXian();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    class MyServiceConnenction implements ServiceConnection{

		

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			System.out.print("绑定成功");
			pb = Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
    	
    }
   


 
}
