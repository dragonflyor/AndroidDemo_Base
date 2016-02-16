package com.xiaozhe.innerstorage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.xiaozhe.sharedpreference.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        regetAccount();


    }
    
    
    /**
     * 读取本地文件 回显用户名和密码
     */
    public  void regetAccount(){
    	//获取文件
    	SharedPreferences sp = getSharedPreferences("info", MODE_PRIVATE);
    	String name = sp.getString("name", "");
    	String pass = sp.getString("pass", "");
    	//获取用户名和密码
    	EditText et_name = (EditText)findViewById(R.id.et_name);
    	EditText et_password = (EditText)findViewById(R.id.et_password);
    	
    	//回显
    	et_name.setText(name);
    	et_password.setText(pass);
    	
    
			
		
    	
    }
    /**
     * 响应登录按键
     * 根据用户选择读取用户名和密码，按下单选框则保存到本地
     * @param v 响应的控件对象
     */
    public void onLogin(View v){
    	Log.i("onLogin", "响应登录");
    	
    	//获取用户名和密码
    	EditText et_name = (EditText)findViewById(R.id.et_name);
    	EditText et_password = (EditText)findViewById(R.id.et_password);
    	
    	//获取内容
    	String name = et_name.getText().toString();
    	String password = et_password.getText().toString();
    	
    	//检查单选按钮
    	CheckBox cb = (CheckBox)findViewById(R.id.cb);
    	if(cb.isChecked()){
    		//保存到本地
    		Log.i("onLogin", "保存到本地");
    		SharedPreferences sp = getSharedPreferences("info", MODE_PRIVATE);
    		Editor ed = sp.edit();
    		//存入值
    		ed.putString("name", name);
    		ed.putString("pass", password);
    		//提交
    		ed.commit();
    		
    		Log.i("onLogin", "保存到本地成功");
    		
    	}
    	
    	Toast.makeText(this, "恭喜登陆成功", Toast.LENGTH_SHORT).show();
    }


}
