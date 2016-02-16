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

	//进度条进度
	ProgressBar pb = null;
	//进度文本显示
	TextView tv = null;
	
	
	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==1){
				tv.setText((long)progress*100/length+"%");
				
			}else if(msg.what==2){
				tv.setText(100+"%"+" 下载完成");
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
    				
    				//1 连接到服务器资源
    				URL url = new URL(path);
    				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    				
    				conn.setConnectTimeout(5000);
    				conn.setReadTimeout(5000);
    				conn.setRequestMethod("GET");
    				
    				conn.connect();
    				
    				if(conn.getResponseCode()==200){
    					//2 获取文件长度
    					length = conn.getContentLength();
    					File file = new File(Environment.getExternalStorageDirectory(),"download.exe");
    					RandomAccessFile raf = new RandomAccessFile(file, "rwd");
    					raf.setLength(length);
    					raf.close();
    					
    					//设置进度条长度
    					pb.setMax(length);
    					
    					//3 每个线程需要下载的字节数
    					int blockSize = length/THREAD_COUNT;
    					
    					//4 算出每个线程下载的开始 和 结束位置
    					for(int id = 1;id<=THREAD_COUNT;id++){
    						int startIndex = (id-1)*blockSize;
    						int endIndex = id*blockSize-1;
    						if(id==THREAD_COUNT){
    							endIndex=length;
    						}
    						
    						//System.out.println("线程"+id+"的下载范围:"+startIndex+"--->"+endIndex);
    						//开启多线程
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
    		
    		
    		//读取短点值
    		File file = new File(Environment.getExternalStorageDirectory(),id+".txt");
    		if(file.exists()){
    			//读取上次断点值
    			try {
    				BufferedReader br = new BufferedReader(new FileReader(file));
    				int newstartIndex = Integer.parseInt(br.readLine());
    				
    				//将之前下载好的进度显示到进度条
    				int alreadyDownlod = newstartIndex - startIndex;
    				progress +=alreadyDownlod;
    				pb.setProgress(progress);
    				//文本进度
    				//tv.setText((long)progress/length+"%");
    				handler.sendEmptyMessage(1);
    				
    				startIndex = newstartIndex;
    				
    				br.close();
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    		}
    		
    		System.out.println("线程"+id+"的下载范围:"+startIndex+"--->"+endIndex);
    		
    		//1 连接到服务器资源
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
    				//写入到文件
    				File file2 = new File(Environment.getExternalStorageDirectory(),"download.exe");
					RandomAccessFile raf = new RandomAccessFile(file2, "rwd");
    				raf.seek(startIndex);
    				int len =-1;
    				byte[] buf = new byte[1024];
    				int total = 0;
    				while((len = is.read(buf))!=-1){
    					raf.write(buf, 0, len);
    					total += len;
    					System.out.println("线程"+id+"下载了"+total+"byte");
    					
    					File file3 = new File(Environment.getExternalStorageDirectory(),id+".txt");
    					RandomAccessFile raf2 = new RandomAccessFile(file3, "rwd");
    					raf2.write((total+startIndex+"").getBytes());
    					raf2.close();
    					
    					//下载长度显示到ui
    					progress +=len;
    					pb.setProgress(progress);
    					//tv.setText((long)progress/length+"%");
    					handler.sendEmptyMessage(1);
    				}
    				raf.close();
    				
    				System.out.println("线程"+id+"下载结束----------------------");
    				
    				//删除保存每个线程的下载索引记录
    				RUNNING_COUNT--;
    				synchronized (path) {
    					if(RUNNING_COUNT==0){
    						for(int i=1;i<=THREAD_COUNT;i++){
    							File f = new File(Environment.getExternalStorageDirectory(),i+".txt");
    							f.delete();
    						}
    						//防止文本进度条下载完成后显示99%
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
