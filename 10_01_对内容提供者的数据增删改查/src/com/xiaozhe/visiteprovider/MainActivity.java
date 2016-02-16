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
    	//��ȡ���ݽ�����
    	ContentResolver cr = getContentResolver();
    	
    	ContentValues cv = new ContentValues();
    	cv .put("name", "Ф��");
    	cv .put("salary", 10000);
    	
    	String pathname ="content://com.xiaozhe.tablepeople/people";
    	cr.insert(Uri.parse(pathname), cv);
    	System.out.println("�������ݵ���--->"+pathname);
    }

    public void onupdate(View v){
    	//��ȡ���ݽ�����
    	ContentResolver cr = getContentResolver();
    	
    	ContentValues cv = new ContentValues();
    	cv .put("salary", 20000);
    	
    	String[] selectionArgs ={"Ф��"};
    	cr.update(Uri.parse("content://com.xiaozhe.tablepeople"), cv, "name=?", selectionArgs);
    }
    
    public void ondelete(View v){
    	//��ȡ���ݽ�����
    	ContentResolver cr = getContentResolver();
    	
    	cr.delete(Uri.parse("content://com.xiaozhe.tablepeople"), "name=?", new String[]{"С��"});
    }

    public void onquery(View v){
    	//��ȡ���ݽ�����
    	ContentResolver cr = getContentResolver();
    	
    	ContentValues cv = new ContentValues();   	
    	Cursor cursor =cr.query(Uri.parse("content://com.xiaozhe.tablepeople"), null, null, null, null);
    	
    	//�����ʾ
    	while (cursor.moveToNext()) {
    		String name = cursor.getString(1);
    		String salary = cursor.getString(2);
			System.out.println(name+"-----"+salary);
			
		}
    }
    
    public void oninsert1(View v){
    	//��ȡ���ݽ�����
    	ContentResolver cr = getContentResolver();
    	
    	ContentValues cv = new ContentValues();
    	cv .put("name", "Ф��88");
    	
    	String pathname ="content://com.xiaozhe.tablepeople/teacher";
    	cr.insert(Uri.parse(pathname), cv);
    	System.out.println("�������ݵ���--->"+pathname);
    }

   
}
