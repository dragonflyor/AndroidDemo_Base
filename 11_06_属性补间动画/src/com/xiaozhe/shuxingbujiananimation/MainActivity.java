package com.xiaozhe.shuxingbujiananimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ImageView iv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        iv = (ImageView) findViewById(R.id.iv);
        iv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "�ұ�����", 0).show();
			}
		});

    }
    
    //ƽ��
    public void ontranslate(View v){
    	ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "translationX", 0,70,20,100);
    	oa.setDuration(2000);
    	
    	oa.start();
    }
    
    //����
    public void onscale(View v){
    	ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "scaleX", 0,0.5f,0.2f,1);
    	oa.setDuration(2000);
    	
    	oa.start();
    }
    
    //͸��
    public void onalpha(View v){
    	ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "alpha", 0,0.5f,0.2f,1);
    	oa.setDuration(2000);
    	
    	oa.start();
    }
    
    //��ת
    public void onrotate(View v){
    	ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "rotation", 0,360);
    	oa.setDuration(2000);
    	oa.setRepeatCount(1);
    	oa.setRepeatMode(ValueAnimator.REVERSE);
    	
    	oa.start();
    }
    
    //һ���
    public void onfly(View v){
    	ObjectAnimator oa1 = ObjectAnimator.ofFloat(iv, "translationX", 0,70,20,100,0);
    	oa1.setDuration(2000);
    	
    	ObjectAnimator oa2 = ObjectAnimator.ofFloat(iv, "scaleX", 0,0.5f,0.2f,1);
    	oa2.setDuration(2000);
    	
    	ObjectAnimator oa3 = ObjectAnimator.ofFloat(iv, "alpha", 0,0.5f,0.2f,1);
    	oa3.setDuration(2000);
  
    	ObjectAnimator oa4 = ObjectAnimator.ofFloat(iv, "rotation", 0,360);
    	oa4.setDuration(2000);
    	oa4.setRepeatCount(1);
    	oa4.setRepeatMode(ValueAnimator.REVERSE);
    	
    	//��������
    	AnimatorSet set  =   new AnimatorSet();
    	set.setTarget(iv);
    	//����˳�򲥷�
    	//set.playSequentially(oa1,oa2,oa3,oa4);
    	//һ�𲥷�
    	set.playTogether(oa1,oa2,oa3,oa4);
    	
    	set.start();
    }
    
    //xml�������Զ���
    public void onxml(View v){
    	Animator am = AnimatorInflater.loadAnimator(this, R.animator.animator);
    	am.setTarget(iv);
    	am.start();
    }
    
    
    


}
