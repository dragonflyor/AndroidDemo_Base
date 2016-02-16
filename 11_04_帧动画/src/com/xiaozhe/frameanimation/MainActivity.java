package com.xiaozhe.frameanimation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        ImageView iv = (ImageView) findViewById(R.id.iv);
        
        iv.setBackgroundResource(R.drawable.frameantimation);
        
        AnimationDrawable ad = (AnimationDrawable) iv.getBackground();
        
        ad.start();
    }


 
}
