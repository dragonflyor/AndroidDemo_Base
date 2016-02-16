package com.xiaozhe.paintboard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	int startX;
	int startY;
	private Paint paint;
	private Canvas canvas;
	private ImageView iv;
	private Bitmap copyBm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        //��ȡbitmap�����ı���
        Bitmap srcBm = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        copyBm = Bitmap.createBitmap(srcBm.getWidth(), srcBm.getHeight(), srcBm.getConfig());
        paint = new Paint();
        canvas = new Canvas(copyBm);
        canvas.drawBitmap(srcBm, new Matrix(), paint);
        
        
        
        iv = (ImageView) findViewById(R.id.iv);
        iv.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
				switch (event.getAction()){
				case MotionEvent.ACTION_DOWN:
					System.out.println("��������");
					startX = (int) event.getX();
					startY = (int) event.getY(); 
					break;
				case MotionEvent.ACTION_MOVE:
					int newX = (int) event.getX();
					int newY = (int) event.getY();
					//����
					canvas.drawLine(startX, startY, newX, newY, paint);
					iv.setImageBitmap(copyBm);
					System.out.println("�����ƶ�");
					
					startX = newX;
					startY = newY;
					break;
				case MotionEvent.ACTION_UP:
					System.out.println("�����뿪");
					break;
					
				}
				return true;
			}
		});

        
    }
    
    public void onred(View v){
    	//��ɫģʽ
    	paint.setColor(Color.RED);
    }
    public void ongreen(View v){
    	//��ɫģʽ
    	paint.setColor(Color.GREEN);
    }
    public void onbrush(View v){
    	//��ˢģʽ
    	paint.setStrokeWidth(7);
    }
    public void onsave(View v){
    	//����ͼƬ
    	FileOutputStream fos =null;
		try {
			fos = new FileOutputStream(new File("sdcard/lastsave.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	copyBm.compress(CompressFormat.PNG, 100, fos);
    	
    	
    	//��ϵͳͼ�����±�����Դ ����ʾ���Ǹ���ӵ�ͼƬ
    	Intent intent = new Intent();
    	intent.setAction(Intent.ACTION_MEDIA_MOUNTED);
    	intent.setData(Uri.fromFile(Environment.getExternalStorageDirectory()));
    	sendBroadcast(intent);
    	
    }



}
