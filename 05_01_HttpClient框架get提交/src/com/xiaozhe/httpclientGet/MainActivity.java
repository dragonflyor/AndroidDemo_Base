package com.xiaozhe.httpclientGet;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.xioazhe.xmlreader.utils.Utils;

public class MainActivity extends Activity {
	

	
	final String path = "http://172.26.164.3:8080/androidlogin/servlet/LoginServlet";

	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			String text = (String) msg.obj;
			
			//土司显示
			Toast.makeText(MainActivity.this, text, 0).show();
		};
	};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

    }
    
    public void onclickget(View v){
    	EditText et_name = (EditText) findViewById(R.id.et_name);
    	EditText et_pass = (EditText) findViewById(R.id.et_pass);
    	
    	final String name = et_name.getText().toString();
    	final String pass = et_pass.getText().toString();

    	
    	
    	Thread thread = new Thread(){
    		@Override
    		public void run() {
    			//访问地址
    			String getpath;
    			try {
    				getpath = path+"?name="+URLEncoder.encode(name, "utf-8") +"&pass="+pass;
    				System.out.println("getpath:"+getpath);
    		    	
    				//1 httpClient对象
    		    	HttpClient hc = new DefaultHttpClient();
    		    	//2 GET请求对象
    		    	HttpGet hg = new HttpGet(getpath);
    		    	//3 使用客户单发出请求
    		    	HttpResponse hr = hc.execute(hg);
    		    	StatusLine sl = hr.getStatusLine();
    		    	
    		    	if(sl.getStatusCode()==200){
    		    		HttpEntity he = hr.getEntity();
    		    		
    		    		InputStream is = he.getContent();
    		    		String text = Utils.inputStreamToText(is);
    		    		
    		    		//发送消息给UI线程进行显示
    		    		Message msg = handler.obtainMessage();
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
    
    public void onclickpost(View v){
    	EditText et_name = (EditText) findViewById(R.id.et_name);
    	EditText et_pass = (EditText) findViewById(R.id.et_pass);
    	
    	final String name = et_name.getText().toString();
    	final String pass = et_pass.getText().toString();
    	
    	Thread thread  =  new Thread(){
    		@Override
    		public void run() {
    			//1 获取HttpClient对象
    	    	HttpClient hc = new DefaultHttpClient();
    	    	//2 post
    	    	HttpPost hp = new HttpPost(path);
    	    	//3 设置请求实体
    	    	List<BasicNameValuePair> parameters  =new ArrayList<BasicNameValuePair>();
    	    	BasicNameValuePair bnvp = new BasicNameValuePair("name", name);
    	    	BasicNameValuePair bnvp1 = new BasicNameValuePair("pass", pass);
    	    	parameters.add(bnvp);
    	    	parameters.add(bnvp1);
    	    	
    	    	HttpEntity entity;
    			try {
    				entity = new UrlEncodedFormEntity(parameters,"utf-8");
    				hp.setEntity(entity);
    				
    				HttpResponse hr = hc.execute(hp);
    				
    				if(hr.getStatusLine().getStatusCode()==200){
    					InputStream is = hr.getEntity().getContent();
    					String text = Utils.inputStreamToText(is);
    
    					System.out.println("text");
    		    		
    		    		//发送消息给UI线程进行显示
    		    		Message msg = handler.obtainMessage();
    		    		msg.obj="post请求的返回:"+text;
    		    		System.out.println("post请求的返回:"+text);
    		    		handler.sendMessage(msg);
    				}
    				
    				//链接 并且获取 响应
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	    	
    		}
    	};
    	
    	thread.start();
    
    	
    }



}
