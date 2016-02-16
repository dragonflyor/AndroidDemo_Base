package com.xiaozhe.mobilemultidownload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	static int RUNNING_COUNT=3;
	static final String path = "http://172.26.164.3:8080/fg757p.exe";
	static final int THREAD_COUNT = 3;
	
	int length =0;
	int progress = 0;

	//����������
	ProgressBar pb = null;
	//�����ı���ʾ
	TextView tv = null;
	
	
	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==1){
				tv.setText((long)progress*100/length+"%");
				
			}else if(msg.what==2){
				tv.setText(100+"%"+" �������");
			}
		};
	};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        pb = (ProgressBar) findViewById(R.id.pb);
        tv = (TextView) findViewById(R.id.tv);

       
    }
    
    public void onclick(View v){
    	Thread thread = new Thread(){
    		@Override
    		public void run() {
    			try {
    				
    				//1 ���ӵ���������Դ
    				URL url = new URL(path);
    				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    				
    				conn.setConnectTimeout(5000);
    				conn.setReadTimeout(5000);
    				conn.setRequestMethod("GET");
    				
    				conn.connect();
    				
    				if(conn.getResponseCode()==200){
    					//2 ��ȡ�ļ�����
    					length = conn.getContentLength();
    					File file = new File(Environment.getExternalStorageDirectory(),"download.exe");
    					RandomAccessFile raf = new RandomAccessFile(file, "rwd");
    					raf.setLength(length);
    					raf.close();
    					
    					//���ý���������
    					pb.setMax(length);
    					
    					//3 ÿ���߳���Ҫ���ص��ֽ���
    					int blockSize = length/THREAD_COUNT;
    					
    					//4 ���ÿ���߳����صĿ�ʼ �� ����λ��
    					for(int id = 1;id<=THREAD_COUNT;id++){
    						int startIndex = (id-1)*blockSize;
    						int endIndex = id*blockSize-1;
    						if(id==THREAD_COUNT){
    							endIndex=length;
    						}
    						
    						//System.out.println("�߳�"+id+"�����ط�Χ:"+startIndex+"--->"+endIndex);
    						//�������߳�
    						new DownLoadThread(id, startIndex, endIndex).start();
    					}
    				}
    				
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    	};
    	thread.start();
    }
    
    class DownLoadThread extends Thread{
    	int id;
    	int startIndex;
    	int endIndex;
    	
    	public DownLoadThread(int id, int startIndex, int endIndex) {
    		super();
    		this.id = id;
    		this.startIndex = startIndex;
    		this.endIndex = endIndex;
    	}

    	public void run() {
    		
    		
    		//��ȡ�̵�ֵ
    		File file = new File(Environment.getExternalStorageDirectory(),id+".txt");
    		if(file.exists()){
    			//��ȡ�ϴζϵ�ֵ
    			try {
    				BufferedReader br = new BufferedReader(new FileReader(file));
    				int newstartIndex = Integer.parseInt(br.readLine());
    				
    				//��֮ǰ���غõĽ�����ʾ��������
    				int alreadyDownlod = newstartIndex - startIndex;
    				progress +=alreadyDownlod;
    				pb.setProgress(progress);
    				//�ı�����
    				//tv.setText((long)progress/length+"%");
    				handler.sendEmptyMessage(1);
    				
    				startIndex = newstartIndex;
    				
    				br.close();
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    		}
    		
    		System.out.println("�߳�"+id+"�����ط�Χ:"+startIndex+"--->"+endIndex);
    		
    		//1 ���ӵ���������Դ
    		URL url;
    		try {
    			url = new URL(path);
    			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    			
    			conn.setConnectTimeout(5000);
    			conn.setReadTimeout(5000);
    			conn.setRequestMethod("GET");
    			
    			conn.setRequestProperty("range", "bytes="+startIndex+"-"+endIndex);
    			conn.connect();
    			
    			if(conn.getResponseCode()==206){
    				InputStream is = conn.getInputStream();
    				//д�뵽�ļ�
    				File file2 = new File(Environment.getExternalStorageDirectory(),"download.exe");
					RandomAccessFile raf = new RandomAccessFile(file2, "rwd");
    				raf.seek(startIndex);
    				int len =-1;
    				byte[] buf = new byte[1024];
    				int total = 0;
    				while((len = is.read(buf))!=-1){
    					raf.write(buf, 0, len);
    					total += len;
    					System.out.println("�߳�"+id+"������"+total+"byte");
    					
    					File file3 = new File(Environment.getExternalStorageDirectory(),id+".txt");
    					RandomAccessFile raf2 = new RandomAccessFile(file3, "rwd");
    					raf2.write((total+startIndex+"").getBytes());
    					raf2.close();
    					
    					//���س�����ʾ��ui
    					progress +=len;
    					pb.setProgress(progress);
    					//tv.setText((long)progress/length+"%");
    					handler.sendEmptyMessage(1);
    				}
    				raf.close();
    				
    				System.out.println("�߳�"+id+"���ؽ���----------------------");
    				
    				//ɾ������ÿ���̵߳�����������¼
    				RUNNING_COUNT--;
    				synchronized (path) {
    					if(RUNNING_COUNT==0){
    						for(int i=1;i<=THREAD_COUNT;i++){
    							File f = new File(Environment.getExternalStorageDirectory(),i+".txt");
    							f.delete();
    						}
    						//��ֹ�ı�������������ɺ���ʾ99%
    						handler.sendEmptyMessage(2);
    					}
    				}
    			}
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    }


    
}
