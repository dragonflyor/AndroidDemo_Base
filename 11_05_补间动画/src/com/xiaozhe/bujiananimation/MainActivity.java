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
    
    //ƽ��
    public void ontranslate(View v){
    	//TranslateAnimation ta = new TranslateAnimation(20, 80, 30, 80);
    	
    	ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF, 2,
    			Animation.RELATIVE_TO_SELF, -1, Animation.RELATIVE_TO_SELF, 3);
    	
    	//���ظ�һ��
    	ta.setRepeatCount(1);
    	//���Ų���
    	ta.setRepeatMode(Animation.REVERSE);
    	//����ʱ��
    	ta.setDuration(2000);
    	iv.startAnimation(ta);
    }
    
    //����
    public void onscale(View v){
    	//ScaleAnimation sa = new ScaleAnimation(0.5f, 2, 0.1f, 3);
    	//ScaleAnimation sa = new ScaleAnimation(0.5f, 2, 0.1f, 3,iv.getWidth()/2,iv.getHeight()/2);
    	
    	sa = new ScaleAnimation(0.5f, 2, 0.1f, 3
    			,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
    	
    	//����ʱ��
    	sa.setDuration(2000);
    	iv.startAnimation(sa);
    }
    
    //͸��
    public void onalpha(View v){
    	
    	aa = new AlphaAnimation(0, 0.9f);
    	//����ʱ��
    	aa.setDuration(2000);
    	iv.startAnimation(aa);
    }
    
    //��ת
    public void onrotate(View v){
    	
    	//Ĭ�ϴ�ͼ�����Ͻ���ת
    	ra = new RotateAnimation(20, 180);
    	//�þ�������ָ����ת����
    	//ra = new RotateAnimation(20, 180,iv.getWidth()/2,iv.getHeight()/2);
    	//���������ָ����ת����
    	
    	//ra = new RotateAnimation(20, 720,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
    	
    	
    	//����ʱ��
    	ra.setDuration(2000);
    	iv.startAnimation(ra);
    }
    
    //һ���
    public void onfly(View v){
    	
  
    	//���嶯������
    	//false��ʾ�ø������Լ�����Ĳ岹��ʽ  true��ʹ�ü���Ĭ����ķ�ʽ
    	AnimationSet set = new AnimationSet(false);
    	set.addAnimation(aa);
    	set.addAnimation(ra);
    	set.addAnimation(sa);
    	set.addAnimation(ta);
    	
    	iv.startAnimation(set);
    }
    
    


}
