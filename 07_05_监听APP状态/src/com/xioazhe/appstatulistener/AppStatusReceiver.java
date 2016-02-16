package com.xioazhe.appstatulistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class AppStatusReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		Uri uri = intent.getData();
		
		if(action.equals("android.intent.action.PACKAGE_ADDED")){
			Toast.makeText(context, uri.toString()+"����װ��", 0).show();
		}
		if(action.equals("android.intent.action.PACKAGE_REMOVED")){
			Toast.makeText(context, uri.toString()+"��ж������", 0).show();
		}
		if(action.equals("android.intent.action.PACKAGE_REPLACED")){
			Toast.makeText(context, uri.toString()+"��������", 0).show();
		}
		

	}

}
