package com.xiaozhe.copypicture;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        //1 ��ȡԭͼ
        Bitmap bmSrc = BitmapFactory.decodeFile("sdcard/dog3.jpg");
        
        //2 ��ȡ�հ׵�bitmap
        Bitmap bmCopy = Bitmap.createBitmap(bmSrc.getWidth(), bmSrc.getHeight(), bmSrc.getConfig());
        
        //3 ��ȡ����
        Paint paint = new Paint();
        
        //4 bmcopy�ŵ�����
        Canvas canvas = new Canvas(bmCopy);
        //5 ����
        //��Ч����
        Matrix mt = new Matrix();
        
//        //ƽ��
//        mt.setTranslate(20, 40);
        
//        //����
//        mt.setScale(0.5f, 0.5f, bmCopy.getWidth()/2,bmCopy.getHeight()/2);
        
//        //��ת
//        mt.setRotate(45, bmCopy.getWidth()/2,bmCopy.getHeight()/2);
        
//        //����
//        mt.setScale(-1, 1);
//        mt.postTranslate(bmCopy.getWidth(),0);
        
        //��Ӱ
        mt.setScale(1, -1);
        mt.postTranslate(0, bmCopy.getHeight());
        
        canvas.drawBitmap(bmSrc, mt, paint);
        
        //��ʾ
        ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
        ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);
        iv_src.setImageBitmap(bmSrc);
        iv_copy.setImageBitmap(bmCopy);
        

    }


  
}
