package com.xiaozhe.logcat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        System.out.println("hello,world!");
        System.out.println("你好，世界!");
        
        Log.i("调试", "11111111111");
        Log.v("调试", "222222222222");
        Log.d("调试", "3333333333333");
        Log.e("调试", "44444444444");
        Log.w("调试", "55555555555");
        	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

  
}
