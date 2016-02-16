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
		
		//判断是哪个广播动作
		if(action.equals("android.intent.action.MEDIA_MOUNTED")){
			//被挂载
			Toast.makeText(context, "SD被挂载^^", 0).show();
		}else if(action.equals("android.intent.action.MEDIA_UNMOUNTED")){
			//被卸载
			Toast.makeText(context, "SD被卸载><", 0).show();
		}else if(action.equals("android.intent.action.MEDIA_REMOVED")){
			//被移除
			Toast.makeText(context, "SD被移除...", 0).show();
		}

	}

}
