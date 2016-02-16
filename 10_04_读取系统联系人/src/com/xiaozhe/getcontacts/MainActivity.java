package com.xiaozhe.getcontacts;

import com.xiaozhe.getcontacts.bean.Contacter;

import android.app.Activity;
import android.content.ContentResolver;
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
	   System.out.println("查询联系人");
	   ContentResolver cr = getContentResolver();
	   //1查找联系人索引id
	   Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
	   
	   
	   Cursor cs_contactid = cr.query(uri, new String[]{"contact_id"}, null, null, null);
	   while(cs_contactid.moveToNext()){
		   
		  // System.out.println("contact_id:"+cs_contactid.getString(0));
		 //读取所有联系人id----contact_id
		   String contact_id = cs_contactid.getString(0);
		   
		   //根据id在 data表里面查数据
		   Cursor cs = cr.query(Uri.parse("content://com.android.contacts/data"), new String[]{
				   "data1","mimetype"
		   }, "contact_id=?",new String[]{contact_id}, null);
		   
		   //创建bean
		   Contacter contacter = new Contacter();
		   //读出的数据存放到bean
		   while(cs.moveToNext()){
			   String data1 =cs.getString(cs.getColumnIndex("data1"));
			   String mimetype =cs.getString(cs.getColumnIndex("mimetype"));
			   
			   if("vnd.android.cursor.item/email_v2".equals(mimetype)){
				  //邮箱
				   contacter.setEmail(data1);
			   }
			   else if("vnd.android.cursor.item/name".equals(mimetype)){
				   //姓名
				   contacter.setName(data1);
			   }
			   else if("vnd.android.cursor.item/phone_v2".equals(mimetype)){
				   //电话
				   contacter.setPhone(data1);
			   }
		   }
		   //显示到控制台
		   System.out.println(contacter.toString());
	   }
	   
   }
}
