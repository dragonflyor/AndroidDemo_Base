package com.xiaozhe.ipdialer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

public class CallerReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.i("07_01","À´µç»°À²");
		
		String num = getResultData();
		
		SharedPreferences sharedPreferences = context.getSharedPreferences("ip.sp",Context.MODE_PRIVATE);
		String ip=sharedPreferences.getString("ip", "");
		
		setResultData(ip+num);
		

	}

}
