package com.xiaozhe.smsprovent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;

/**
 * 步骤：
 *		1. 建立接受者类
 *		2. 在清单文件中指定接受者类所要接收的action
 *		3. 如果需要权限则给定相应权限
 * @author zhe
 *
 */
public class SmsReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		Bundle bundle = intent.getExtras();
		Object[] objects = (Object[])bundle.get("pdus");
		
		for (Object object : objects) {
			
			SmsMessage sms = SmsMessage.createFromPdu((byte[]) object);
			
			System.out.println("号码："+sms.getOriginatingAddress());
			System.out.println("内容："+sms.getMessageBody());
		}

	}

}
