package com.xiaozhe.coderegistereceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		//System.out.println("收到广播："+action);
		
		if("android.intent.action.SCREEN_ON".equals(action)){
			System.out.println("屏幕打开");
		}else if("android.intent.action.SCREEN_OFF".equals(action)){
			System.out.println("关闭了屏幕");
		}

	}

}
