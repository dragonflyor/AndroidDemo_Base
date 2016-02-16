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
     * ��ȡ�����ļ� �����û���������
     */
    public  void regetAccount(){
    	//��ȡ�ļ�
    	SharedPreferences sp = getSharedPreferences("info", MODE_PRIVATE);
    	String name = sp.getString("name", "");
    	String pass = sp.getString("pass", "");
    	//��ȡ�û���������
    	EditText et_name = (EditText)findViewById(R.id.et_name);
    	EditText et_password = (EditText)findViewById(R.id.et_password);
    	
    	//����
    	et_name.setText(name);
    	et_password.setText(pass);
    	
    
			
		
    	
    }
    /**
     * ��Ӧ��¼����
     * �����û�ѡ���ȡ�û��������룬���µ�ѡ���򱣴浽����
     * @param v ��Ӧ�Ŀؼ�����
     */
    public void onLogin(View v){
    	Log.i("onLogin", "��Ӧ��¼");
    	
    	//��ȡ�û���������
    	EditText et_name = (EditText)findViewById(R.id.et_name);
    	EditText et_password = (EditText)findViewById(R.id.et_password);
    	
    	//��ȡ����
    	String name = et_name.getText().toString();
    	String password = et_password.getText().toString();
    	
    	//��鵥ѡ��ť
    	CheckBox cb = (CheckBox)findViewById(R.id.cb);
    	if(cb.isChecked()){
    		//���浽����
    		Log.i("onLogin", "���浽����");
    		SharedPreferences sp = getSharedPreferences("info", MODE_PRIVATE);
    		Editor ed = sp.edit();
    		//����ֵ
    		ed.putString("name", name);
    		ed.putString("pass", password);
    		//�ύ
    		ed.commit();
    		
    		Log.i("onLogin", "���浽���سɹ�");
    		
    	}
    	
    	Toast.makeText(this, "��ϲ��½�ɹ�", Toast.LENGTH_SHORT).show();
    }


}