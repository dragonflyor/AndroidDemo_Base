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
     * 隐式打开拨号盘
     * @param v
     */
  public void onclick(View v){
	  Intent intent = new Intent();
	  
	  //要在清单中配置权限
	  intent.setAction(Intent.ACTION_DIAL);
	  intent.setData(Uri.parse("tel:1334949"));
	  
	  startActivity(intent);
	  
	  
	  
  }
  /**
   * 显示打开第二个页面
   * @param v
   */
  public void onclick1(View v){
	  Intent intent = new Intent();
	  intent.setClass(MainActivity.this, SecondActivity.class);
	  startActivity(intent);
  }
  
 /**
  * 显示打开拨号盘 
  * cmp=com.android.dialer/.DialtactsActivity
  * @param v
  */
  public void onclick2(View v){
	  Intent intent = new Intent();
	  intent.setClassName("com.android.dialer", "com.android.dialer.DialtactsActivity");
	  startActivity(intent);
  }
  
  /**
   * 隐式打开第二个页面
   * 需要在清单中配置动作
   * @param v
   */
  public void onclick3(View v){
	  Intent intent = new Intent();
	  intent.setAction("com.xiaozhe.SA");
	  startActivity(intent);
  }
  

}
