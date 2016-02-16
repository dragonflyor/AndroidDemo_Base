package com.xiaozhe.visiteprovider;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

       
    }
    
    public void oninsert(View v){
    	//获取内容解析器
    	ContentResolver cr = getContentResolver();
    	
    	ContentValues cv = new ContentValues();
    	cv .put("name", "肖哲");
    	cv .put("salary", 10000);
    	
    	String pathname ="content://com.xiaozhe.tablepeople/people";
    	cr.insert(Uri.parse(pathname), cv);
    	System.out.println("插入数据到：--->"+pathname);
    }

    public void onupdate(View v){
    	//获取内容解析器
    	ContentResolver cr = getContentResolver();
    	
    	ContentValues cv = new ContentValues();
    	cv .put("salary", 20000);
    	
    	String[] selectionArgs ={"肖哲"};
    	cr.update(Uri.parse("content://com.xiaozhe.tablepeople"), cv, "name=?", selectionArgs);
    }
    
    public void ondelete(View v){
    	//获取内容解析器
    	ContentResolver cr = getContentResolver();
    	
    	cr.delete(Uri.parse("content://com.xiaozhe.tablepeople"), "name=?", new String[]{"小哲"});
    }

    public void onquery(View v){
    	//获取内容解析器
    	ContentResolver cr = getContentResolver();
    	
    	ContentValues cv = new ContentValues();   	
    	Cursor cursor =cr.query(Uri.parse("content://com.xiaozhe.tablepeople"), null, null, null, null);
    	
    	//输出显示
    	while (cursor.moveToNext()) {
    		String name = cursor.getString(1);
    		String salary = cursor.getString(2);
			System.out.println(name+"-----"+salary);
			
		}
    }
    
    public void oninsert1(View v){
    	//获取内容解析器
    	ContentResolver cr = getContentResolver();
    	
    	ContentValues cv = new ContentValues();
    	cv .put("name", "肖哲88");
    	
    	String pathname ="content://com.xiaozhe.tablepeople/teacher";
    	cr.insert(Uri.parse(pathname), cv);
    	System.out.println("插入数据到：--->"+pathname);
    }

   
}
