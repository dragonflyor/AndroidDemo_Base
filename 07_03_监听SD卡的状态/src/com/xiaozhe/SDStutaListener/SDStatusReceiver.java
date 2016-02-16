package com.xiaozhe.SDStutaListener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SDStatusReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action  = intent.getAction();
		
		//�ж����ĸ��㲥����
		if(action.equals("android.intent.action.MEDIA_MOUNTED")){
			//������
			Toast.makeText(context, "SD������^^", 0).show();
		}else if(action.equals("android.intent.action.MEDIA_UNMOUNTED")){
			//��ж��
			Toast.makeText(context, "SD��ж��><", 0).show();
		}else if(action.equals("android.intent.action.MEDIA_REMOVED")){
			//���Ƴ�
			Toast.makeText(context, "SD���Ƴ�...", 0).show();
		}

	}

}
