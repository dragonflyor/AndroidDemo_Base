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
        
        //1 获取原图
        Bitmap bmSrc = BitmapFactory.decodeFile("sdcard/dog3.jpg");
        
        //2 获取空白的bitmap
        Bitmap bmCopy = Bitmap.createBitmap(bmSrc.getWidth(), bmSrc.getHeight(), bmSrc.getConfig());
        
        //3 获取画笔
        Paint paint = new Paint();
        
        //4 bmcopy放到画板
        Canvas canvas = new Canvas(bmCopy);
        //5 作画
        //特效处理
        Matrix mt = new Matrix();
        
//        //平移
//        mt.setTranslate(20, 40);
        
//        //缩放
//        mt.setScale(0.5f, 0.5f, bmCopy.getWidth()/2,bmCopy.getHeight()/2);
        
//        //旋转
//        mt.setRotate(45, bmCopy.getWidth()/2,bmCopy.getHeight()/2);
        
//        //镜面
//        mt.setScale(-1, 1);
//        mt.postTranslate(bmCopy.getWidth(),0);
        
        //倒影
        mt.setScale(1, -1);
        mt.postTranslate(0, bmCopy.getHeight());
        
        canvas.drawBitmap(bmSrc, mt, paint);
        
        //显示
        ImageView iv_src = (ImageView) findViewById(R.id.iv_src);
        ImageView iv_copy = (ImageView) findViewById(R.id.iv_copy);
        iv_src.setImageBitmap(bmSrc);
        iv_copy.setImageBitmap(bmCopy);
        

    }


  
}
