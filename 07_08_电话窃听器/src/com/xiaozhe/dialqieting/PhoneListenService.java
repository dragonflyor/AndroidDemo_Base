package com.xiaozhe.dialqieting;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class PhoneListenService extends Service {

	MediaRecorder recorder =null;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		//设置监听器
		tm.listen(new MyPhoneStateListener(),PhoneStateListener.LISTEN_CALL_STATE);
		
	}
	
	class MyPhoneStateListener extends PhoneStateListener{

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			// TODO Auto-generated method stub
			super.onCallStateChanged(state, incomingNumber);
			//根据不同的状态
			switch(state){
			case TelephonyManager.CALL_STATE_IDLE:
				System.out.println("电话空闲");
				if(recorder!=null){
					//通话结束，停止录音
					recorder.stop();
					recorder.release();
				}
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:
				System.out.println("电话接起");
				//开始录音
				if(recorder!=null){
					recorder.start();
				}
				break;
			case TelephonyManager.CALL_STATE_RINGING:
				System.out.println("电话响铃");
				recorder = new MediaRecorder();
				//声音来源
				recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
				//音频格式
				recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
				recorder.setOutputFile("sdcard/luying20151226.3gp");
				//音频编码
				recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
				//准备
				try {
					recorder.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			}
		}
		
	}

}
