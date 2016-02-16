package com.xiaozhe.central;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
    }

    public void onclick(View v){
    	Intent intent = new Intent();
    	
    	intent.setAction("com.xiaozhe.DZY");
    	
    	//sendBroadcast(intent);
    	sendOrderedBroadcast(intent, null, new MyReceiver(), null, 0, "发放大米100公斤", null);
    }

    
    class MyReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			String text = getResultData();
			Log.i("local","纪检:"+text);
			Toast.makeText(context, "纪检:"+text, 0).show();
		}
    	
    }

}
