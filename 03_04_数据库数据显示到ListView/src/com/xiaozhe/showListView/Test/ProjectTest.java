package com.xiaozhe.showListView.Test;

import com.xiaozhe.showListView.MySQLiteOpenHelper;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

public class ProjectTest extends AndroidTestCase {
	MySQLiteOpenHelper op;
	SQLiteDatabase db;
	
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		op = new MySQLiteOpenHelper(getContext(),"people.db",null,1);
		db = op.getWritableDatabase();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		db.close();
	}
	
	//用API操作数据库
	//添加
	public void apiinsert(){
		for (int i = 0; i < 50; i++) {
			
			ContentValues values = new ContentValues();
			values.put("name", "游天龙"+i);
			values.put("salary", "100"+i+i);
			values.put("phone", 1000+i);
			
			db.insert("person", null, values);
		}
	}
}
