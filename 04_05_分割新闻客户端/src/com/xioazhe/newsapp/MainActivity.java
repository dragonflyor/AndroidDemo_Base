package com.xioazhe.newsapp;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.loopj.android.image.SmartImageView;
import com.xioazhe.newsapp.domain.News;

public class MainActivity extends Activity {

	ArrayList<News> newsList =null;
	
	
	Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			ListView lv = (ListView) findViewById(R.id.lv);
			lv.setAdapter(new MyListViewAdapter());
		};
	};

	class MyListViewAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return newsList.size();
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View v = null;
			ViewHolder mholder=null;
			//从缓存中拿取
			if(convertView==null){
				v = View.inflate(MainActivity.this, R.layout.items_listview, null);
				mholder = new ViewHolder();
			
				mholder.tv_title = (TextView) v.findViewById(R.id.tv_title);
				mholder.tv_detail = (TextView) v.findViewById(R.id.tv_detail);
				mholder.tv_comment = (TextView) v.findViewById(R.id.tv_comment);
				mholder.siv = (SmartImageView) v.findViewById(R.id.siv);
				v.setTag(mholder);
			}else{
				v=convertView;
				mholder = (ViewHolder) v.getTag();
			}

			mholder.tv_title.setText(newsList.get(position).getTitle());
			mholder.tv_detail.setText(newsList.get(position).getDetail());
			mholder.tv_comment.setText(newsList.get(position).getComment());
			mholder.siv.setImageUrl(newsList.get(position).getImage());
			
			
			return v;
		}
		
		class ViewHolder{

			TextView tv_title;
			TextView tv_detail;
			TextView tv_comment;
			SmartImageView siv;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

	
		
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        getNews();
      
    }
    
    
    public void getNews(){
    	final String path = "http://172.26.164.3:8080/news.xml";
    	
    	Thread thread = new Thread(){
    		@Override
    		public void run() {
    			try {
    	    		URL url = new URL(path);
    				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    				
    				//设置conn
    				conn.setRequestMethod("GET");
    				conn.setConnectTimeout(5000);
    				conn.setReadTimeout(5000);
    				
    				//链接并且得到请求
    				if(conn.getResponseCode()==200){
    					//获取流 ，直接解析
    					InputStream is = conn.getInputStream();
    					parseXmlTobean(is);
    					
    				
    				}else{
    					
    				}
    				
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    		}
    	};
    	thread.start();
    	
    	
    	
    }
    
    public void parseXmlTobean(InputStream is){
    	XmlPullParser xp = Xml.newPullParser();
    	try {
			xp.setInput(is, "utf-8");
			int type = xp.getEventType();
			News news =null;
			while(type!=XmlPullParser.END_DOCUMENT){
				switch(type){
				case XmlPullParser.START_TAG:
					if("newslist".equals(xp.getName())){
						//创建集合
						newsList= new ArrayList<News>();
					}else if("news".equals(xp.getName())){
						//创建news对象
						news = new News();
						
					}else if("title".equals(xp.getName())){
						news.setTitle(xp.nextText());
						
					}else if("detail".equals(xp.getName())){
						news.setDetail(xp.nextText());
						
					}else if("comment".equals(xp.getName())){
						news.setComment(xp.nextText());
					}else if("image".equals(xp.getName())){
						news.setImage(xp.nextText());
					}
					break;
					
				case XmlPullParser.END_TAG:
					if("news".equals(xp.getName())){
						//创建news对象
						newsList.add(news);
						
					}
					break;
				}
				
				type = xp.next();
			}
			
			//发送消息
			handler.sendEmptyMessage(1);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	//打印输出
    	for (News n : newsList) {
    		System.out.println(n.toString());
		}
    	
    }


   
}
