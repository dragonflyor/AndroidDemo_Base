package com.xiaozhe.mycontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class PersonProvider extends ContentProvider {

	//URiƥ����
	static UriMatcher um ;
	static{
		um = new UriMatcher(UriMatcher.NO_MATCH);
		um.addURI("com.xiaozhe.tablepeople", "people", 1);
		um.addURI("com.xiaozhe.tablepeople", "teacher", 2);
	}
	
	private SQLiteDatabase database;

	@Override
	public boolean onCreate() {
		//���ӵ����ݿ�
		MySQLiteOpenHelper helper = new MySQLiteOpenHelper(getContext());
		database = helper.getWritableDatabase();
		return database!=null;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		Cursor cursor = database.query("people", null, selection, selectionArgs, null, null, sortOrder, null);
		return cursor;
		
		
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		//�������
		if(um.match(uri)==1){
			database.insert("people", null, values);
		}else if(um.match(uri)==2){
			database.insert("teacher", null, values);
		}else{
			throw new IllegalArgumentException("uri.match()��������");
		}
	
		
		return uri;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		//ɾ������
		int i = database.delete("people", selection, selectionArgs);
		return i;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		//�޸�����
		int i = database.update("people", values, selection, selectionArgs);
		return i;
	}

}
