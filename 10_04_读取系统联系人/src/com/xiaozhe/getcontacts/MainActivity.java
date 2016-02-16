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
	   System.out.println("��ѯ��ϵ��");
	   ContentResolver cr = getContentResolver();
	   //1������ϵ������id
	   Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
	   
	   
	   Cursor cs_contactid = cr.query(uri, new String[]{"contact_id"}, null, null, null);
	   while(cs_contactid.moveToNext()){
		   
		  // System.out.println("contact_id:"+cs_contactid.getString(0));
		 //��ȡ������ϵ��id----contact_id
		   String contact_id = cs_contactid.getString(0);
		   
		   //����id�� data�����������
		   Cursor cs = cr.query(Uri.parse("content://com.android.contacts/data"), new String[]{
				   "data1","mimetype"
		   }, "contact_id=?",new String[]{contact_id}, null);
		   
		   //����bean
		   Contacter contacter = new Contacter();
		   //���������ݴ�ŵ�bean
		   while(cs.moveToNext()){
			   String data1 =cs.getString(cs.getColumnIndex("data1"));
			   String mimetype =cs.getString(cs.getColumnIndex("mimetype"));
			   
			   if("vnd.android.cursor.item/email_v2".equals(mimetype)){
				  //����
				   contacter.setEmail(data1);
			   }
			   else if("vnd.android.cursor.item/name".equals(mimetype)){
				   //����
				   contacter.setName(data1);
			   }
			   else if("vnd.android.cursor.item/phone_v2".equals(mimetype)){
				   //�绰
				   contacter.setPhone(data1);
			   }
		   }
		   //��ʾ������̨
		   System.out.println(contacter.toString());
	   }
	   
   }
}
