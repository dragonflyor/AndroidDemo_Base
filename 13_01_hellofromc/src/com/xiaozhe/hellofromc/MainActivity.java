package com.xiaozhe.hellofromc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	static {
		//加载C库,也就是加载libhello.os,(去头去尾的字符串，即“hello”)
		System.loadLibrary("hello");
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

       
    }
    
    public void onclick(View v){
    	//调用C函数
    	Toast.makeText(MainActivity.this,helloFromC(), 0).show();
    }
    
    //本地接口
    public native String helloFromC();


  
}
