package com.xiaozhe.ipdialer;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        //�ȶ�ȡ֮ǰ��������ʾ��ҳ��
        SharedPreferences sharedPreferences = getSharedPreferences("ip.sp", MODE_PRIVATE);
    	String pastip=sharedPreferences.getString("ip", "");
    	EditText et_ip = (EditText) findViewById(R.id.et_ip);
    	et_ip.setText(pastip);
      
    }
    
    
    public void onclick(View v){
    	EditText et_ip = (EditText) findViewById(R.id.et_ip);
    	String ip = et_ip.getText().toString();
    	
    	SharedPreferences sharedPreferences = getSharedPreferences("ip.sp", MODE_PRIVATE);
    
    	sharedPreferences.edit().putString("ip", ip).commit();
    	
    	Toast.makeText(this, "����ɹ�", 0).show();
    	
    	//�ر�ҳ��
    	finish();
    }


  

}
