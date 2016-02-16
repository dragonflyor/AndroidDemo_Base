package com.xiaozhe.transdata;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

       
    }
    
    public void onclick(View v){
    	EditText ev = (EditText) findViewById(R.id.ev);
    	String data = ev.getText().toString();
    	
    	Intent intent = new Intent();
    	intent.setData(Uri.parse("data:"+data));
    	intent.setAction("com.xiaozhe.PASSDATATO");
    	
    	startActivity(intent);
    }


}
