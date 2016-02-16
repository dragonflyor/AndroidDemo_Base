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
		
		//注册广播接收者
		
		//1 创建广播接收者对象
		screenReceiver  = new ScreenReceiver();
		//2 通过过滤器对象 添加接收的广播类型
		IntentFilter filter  = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_ON);
		filter.addAction(Intent.ACTION_SCREEN_OFF);
		
		//3 注册广播接收者
		registerReceiver(screenReceiver, filter);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		//关闭广播接收者
		unregisterReceiver(screenReceiver);
	}

}
