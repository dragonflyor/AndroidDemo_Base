package com.xiaozhe.remoteservice;

import com.xiaozhe.remoteservice.PublicBusiness.Stub;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class RomoterService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("远程服务onBind");
		return new ZhongJianRen();
	}
	
	class ZhongJianRen extends Stub{

		@Override
		public void QianXian() {
			// TODO Auto-generated method stub
			RomoterService.this.BanZheng();
		}
		
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("远程服务onUnbind");
		return super.onUnbind(intent);
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("远程服务onCreate");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		System.out.println("远程服务onStartCommand");
		return super.onStartCommand(intent, flags, startId);
		
		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("远程服务onDestroy");
	}
	
	void BanZheng(){
		System.out.println("远程服务里卖弄的：帮忙办证！");
	}



}
