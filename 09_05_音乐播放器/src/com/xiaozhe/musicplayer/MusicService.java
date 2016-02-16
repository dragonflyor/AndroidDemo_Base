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
		//��������������
		player = new MediaPlayer();
		//������ʱ��
		if(timer == null){
			addTimer();
		}
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
		//�ͷ���Դ
		player.stop();
		player.release();
		player = null;
		
		//�رն�ʱ��
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
		//����
//		player.reset();
//		try {
//			//���¼�����Դ
//			player.setDataSource("sdcard/addj.mp3");
//			//Ӳ��׼��
//			player.prepare();
//			player.start();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//��������
		player.reset();
		try {
			player.setDataSource("http://172.26.164.3:8080/old.mp3");
			//�첽������Դ׼��
			player.prepareAsync();
			//�����첽������Դ׼��
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
	
	//�϶������ﲥ��
	void seekTo(int msec){
		player.seekTo(msec);
	}
	
	void addTimer(){
		timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				//��ȡ������Ҫ��ʾ������
				int currentPosition = player.getCurrentPosition();
				int duration = player.getDuration();
				//�����Ϣ
				Bundle data = new Bundle();
				data.putInt("currentPosition", currentPosition);
				data.putInt("duration", duration);
				//���͵����߳�
				Message msg = MainActivity.handler.obtainMessage();
				msg.setData(data);
				MainActivity.handler.sendMessage(msg);
				
			}
		}, 5, 500);
	}

}
