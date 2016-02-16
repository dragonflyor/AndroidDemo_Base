package com.xiaozhe.opencodetogetpic;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.loopj.android.image.SmartImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        
       

    }
    
    public void onclick(View v){
    	 SmartImageView siv = (SmartImageView) findViewById(R.id.siv);
    	 String url = "http://e.hiphotos.baidu.com/baike/w%3D268/sign=91e4259343166d22387712927e230945/14ce36d3d539b600feecadefe950352ac65cb74c.jpg";
         //String url = "http://172.26.164.3:8080/p1.jpg";
         siv.setImageUrl(url);
    }


  
}
