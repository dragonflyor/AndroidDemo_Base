package com.xiaozhe.local;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class XianReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		String text = getResultData();
		Log.i("local","县政府收到广播:"+text);
		Toast.makeText(context, "县政府收到广播:"+text, 0).show();

	}

}
