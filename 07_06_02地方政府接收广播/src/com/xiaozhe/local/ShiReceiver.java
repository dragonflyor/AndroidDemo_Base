package com.xiaozhe.local;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ShiReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		String text = getResultData();
		Log.i("local","�������յ��㲥:"+text);
		Toast.makeText(context, "�������յ��㲥:"+text, 0).show();
		
		abortBroadcast();

	}

}
