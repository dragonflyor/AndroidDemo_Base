package com.xiaozhe.showpressure;

import android.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyPressureBar extends View {

	//进度值
	private int progress = 0;
	private int max = 100;
	
	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
		//设置新的进度后，让整个界面无效，重新再绘制
		///invalidate();//用于主线程
		//子线程用postInvalidate();
		postInvalidate();
	}

	public MyPressureBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public MyPressureBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MyPressureBar(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		//画笔
		Paint paint = new Paint();
		if(progress<60){
			paint.setColor(Color.GREEN);
		}else if(progress<80){
			//android.R.color.holo_orange_light
			paint.setColor(0xffffbb33);
		}else{
			paint.setColor(Color.RED);
		}
		
		//绘制矩形
		canvas.drawRect(10, 10+max-progress, 20, 10+max, paint);
		
		paint.setColor(Color.BLACK);
		paint.setTextSize(10);
		canvas.drawText("压力(kp):"+progress, 5, 10+max+10, paint);
	
		
	}
}
