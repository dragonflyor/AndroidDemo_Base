package com.xiaozhe.logfromc;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	static {
		System.loadLibrary("logofc");
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

      
    }
    
    public void onclick(View v){
    	System.out.println("按键响应");
    	logfromc();
    }


    //给C调用
    public void show (String msg){
    	Builder builder = new Builder(this);
    	builder.setTitle("标题");
    	builder.setMessage(msg);
    	builder.show();
    }
   public native void logfromc();

}
