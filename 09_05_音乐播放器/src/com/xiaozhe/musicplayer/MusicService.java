package com.xiaozhe.musicplayer;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;

public class MusicService extends Service {

	MediaPlayer player = null;
	private Timer timer;
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return new MusicController();
	}
	
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		//创建播放器对象
		player = new MediaPlayer();
		//创建定时器
		if(timer == null){
			addTimer();
		}
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		//释放资源
		player.stop();
		player.release();
		player = null;
		
		//关闭定时器
		if(timer != null){
			timer.cancel();
			timer = null;
		}
	}

	class MusicController extends Binder implements MusicInterface{
		public void play(){
			MusicService.this.play();
		}
		
		
		public void pause(){
			MusicService.this.pause();
		}
		
		public void continuePlay(){
			MusicService.this.continuePlay();
		}


		@Override
		public void seekTo(int msec) {
			// TODO Auto-generated method stub
			MusicService.this.seekTo(msec);
		}
	}

	


	void play(){
		//重置
//		player.reset();
//		try {
//			//重新加载资源
//			player.setDataSource("sdcard/addj.mp3");
//			//硬件准备
//			player.prepare();
//			player.start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//网络音乐
		player.reset();
		try {
			player.setDataSource("http://172.26.164.3:8080/old.mp3");
			//异步加载资源准备
			player.prepareAsync();
			//监听异步加载资源准备
			player.setOnPreparedListener(new OnPreparedListener() {
				
				@Override
				public void onPrepared(MediaPlayer mp) {
					player.start();
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	void pause(){
		player.pause();
	}
	
	void continuePlay(){
		player.start();
	}
	
	//拖动到哪里播放
	void seekTo(int msec){
		player.seekTo(msec);
	}
	
	void addTimer(){
		timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				//获取进度条要显示的内容
				int currentPosition = player.getCurrentPosition();
				int duration = player.getDuration();
				//打包信息
				Bundle data = new Bundle();
				data.putInt("currentPosition", currentPosition);
				data.putInt("duration", duration);
				//发送到主线程
				Message msg = MainActivity.handler.obtainMessage();
				msg.setData(data);
				MainActivity.handler.sendMessage(msg);
				
			}
		}, 5, 500);
	}

}
