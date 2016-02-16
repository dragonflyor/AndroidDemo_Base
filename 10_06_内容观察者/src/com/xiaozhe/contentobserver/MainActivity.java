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
        
        
        //�ڶ������� true:��ʾƥ��content://sms��ͷ���ַ���; false:��ʾ��ȫƥ��
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
			System.out.println("�������ݿ����ݷ����仯");
			Toast.makeText(MainActivity.this, "�������ݿ����ݷ����仯", 0).show();
		}
		
		
    	
    }



}
