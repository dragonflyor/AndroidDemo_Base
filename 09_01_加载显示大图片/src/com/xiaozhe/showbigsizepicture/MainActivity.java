package com.xiaozhe.showbigsizepicture;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

       
    }
    
    public void onclick(View v){
    	//1 ��ȡ��Ļ�ߴ�
    	Display dp = getWindowManager().getDefaultDisplay();
    	int screenWidth = dp.getWidth();
    	int screenHeight = dp.getHeight();
    	
    	//2 ��ȡͼƬ�ߴ�
    	Options opts = new Options();
    	//ֻ��ȡ�ߴ� �����ص��ڴ�
    	opts.inJustDecodeBounds = true;
    	BitmapFactory.decodeFile("sdcard/dog.jpg",opts);
    	int imageWidth = opts.outWidth;
    	int imageHeight = opts.outHeight;
    	
    	//3 ������ʾ����
    	int scale = 1;
    	int scaleX = imageWidth/screenWidth;
    	int scaleY = imageHeight/screenHeight;
    	if(scaleX >= scaleY && scaleX > 1){
    		scale = scaleX;
    	}else if(scaleY > scaleX && scaleY > 1){
    		scale = scaleY;
    	}
    	
    	//4 ��ʾ���ؼ�
    	opts.inSampleSize =scale;
    	opts.inJustDecodeBounds = false;
    	
    	Bitmap bm = BitmapFactory.decodeFile("sdcard/dog.jpg", opts);
    	ImageView iv = (ImageView) findViewById(R.id.iv);
    	iv.setImageBitmap(bm);
    	
    }

}
