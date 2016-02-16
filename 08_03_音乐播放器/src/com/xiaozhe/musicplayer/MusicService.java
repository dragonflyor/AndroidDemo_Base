package com.xiaozhe.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MusicService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return new MusicController();
	}
	
	
	public void play(){
		System.out.println("≤•∑≈“Ù¿÷");
	}
	public void pause(){
		System.out.println("‘›Õ£≤•∑≈");
	}
	
	class MusicController extends Binder implements MusicInterface{
		public void play(){
			MusicService.this.play();
		}
		public void pause(){
			MusicService.this.pause();
		}
	}
	
	

}
