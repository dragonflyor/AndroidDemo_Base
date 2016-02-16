package com.xiaozhe.xutilsmultidownload;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;



public class MainActivity extends Activity {

	ProgressBar pb=null;
	TextView tv_progress =null;
	TextView tv_downloadinfo =null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        pb = (ProgressBar) findViewById(R.id.pb);
        tv_progress = (TextView) findViewById(R.id.tv_progress);
        tv_downloadinfo=(TextView) findViewById(R.id.tv_downloadinfo);
       
    }
    
    public void onclick(View v){
    	HttpUtils httpUtils = new HttpUtils();
    	
    	httpUtils.download("http://172.26.164.3:8080/fg757p.exe", 
    			"sdcard/fg757p.exe",
    			true, 
    			true, 
    			new RequestCallBack<File>() {

					@Override
					public void onFailure(HttpException arg0, String arg1) {
						tv_downloadinfo.setText("下载失败："+arg1);
					}

					@Override
					public void onSuccess(ResponseInfo<File> arg0) {
						tv_downloadinfo.setText("下载成功："+arg0.result.getPath());						
					}
					
					@Override
					public void onLoading(long total, long current,
							boolean isUploading) {
						super.onLoading(total, current, isUploading);
						
						pb.setMax((int)total);
						pb.setProgress((int) current);
						
						tv_progress.setText(current*100/total + "%");
						
					}
		});
    	
    } 


 
}
