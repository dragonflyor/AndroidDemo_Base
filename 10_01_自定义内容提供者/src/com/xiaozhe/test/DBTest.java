package com.xiaozhe.test;

import com.xiaozhe.mycontentprovider.MySQLiteOpenHelper;

import android.test.AndroidTestCase;

public class DBTest extends AndroidTestCase {

	public void createTable(){
		MySQLiteOpenHelper helper = new MySQLiteOpenHelper(getContext());
		helper.getWritableDatabase();
	} 
}
