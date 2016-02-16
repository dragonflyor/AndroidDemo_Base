package com.xiaozhe.bujiananimation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView iv = null;
	private TranslateAnimation ta;
	private ScaleAnimation sa;
	private AlphaAnimation aa;
	private RotateAnimation ra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        iv = (ImageView) findViewById(R.id.iv);

    }
    
    //平移
    public void ontranslate(View v){
    	//TranslateAnimation ta = new TranslateAnimation(20, 80, 30, 80);
    	
    	ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF, 2,
    			Animation.RELATIVE_TO_SELF, -1, Animation.RELATIVE_TO_SELF, 3);
    	
    	//再重复一次
    	ta.setRepeatCount(1);
    	//倒着播放
    	ta.setRepeatMode(Animation.REVERSE);
    	//动作时间
    	ta.setDuration(2000);
    	iv.startAnimation(ta);
    }
    
    //缩放
    public void onscale(View v){
    	//ScaleAnimation sa = new ScaleAnimation(0.5f, 2, 0.1f, 3);
    	//ScaleAnimation sa = new ScaleAnimation(0.5f, 2, 0.1f, 3,iv.getWidth()/2,iv.getHeight()/2);
    	
    	sa = new ScaleAnimation(0.5f, 2, 0.1f, 3
    			,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
    	
    	//动作时间
    	sa.setDuration(2000);
    	iv.startAnimation(sa);
    }
    
    //透明
    public void onalpha(View v){
    	
    	aa = new AlphaAnimation(0, 0.9f);
    	//动作时间
    	aa.setDuration(2000);
    	iv.startAnimation(aa);
    }
    
    //旋转
    public void onrotate(View v){
    	
    	//默认从图标左上角旋转
    	ra = new RotateAnimation(20, 180);
    	//用绝对坐标指定旋转中心
    	//ra = new RotateAnimation(20, 180,iv.getWidth()/2,iv.getHeight()/2);
    	//用相对坐标指定旋转中心
    	
    	//ra = new RotateAnimation(20, 720,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
    	
    	
    	//动作时间
    	ra.setDuration(2000);
    	iv.startAnimation(ra);
    }
    
    //一起飞
    public void onfly(View v){
    	
  
    	//定义动画集合
    	//false表示用个动画自己定义的插补方式  true则使用集合默认你的方式
    	AnimationSet set = new AnimationSet(false);
    	set.addAnimation(aa);
    	set.addAnimation(ra);
    	set.addAnimation(sa);
    	set.addAnimation(ta);
    	
    	iv.startAnimation(set);
    }
    
    


}
