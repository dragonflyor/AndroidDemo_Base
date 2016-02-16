package com.xiaozhe.sendintarray;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	static{
		System.loadLibrary("encode");
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
    }
    
    public void onclick(View v){
    	System.out.println("´«µÝÊý×é");
    	int [] array = {1,2,3,4};
    	encode(array);
    	for (int i : array) {
    		System.out.println(i);
		}
    	
    }


    public native void encode(int[] intarray);

}
