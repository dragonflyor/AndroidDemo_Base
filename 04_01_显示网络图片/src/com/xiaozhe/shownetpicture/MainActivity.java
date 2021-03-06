package com.xiaozhe.shownetpicture;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	static ImageView iv=null;
	static MainActivity ma =null;
	
	static Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			
			switch(msg.what){
			case 1:
				//显示到控件
				Bitmap bm = (Bitmap) msg.obj;
				iv.setImageBitmap(bm);
				break;
				
			case 0:
				Toast.makeText(ma, "加载失败", 0).show();
				break;
			}
		}
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        iv = (ImageView) findViewById(R.id.iv);
        ma=MainActivity.this;
        
    }
    
    public void onclick(View v){
    	Thread th  = new Thread(){
    		@Override
    		public void run() {
    			// TODO Auto-generated method stub
    			super.run();
    			
    			//1 获取地址
    	    	//String path = "http://172.26.164.3:8080/p1.jpg";
    			String path = "http://e.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=12df18af3987e950561afb3e71513826/738b4710b912c8fc6711e1a1ff039245d78821ff.jpg";
    	    	try {
    				URL url = new URL(path);
    				
    				//2 建立连接
    				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    				
    				//3 连接初始化
    				conn.setRequestMethod("GET");
    				conn.setConnectTimeout(5000);
    				conn.setReadTimeout(3000);
    				
    				//4 发送请求
    				conn.connect();
    				
    				//5 根据请求结果 分别处理
    				if(conn.getResponseCode()==200){
    					//请求成功
    					//获取数据流，封装成位图
    					InputStream is = conn.getInputStream();
    					
    					
    					
    					
    					
    					
    					Bitmap bm = BitmapFactory.decodeStream(is);
    					
    					Message msg = handler.obtainMessage();
    					
    					msg.obj = bm;
    					msg.what = 1;
    					
    					handler.sendMessage(msg);
    					
//    					//显示到控件
//    					ImageView iv = (ImageView) findViewById(R.id.iv);
//    					iv.setImageBitmap(bm);
    				}else{
    					
//    					Toast.makeText(MainActivity.this, "加载失败", 0).show();
    					
    					Message msg = handler.obtainMessage();
    					msg.what = 0;
    					handler.sendMessage(msg);
    				}
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    		}
    	};
    	
    	th.start();
    	
    }


   
}
