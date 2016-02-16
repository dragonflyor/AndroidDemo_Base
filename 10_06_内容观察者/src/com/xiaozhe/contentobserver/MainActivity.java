package com.xiaozhe.contentobserver;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

    
        ContentResolver cr = getContentResolver();
        
        
        //第二个参数 true:表示匹配content://sms开头的字符串; false:表示完全匹配
        cr.registerContentObserver(Uri.parse("content://sms"), true, new MyContentObserver(new Handler()));

    }
    
    class MyContentObserver extends ContentObserver{

		public MyContentObserver(Handler handler) {
			super(handler);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onChange(boolean selfChange) {
			// TODO Auto-generated method stub
			super.onChange(selfChange);
			System.out.println("短信数据库数据发生变化");
			Toast.makeText(MainActivity.this, "短信数据库数据发生变化", 0).show();
		}
		
		
    	
    }



}
