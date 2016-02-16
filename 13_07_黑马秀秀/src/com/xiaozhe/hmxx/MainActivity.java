package com.xiaozhe.hmxx;

import com.mt.mtxx.image.JNI;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	//加载本地库
	static {
		System.loadLibrary("mtimage-jni");
	}
	
    private ImageView iv;
	private Bitmap bm;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
     	iv = (ImageView) findViewById(R.id.iv);
    	bm = BitmapFactory.decodeFile("sdcard/dog3.jpg");
    	iv.setImageBitmap(bm);

    }
    
	
    public void onclick(View v){
    	int width = bm.getWidth();
    	int height = bm.getHeight();
    	//用于保存像素信息
    	int [] pixels = new int[width*height];
    	// 获取图片像素信息
    	bm.getPixels(pixels, 0, width, 0, 0, width, height);
    	JNI jni = new JNI();
    	//第一个参数：保存图片像素的数组
    	//第二个参数：图片的宽
    	//第三个参数：图片的高
    	//此方法通过传入像素的信息修改图片
    	jni.StyleLomoB(pixels, width, height);
    	Bitmap nbm = Bitmap.createBitmap(pixels, bm.getWidth(), bm.getHeight(), bm.getConfig());
    	iv.setImageBitmap(nbm);
    }


}
