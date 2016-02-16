package com.xiaozhe.readsms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlSerializer;

import com.xiaozhe.readsms.bean.MSG;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	ArrayList<MSG> msgList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        //装短信的集合
        msgList = new ArrayList<MSG>();

    }


    public void onsms(View v){
    	ContentResolver cr = getContentResolver();
    	Uri uri = Uri.parse("content://sms");
    	Cursor cursor = cr.query(uri, new String[]{"body","address","date","type"}, null, null, null);
    	//显示到控制台
    	while(cursor.moveToNext()){
    		String body = cursor.getString(cursor.getColumnIndex("body"));
    		String address = cursor.getString(cursor.getColumnIndex("address"));
    		String date = cursor.getString(cursor.getColumnIndex("date"));
    		String type = cursor.getString(cursor.getColumnIndex("type"));
    		
    		System.out.println(address+"--"+body+"--"+date+"--"+type);
    		
    		//保存到集合
    		msgList.add(new MSG(body, address, date, type));
    	}
    }
    
    public void onbackup(View v){
    	
    	if(msgList.isEmpty()){
    		Toast.makeText(MainActivity.this, "先点击读取系统短信", 1).show();
    		
    		return ;
    	}
    	
    	XmlSerializer xmlSerializer = Xml.newSerializer();
    	
    	File file = new File("sdcard/smsbkup.xml");
    	try {
			xmlSerializer.setOutput(new FileOutputStream(file), "utf-8");
			
			xmlSerializer.startDocument("utf-8", true);
			
			xmlSerializer.startTag(null, "msgs");
			
			for (MSG msg : msgList) {
				
				xmlSerializer.startTag(null, "msg");
				
					xmlSerializer.startTag(null, "body");
					xmlSerializer.text(msg.getBody());
					xmlSerializer.endTag(null, "body");
					
					xmlSerializer.startTag(null, "address");
					xmlSerializer.text(msg.getAddress());
					xmlSerializer.endTag(null, "address");
					
					xmlSerializer.startTag(null, "date");
					xmlSerializer.text(msg.getDate());
					xmlSerializer.endTag(null, "date");
					
					xmlSerializer.startTag(null, "type");
					xmlSerializer.text(msg.getType());
					xmlSerializer.endTag(null, "type");
	
				xmlSerializer.endTag(null, "msg");
			}
			
			
			xmlSerializer.endTag(null, "msgs");
			
			xmlSerializer.endDocument();
			
			xmlSerializer.flush();
			
			Toast.makeText(MainActivity.this, "备份成功", 0).show();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
