package com.xiaozhe.framenttolowerversion;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

    }
    
    public void onclick1(View v){
    	//创建fragment 
    	Fragment01 fragment01 = new Fragment01();
    	// 布局管理器   getSupportFragmentManager()为向下兼容包替换getFragmentManager()的Api
    	FragmentManager fragmentManager = getSupportFragmentManager();
    	//开启布局事务
    	FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    	//把fragment显示到指定framelayout
    	fragmentTransaction.replace(R.id.fl, fragment01);
    	
    	fragmentTransaction.commit();
    	
    }
    
    public void onclick2(View v){
    	Fragment02 fg02 = new Fragment02();
    	FragmentManager fm = getSupportFragmentManager();
    	
    	FragmentTransaction ft = fm.beginTransaction();
    	ft.replace(R.id.fl, fg02);
    	ft.commit();
    }
    public void onclick3(View v){
    	Fragment03 fg03 = new Fragment03();
    	FragmentManager fm = getSupportFragmentManager();
    	
    	FragmentTransaction ft = fm.beginTransaction();
    	ft.replace(R.id.fl, fg03);
    	ft.commit();
    }


 
}
