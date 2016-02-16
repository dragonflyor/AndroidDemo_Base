package com.xiaozhe.cemera;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewDebug.IntToString;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

       
    }
    
    
    public void onimage(View v){
    	Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    	intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(
    			new File(Environment.getExternalStorageDirectory(),"my.jpg")));
    	startActivityForResult(intent, 10);
    }
    public void onvideo(View v){
    	Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
    	intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(
    			new File(Environment.getExternalStorageDirectory(),"my.3gp")));
    	startActivityForResult(intent, 20);
    }


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(requestCode == 10){
			//拍照成功
			Toast.makeText(MainActivity.this, "拍照成功", Toast.LENGTH_LONG).show();
		}
		if(requestCode == 20){
			//摄像成功
			Toast.makeText(MainActivity.this, "拍摄成功", Toast.LENGTH_LONG).show();
		}
	}
    
    


    
}
