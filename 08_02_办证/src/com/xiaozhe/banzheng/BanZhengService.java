package com.xiaozhe.banzheng;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class BanZhengService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("��");
		return new ZhongJianRen();
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("���");
		return super.onUnbind(intent);
	}


	class ZhongJianRen extends Binder implements PublicBussiness{
		@Override
		public void QianXain() {
			// TODO Auto-generated method stub
			BanZheng();
		}
		
		public void DaMaJiang(){
			System.out.println("���˴��齫");
		}
		
	}
	
	void BanZheng(){
		System.out.println("��æ��֤��");
	}
	
	
	
//--------------------
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}


	
}
