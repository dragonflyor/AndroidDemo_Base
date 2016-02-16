package com.xiaozhe.framentsenddata;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private Fragment01 fragment01 = new Fragment01();
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
    	// ���ֹ�����
    	FragmentManager fragmentManager = getFragmentManager();
    	//������������
    	FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    	//��fragment��ʾ��ָ��framelayout
    	fragmentTransaction.replace(R.id.fl, fragment01);
    	
    	fragmentTransaction.commit();

    }
    
    public void onclick1(View v){
    	
    	// ���ֹ�����
    	FragmentManager fragmentManager = getFragmentManager();
    	//������������
    	FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    	//��fragment��ʾ��ָ��framelayout
    	fragmentTransaction.replace(R.id.fl, fragment01);
    	
    	fragmentTransaction.commit();
    	
    }
    
    public void onclick2(View v){
    	Fragment02 fg02 = new Fragment02();
    	FragmentManager fm = getFragmentManager();
    	
    	FragmentTransaction ft = fm.beginTransaction();
    	ft.replace(R.id.fl, fg02);
    	ft.commit();
    }
    public void onclick3(View v){
    	Fragment03 fg03 = new Fragment03();
    	FragmentManager fm = getFragmentManager();
    	
    	FragmentTransaction ft = fm.beginTransaction();
    	ft.replace(R.id.fl, fg03);
    	ft.commit();
    }
    public void onclick4(View v){
    	EditText et_main = (EditText) findViewById(R.id.et_main);
    	String text  = et_main.getText().toString();
    	
    	fragment01.setText(text);
    }

    
    public void setText(String text){
    	EditText et_main = (EditText) findViewById(R.id.et_main);
    	et_main.setText(text);
    }

 
}
