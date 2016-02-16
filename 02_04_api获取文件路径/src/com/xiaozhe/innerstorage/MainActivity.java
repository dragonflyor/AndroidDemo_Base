package com.xiaozhe.innerstorage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.xiaozhe.apigetpath.R;

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
//    	File file = new File("data/data/com.xiaozhe.innerstorage/info.txt");
    	File file = new File(getFilesDir(),"logininfo.txt");
    	
    	
    	try {
    		//如果不是刚新建的文件
    		if(!file.createNewFile()){
    			FileReader fr = new FileReader(file);
    			BufferedReader bf = new BufferedReader(fr);
    			
    			String s = bf.readLine();
    			//分出用户名和密码
    			String msg[] = s.split("##");
    			
    	    	//获取用户名和密码
    	    	EditText et_name = (EditText)findViewById(R.id.et_name);
    	    	EditText et_password = (EditText)findViewById(R.id.et_password);
    	    	
    	    	et_name.setText(msg[0]);
    	    	et_password.setText(msg[1]);
    		}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
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
    		//File file = new File("data/data/com.xiaozhe.innerstorage/info.txt");
    		File file = new File(getFilesDir(),"logininfo.txt");
    		try {
				FileOutputStream ou = new FileOutputStream(file);
				ou.write((name+"##"+password).getBytes("utf-8"));
				ou.flush();
				ou.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{

			}
    		
    		Log.i("onLogin", "保存到本地成功");
    		
    	}
    	
    	Toast.makeText(this, "恭喜登陆成功", Toast.LENGTH_SHORT).show();
    }


}
