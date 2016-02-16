package com.xiaozhe.asynchttpclientget;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.Header;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class MainActivity extends Activity {

	final String path = "http://172.26.164.3:8080/androidlogin/servlet/LoginServlet";
	
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
    	
    	String getpath;

			try {
				getpath = path+"?name="+URLEncoder.encode(name, "utf-8") +"&pass="+pass;
				System.out.println("getpath:"+getpath);
				
				AsyncHttpClient ahc = new AsyncHttpClient();
				ahc.get(getpath, new AsyncHttpResponseHandler() {
					
					@Override
					public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, new String(responseBody), 0).show();
						
					}
					
					@Override
					public void onFailure(int statusCode, Header[] headers,
							byte[] responseBody, Throwable error) {
						Toast.makeText(MainActivity.this, "请求的返回码不是200", 0).show();						
					}
				});
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
    	
    }
    
    public void onclickpost(View v){
    	EditText et_name = (EditText) findViewById(R.id.et_name);
    	EditText et_pass = (EditText) findViewById(R.id.et_pass);
    	
    	final String name = et_name.getText().toString();
    	final String pass = et_pass.getText().toString();
    	
    	String getpath;

		

				AsyncHttpClient ahc = new AsyncHttpClient();
				
				RequestParams params = new RequestParams();
				params.add("name", name);
				params.add("pass", pass);
				
				ahc.post(path, params, new AsyncHttpResponseHandler() {
					
					
					@Override
					public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, new String(responseBody), 0).show();
						
					}
					
					@Override
					public void onFailure(int statusCode, Header[] headers,
							byte[] responseBody, Throwable error) {
						Toast.makeText(MainActivity.this, "请求的返回码不是200", 0).show();						
					}
				});
    	
    }


   
}
