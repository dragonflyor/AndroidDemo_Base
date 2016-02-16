package com.xiaozhe.jump;

import java.net.URI;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

     
    }


    /**
     * ��ʽ�򿪲�����
     * @param v
     */
  public void onclick(View v){
	  Intent intent = new Intent();
	  
	  //Ҫ���嵥������Ȩ��
	  intent.setAction(Intent.ACTION_DIAL);
	  intent.setData(Uri.parse("tel:1334949"));
	  
	  startActivity(intent);
	  
	  
	  
  }
  /**
   * ��ʾ�򿪵ڶ���ҳ��
   * @param v
   */
  public void onclick1(View v){
	  Intent intent = new Intent();
	  intent.setClass(MainActivity.this, SecondActivity.class);
	  startActivity(intent);
  }
  
 /**
  * ��ʾ�򿪲����� 
  * cmp=com.android.dialer/.DialtactsActivity
  * @param v
  */
  public void onclick2(View v){
	  Intent intent = new Intent();
	  intent.setClassName("com.android.dialer", "com.android.dialer.DialtactsActivity");
	  startActivity(intent);
  }
  
  /**
   * ��ʽ�򿪵ڶ���ҳ��
   * ��Ҫ���嵥�����ö���
   * @param v
   */
  public void onclick3(View v){
	  Intent intent = new Intent();
	  intent.setAction("com.xiaozhe.SA");
	  startActivity(intent);
  }
  

}
