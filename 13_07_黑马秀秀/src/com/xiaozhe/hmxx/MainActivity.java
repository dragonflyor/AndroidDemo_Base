package com.xiaozhe.hmxx;

import com.mt.mtxx.image.JNI;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	//���ر��ؿ�
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
    	//���ڱ���������Ϣ
    	int [] pixels = new int[width*height];
    	// ��ȡͼƬ������Ϣ
    	bm.getPixels(pixels, 0, width, 0, 0, width, height);
    	JNI jni = new JNI();
    	//��һ������������ͼƬ���ص�����
    	//�ڶ���������ͼƬ�Ŀ�
    	//������������ͼƬ�ĸ�
    	//�˷���ͨ���������ص���Ϣ�޸�ͼƬ
    	jni.StyleLomoB(pixels, width, height);
    	Bitmap nbm = Bitmap.createBitmap(pixels, bm.getWidth(), bm.getHeight(), bm.getConfig());
    	iv.setImageBitmap(nbm);
    }


}
