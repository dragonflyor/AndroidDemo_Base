package com.xiaozhe.localadd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	//���ر������
	static{
		System.loadLibrary("add");
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

    }
    
    public void onclick(View v){
    	//��˾���������ý��
    	Toast.makeText(MainActivity.this, "add(3, 6)="+add(3, 6), 0).show();
    }
    
    //���ط����Ľӿ�
    public native int add(int i,int j);


  
}
