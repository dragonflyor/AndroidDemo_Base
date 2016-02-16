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
        //�����ʾ�̶�
        pb.setMax(100);

    }
    
	//��ť��Ӧ
    public void onstart(View v){
    	System.out.println("��ʼ");
    	
    	//�������̲߳�����
    	if(th==null){
    		th = new Thread(){
    			@Override
    			public void run() {
    				super.run();
    				
    				startMonitor();
    			}
    		};
    		//����
    		th.start();
    	}
    	
//    	new Thread(){
//    		public void run() {
//    			startMonitor();
//    		};
//    	}.start();;
    	
    }
    
    public void onstop(View v){
    	System.out.println("ֹͣ");
    	stopMonitor();
    	
    	if(th!=null){
    		th.stop();
    		th=null;
    	}
    }


    //ˢ�½���
    void showProgress(int progress){
    	pb.setProgress(progress);
    }
    
    
    //���ط���
    public native void startMonitor();
    public native void stopMonitor();

}
