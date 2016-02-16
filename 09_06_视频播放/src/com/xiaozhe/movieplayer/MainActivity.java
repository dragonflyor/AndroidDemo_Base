package com.xiaozhe.movieplayer;

import io.vov.vitamio.LibsChecker;
import android.app.Activity;
import android.os.Bundle;
import android.provider.MediaStore.Video;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        //checked hardware
        if(!LibsChecker.checkVitamioLibs(this)){return;}
        VideoView vv = (VideoView) findViewById(R.id.vv);
        vv.setVideoPath("sdcard/vidio.mp4");
        vv.start();
        
        //conctrol bar
        vv.setMediaController(new MediaController(this));
        

       
    }


    
}
