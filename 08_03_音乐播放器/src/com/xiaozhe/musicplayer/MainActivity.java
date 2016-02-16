package com.xiaozhe.musicplayer;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity {

	MusicInterface musicplayer=null;
	MyServiceConnection conn = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        Intent intent = new Intent(MainActivity.this, MusicService.class);
        
        //�������
        //start��������֤service��̨���� 
        startService(intent);
        //bind���� ��ͨ����ȡservice�ķ���
        conn = new MyServiceConnection();
        bindService(intent, conn, BIND_AUTO_CREATE);
     
    }
    
    class  MyServiceConnection implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			musicplayer = (MusicInterface) service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
    	
    }
    
    
    
    
    public void onplay(View v){
    	//����
    	musicplayer.play();
    }
    public void onpause(View v){
    	//��ͣ
    	musicplayer.pause();
    }


  
}
