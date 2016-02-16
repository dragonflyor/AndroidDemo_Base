package com.xiaozhe.sqliteDemo.Test;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.xiaozhe.sqliteDemo.MySQLiteOpenHelper;

public class Test extends AndroidTestCase {
	
	MySQLiteOpenHelper op;
	SQLiteDatabase db;
	
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		op = new MySQLiteOpenHelper(getContext(),"people.db",null,4);
		db = op.getWritableDatabase();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		db.close();
	}

	public void createTest(){

	}
	
	public void insertTest(){
		
		db.execSQL("insert into person(name,salary,phone) values(?,?,?)",new Object[]{"С־1","13222",1332224});
		db.execSQL("insert into person(name,salary,phone) values(?,?,?)",new Object[]{"С־2","13222",1332224});
		db.execSQL("insert into person(name,salary,phone) values(?,?,?)",new Object[]{"С־�Ķ���","14666",1332224});
	
	}
	public void deleteTest(){
		
		db.execSQL("delete from person where name=?", new Object[]{"С־1"});

	}
	
	public void updateTest(){
		db.execSQL("update person set phone = ? where name = ?", new Object[]{88888,"С־�Ķ���"});
	}
	
	public void queryTest(){
		Cursor cursor = db.rawQuery("select name ,salary from person ", null);
		while(cursor.moveToNext()){
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String salary = cursor.getString(cursor.getColumnIndex("salary"));
			
			System.out.println(name+"----"+salary);
		}

	}
	
	//��API�������ݿ�
	//���
	public void apiinsert(){
		ContentValues values = new ContentValues();
		values.put("name", "������");
		values.put("phone", 10086);
		values.put("salary", "10070");
		
		db.insert("person", null, values);
	}
	
	//�޸�
	public void apiupdate(){
		ContentValues values = new ContentValues();
		values.put("salary", "26008");
		int i=db.update("person", values, "name = ?", new String[]{"������"});
		System.out.println("���޸ĵ�������"+i);
	}
	
	//ɾ��
	public void apidelete(){
		int i = db.delete("person", "_id=?",new String[]{"6"});
		System.out.println("��ɾ����������"+i);
	}
	
	//��ѯ
	public void apiquery(){
		Cursor cursor = db.query("person", null, null, null, null, null, null, null);
		
		while(cursor.moveToNext()){
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String salary = cursor.getString(cursor.getColumnIndex("salary"));
			String phone = cursor.getString(cursor.getColumnIndex("phone"));
			
			
			System.out.println(name+"--"+salary+"--"+phone);
		}
	}
	
	//����
	public void transaction(){
	
		try{
			
			db.beginTransaction();
			
			ContentValues values = new ContentValues();
			values.put("salary", "5000");
			db.update("person", values, "name = ?", new String[]{"С־"});
			
			values.clear();
			values.put("salary", "20000");
			db.update("person", values, "name = ?", new String[]{"С־�Ķ���"});
			
			//int i = 2/0;
			db.setTransactionSuccessful();
		}finally{
			db.endTransaction();
		}
		
	}
	
	

}
