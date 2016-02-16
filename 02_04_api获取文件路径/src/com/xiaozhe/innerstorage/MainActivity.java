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
     * ��ȡ�����ļ� �����û���������
     */
    public  void regetAccount(){
    	//��ȡ�ļ�
//    	File file = new File("data/data/com.xiaozhe.innerstorage/info.txt");
    	File file = new File(getFilesDir(),"logininfo.txt");
    	
    	
    	try {
    		//������Ǹ��½����ļ�
    		if(!file.createNewFile()){
    			FileReader fr = new FileReader(file);
    			BufferedReader bf = new BufferedReader(fr);
    			
    			String s = bf.readLine();
    			//�ֳ��û���������
    			String msg[] = s.split("##");
    			
    	    	//��ȡ�û���������
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
    		
    		Log.i("onLogin", "���浽���سɹ�");
    		
    	}
    	
    	Toast.makeText(this, "��ϲ��½�ɹ�", Toast.LENGTH_SHORT).show();
    }


}
