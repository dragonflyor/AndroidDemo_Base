package com.xiaozhe.pic;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private Bitmap copyBm;
	private ImageView iv_forward;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        Bitmap srcBm = BitmapFactory.decodeResource(getResources(), R.drawable.forward);
        copyBm = Bitmap.createBitmap(srcBm.getWidth(), srcBm.getHeight(), srcBm.getConfig());
        Paint paint =new Paint();
        Canvas canvas = new Canvas(copyBm);
        canvas.drawBitmap(srcBm, new Matrix(), paint);
        
        iv_forward = (ImageView) findViewById(R.id.iv_forward);
        
        iv_forward.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				
				switch (event.getAction()) {
				case MotionEvent.ACTION_MOVE:
					int X = (int) event.getX();
					int Y = (int) event.getY();
					System.out.println("坐标："+X+","+Y);
					
					
//					copyBm.setPixel(X, Y, Color.TRANSPARENT);
//					iv_forward.setImageBitmap(copyBm);
					
					//区域透明
					for(int i = -5; i<=5; i++){
						for (int j = -5; j < 5; j++) {
							//把点设置为透明
							//透明范围为半径为5的圆圈
							if(Math.sqrt(i*i+j*j)<=5){
								//没超过绘图显示区域
								if(X+i < copyBm.getWidth()  
										&& Y+j < copyBm.getHeight()
										&& X+i>=0
										&& Y+j>=0){
									
									copyBm.setPixel(X+i, Y+j, Color.TRANSPARENT);
									iv_forward.setImageBitmap(copyBm);
									
								}
							}

							
							
						}
					}
					
					break;

		
				}
				return true;
			}
		});
    }

    
    

   
}
