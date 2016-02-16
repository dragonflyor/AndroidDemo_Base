package com.xiaozhe.smsprovent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;

/**
 * ���裺
 *		1. ������������
 *		2. ���嵥�ļ���ָ������������Ҫ���յ�action
 *		3. �����ҪȨ���������ӦȨ��
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
			
			System.out.println("���룺"+sms.getOriginatingAddress());
			System.out.println("���ݣ�"+sms.getMessageBody());
		}

	}

}
