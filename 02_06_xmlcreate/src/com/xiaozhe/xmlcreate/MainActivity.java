package com.xiaozhe.xmlcreate;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlSerializer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.util.Xml;
import android.view.View;

public class MainActivity extends Activity {
    //生成10条短信
    ArrayList<com.xioazhe.dombean.Message> smslist =new ArrayList<com.xioazhe.dombean.Message>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
   
        
        for (int i = 0; i < 10; i++) {
			com.xioazhe.dombean.Message message = 
					new com.xioazhe.dombean.Message("你好"+i,System.currentTimeMillis()+"","1333"+i+i+i,0+"");
			smslist.add(message);
			
		}
        
      
    }
    
    
    public void onclick(View v){
    	System.out.println("准备保存!");
    	//xml序列化器
    	XmlSerializer xs = Xml.newSerializer();
    	//初始化输出流
    	File file = new File("sdcard/sms.xml");
    	try {
    		FileOutputStream fos = new FileOutputStream(file) ;
			xs.setOutput(fos, "utf-8");
			//开始写数据 
			xs.startDocument("utf-8", true);
			
			xs.startTag(null, "messages");
			
			for (com.xioazhe.dombean.Message sm : smslist) {
				xs.startTag(null, "sms");
					xs.startTag(null, "body");
					xs.text(sm.getBody());
					xs.endTag(null, "body");
					
					xs.startTag(null, "address");
					xs.text(sm.getAddress());
					xs.endTag(null, "address");
					
					xs.startTag(null, "date");
					xs.text(sm.getDate());
					xs.endTag(null, "date");
					
					xs.startTag(null, "type");
					xs.text(sm.getType());
					xs.endTag(null, "type");
				
				
				xs.endTag(null, "sms");
			}
			
			xs.endTag(null, "messages");
			
			//写完成
			xs.endDocument();
			
			fos.close();
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			
		}
    }


  

}
