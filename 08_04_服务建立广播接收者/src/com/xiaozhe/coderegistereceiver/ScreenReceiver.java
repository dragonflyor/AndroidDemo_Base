package com.xiaozhe.coderegistereceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		//System.out.println("�յ��㲥��"+action);
		
		if("android.intent.action.SCREEN_ON".equals(action)){
			System.out.println("��Ļ��");
		}else if("android.intent.action.SCREEN_OFF".equals(action)){
			System.out.println("�ر�����Ļ");
		}

	}

}
