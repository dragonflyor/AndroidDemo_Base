package com.xiaozhe.multidownload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;


public class MutilDownload {
	static int RUNNING_COUNT=3;
	static final String path = "http://172.26.164.3:8080/360freeap.exe";
	static final int THREAD_COUNT = 3;
		public static void main(String[] args) {
			
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
					int length = conn.getContentLength();
					RandomAccessFile raf = new RandomAccessFile("download.exe", "rwd");
					raf.setLength(length);
					raf.close();
					
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
		File file = new File(id+".txt");
		if(file.exists()){
			//��ȡ�ϴζϵ�ֵ
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				int newstartIndex = Integer.parseInt(br.readLine());
				
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
			url = new URL(MutilDownload.path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.setRequestMethod("GET");
			
			conn.setRequestProperty("range", "bytes="+startIndex+"-"+endIndex);
			conn.connect();
			
			if(conn.getResponseCode()==206){
				InputStream is = conn.getInputStream();
				//д�뵽�ļ�
				RandomAccessFile raf = new RandomAccessFile("download.exe", "rwd");
				raf.seek(startIndex);
				int len =-1;
				byte[] buf = new byte[1024];
				int total = 0;
				while((len = is.read(buf))!=-1){
					raf.write(buf, 0, len);
					total += len;
					System.out.println("�߳�"+id+"������"+total+"byte");
					
					RandomAccessFile raf2 = new RandomAccessFile(id+".txt", "rwd");
					raf2.write((total+startIndex+"").getBytes());
					raf2.close();
				}
				raf.close();
				
				System.out.println("�߳�"+id+"���ؽ���----------------------");
				
				//ɾ������ÿ���̵߳�����������¼
				MutilDownload.RUNNING_COUNT--;
				synchronized (MutilDownload.path) {
					if(MutilDownload.RUNNING_COUNT==0){
						for(int i=1;i<=MutilDownload.THREAD_COUNT;i++){
							File f = new File(i+".txt");
							f.delete();
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
