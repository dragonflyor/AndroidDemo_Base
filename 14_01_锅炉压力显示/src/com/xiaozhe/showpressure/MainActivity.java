package com.xiaozhe.showpressure;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	static{
		System.loadLibrary("monitor");
	}
	
    private MyPressureBar pb;
    Thread th = null;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        pb = (MyPressureBar) findViewById(R.id.pb);
        //最大显示刻度
        pb.setMax(100);

    }
    
	//按钮响应
    public void onstart(View v){
    	System.out.println("开始");
    	
    	//如果监控线程不存在
    	if(th==null){
    		th = new Thread(){
    			@Override
    			public void run() {
    				super.run();
    				
    				startMonitor();
    			}
    		};
    		//启动
    		th.start();
    	}
    	
//    	new Thread(){
//    		public void run() {
//    			startMonitor();
//    		};
//    	}.start();;
    	
    }
    
    public void onstop(View v){
    	System.out.println("停止");
    	stopMonitor();
    	
    	if(th!=null){
    		th.stop();
    		th=null;
    	}
    }


    //刷新进度
    void showProgress(int progress){
    	pb.setProgress(progress);
    }
    
    
    //本地方法
    public native void startMonitor();
    public native void stopMonitor();

}
