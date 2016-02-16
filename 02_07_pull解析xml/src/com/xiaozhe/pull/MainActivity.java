package com.xiaozhe.pull;

import java.io.InputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xioazhe.domain.Weather;

public class MainActivity extends Activity {
	//城市天气信息的集合
	ArrayList<Weather> weatherlist = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

     
    }
    
    @SuppressLint("ShowToast") 
    public void onclick(View v){
    	System.out.println("开始解析");
    	XmlPullParser xp = Xml.newPullParser();
    	
    	InputStream is = getClassLoader().getResourceAsStream("weather.xml");
    	try {
			xp.setInput(is, "utf-8");
			
			int type = xp.getEventType();
			Weather weather = null;
			//不是xml结尾
			while(type!=XmlPullParser.END_DOCUMENT){
				switch(type){
				//开始标签
				case XmlPullParser.START_TAG:
					if("weather".equals(xp.getName()))
					{
						weatherlist = new ArrayList<Weather>();
					}else if("city".equals(xp.getName())){
						weather=new Weather();
					}else if("name".equals(xp.getName())){
						String city = xp.nextText();
						weather.setCity(city);
					}else if("temp".equals(xp.getName())){
						String temp = xp.nextText();
						weather.setTemp(temp);
					}else if("pm".equals(xp.getName())){
						String pm = xp.nextText();
						weather.setPm(pm);;
					}
					break;
					
				case XmlPullParser.END_TAG:
					if("city".equals(xp.getName())){
						Log.i("onclick",weather.toString());
						weatherlist.add(weather);
					}
					break;
				}
				
				type = xp.next();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//输出解析结果
    	Toast.makeText(MainActivity.this, weatherlist.toString(), Toast.LENGTH_SHORT).show();
    	TextView bt = (TextView)findViewById(R.id.tv);
    	bt.setText("");
    	for (Weather w : weatherlist) {
    		System.out.println(w.toString());
    		bt.setText(bt.getText()+w.toString()+"\r\n");
			
		}
    	
    	
    }
    
    
}
