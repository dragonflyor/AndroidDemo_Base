package com.xiaozhe.insertcontacter;

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
    
    public void onclick(View v){
    	
    	//1 在raw_contacts查找_id的下标志
    	ContentResolver cr = getContentResolver();
    	Cursor cursorId = cr.query(Uri.parse("content://com.android.contacts/raw_contacts"), new String[]{"_id"}, null, null, null);
    	int contact_id = 1;
    	if(cursorId.moveToLast()){
    		int _id = cursorId.getInt(0);
    		//得到插入联系人的contact_id,_id会自加
    		contact_id = _id+1;
    	}
    	//2  在raw_contacts中插入contact_id
    	ContentValues values = new ContentValues();
    	values.put("contact_id", contact_id);
    	cr.insert(Uri.parse("content://com.android.contacts/raw_contacts"), values);
    	
    	//3 向data表 插入data1,mimetype，raw_contact_id 字段
    	values.clear();
    	values.put("data1", "肖哲");
    	values.put("raw_contact_id", contact_id);
    	values.put("mimetype", "vnd.android.cursor.item/name");
    	cr.insert(Uri.parse("content://com.android.contacts/data"), values);
    	
    	values.clear();
    	values.put("data1", "1137@qq.com");
    	values.put("raw_contact_id", contact_id);
    	values.put("mimetype", "vnd.android.cursor.item/email_v2");
    	cr.insert(Uri.parse("content://com.android.contacts/data"), values);
    	
    	
    	
    }



}
