package com.xiaozhe.getlogin;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.xiaozhe.postlogin.R;
import com.xioazhe.xmlreader.utils.Utils;

public class MainActivity extends Activity {

	Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			
			String text = (String) msg.obj;
			
			Toast.makeText(MainActivity.this, text, 0).show();
		}
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

       
    }
    
    public void onclick(View v){
    	final String path = "http://172.26.164.3:8080/androidlogin/servlet/LoginServlet";
    	
    	Thread   thread  =new Thread(){
    		@Override
    		public void run() {
    			EditText  et_name = (EditText) findViewById(R.id.et_name);
    	    	EditText  et_pass = (EditText) findViewById(R.id.et_pass);
    	    	
    	    	String name = et_name.getText().toString();
    	    	String pass = et_pass.getText().toString();
    	    	try {
    	    		String newpath= path+"?name="+URLEncoder.encode(name, "utf-8") +"&pass="+pass;
    	    		System.out.println("newpath:"+newpath);
    	    		//1 get url
    				URL url = new URL(newpath);
    				
    				//2 get connection 
    				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    				
    				//3 setting
    				conn.setConnectTimeout(5000);
    				conn.setReadTimeout(5000);
    				conn.setRequestMethod("POST");
    				
    				String data = "name="+URLEncoder.encode(name, "utf-8")+"pass="+pass;
    				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencode");
    				conn.setRequestProperty("Content-Length", data.getBytes().length+"");
    				conn.setDoOutput(true);
    				OutputStream os=conn.getOutputStream();
    				os.write(data.getBytes());
    				
    				//4 start connect and get responsecode
    				if(conn.getResponseCode()==200){
    					//get inputstream 
    					InputStream  is = conn.getInputStream();
    					
    					String text = Utils.inputStreamToText(is);
    					
    					
    					Message msg = handler.obtainMessage();
    					msg.obj = text;
    					handler.sendMessage(msg);
    					
    				}else{
    					
    				}
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    	    	
    		}
    	};
    	
    	thread.start();
    	
    
    	
    }


}
