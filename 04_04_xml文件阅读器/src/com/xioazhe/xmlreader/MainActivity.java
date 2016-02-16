package com.xioazhe.xmlreader;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.xioazhe.xmlreader.utils.Utils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			String text = (String)msg.obj;
			
			TextView tv = (TextView) findViewById(R.id.tv);
			tv.setText(text);
		}
	};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

      
    }

    public void onclick(View v){
    	
    	Thread thread = new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				
			   	String path = "http://172.26.164.3:8080/baidu.htm";
		    	
		    	try {
					URL url = new URL(path);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					//设置conn
					conn.setRequestMethod("GET");
					conn.setConnectTimeout(5000);
					conn.setReadTimeout(5000);
					
					//
					if(conn.getResponseCode()==200){
						//返回成功
						InputStream is = conn.getInputStream();
						String text = Utils.inputStreamToText(is);
						
						Message msg = new Message();
						msg.obj=text;
						handler.sendMessage(msg);
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
    		
    	};
    	
    	thread.start();
    	
 
    	
    	
    }

}
