package com.xiaozhe.hellofromc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	static {
		//����C��,Ҳ���Ǽ���libhello.os,(ȥͷȥβ���ַ���������hello��)
		System.loadLibrary("hello");
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

       
    }
    
    public void onclick(View v){
    	//����C����
    	Toast.makeText(MainActivity.this,helloFromC(), 0).show();
    }
    
    //���ؽӿ�
    public native String helloFromC();


  
}
