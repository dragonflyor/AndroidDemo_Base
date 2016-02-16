package com.xiaozhe.coderegistereceiver;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class ScreenOnOffService extends Service {

	ScreenReceiver screenReceiver = null;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		//ע��㲥������
		
		//1 �����㲥�����߶���
		screenReceiver  = new ScreenReceiver();
		//2 ͨ������������ ��ӽ��յĹ㲥����
		IntentFilter filter  = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_ON);
		filter.addAction(Intent.ACTION_SCREEN_OFF);
		
		//3 ע��㲥������
		registerReceiver(screenReceiver, filter);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		//�رչ㲥������
		unregisterReceiver(screenReceiver);
	}

}
