package com.xiaozhe.musicplayer;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {
	
	static Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			
			//刷新进度条
			Bundle bundle = msg.getData();
			int currentPosition = bundle.getInt("currentPosition");
			int duration = bundle.getInt("duration");
			
			sb.setMax(duration);
			sb.setProgress(currentPosition);
			tv_progress.setText((currentPosition/1000) + "s/" + (duration/1000) + "s");
		}
		
	};

	MusicInterface msInterface = null;
	private MyServiceConnection conn;
	private Intent intent;

	//进度控件
	private static SeekBar sb;
	private static TextView tv_progress;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        sb = (SeekBar) findViewById(R.id.sb);
        tv_progress = (TextView) findViewById(R.id.tv_progress);
  
        intent = new Intent(this, MusicService.class);
        startService(intent);
        conn = new MyServiceConnection();
        bindService(intent, conn, BIND_AUTO_CREATE);
        
  
    }
    
    class MyServiceConnection implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			//获取service方法
			msInterface = (MusicInterface) service;
			System.out.println("成功绑定……");
			
			//给进度条绑定监听
			sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				
				//松手的时候跳转
				@Override
				public void onStopTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					int position = seekBar.getProgress();
					msInterface.seekTo(position);
				}
				
				@Override
				public void onStartTrackingTouch(SeekBar seekBar) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onProgressChanged(SeekBar seekBar, int progress,
						boolean fromUser) {
					// TODO Auto-generated method stub
					
				}
			});
			
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
    	
    }
    
    public void onplay(View v){
    	msInterface.play();
    }
    
    public void onpause(View v){
    	msInterface.pause();
    }
    
    public void oncontinue(View v){
    	msInterface.continuePlay();
    }
    
    public void onexit(View v){
    	//关闭服务
    	unbindService(conn);
    	stopService(intent);
    	finish();
    }


}
