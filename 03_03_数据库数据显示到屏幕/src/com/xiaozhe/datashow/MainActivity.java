package com.xiaozhe.datashow;

import java.util.ArrayList;

import com.xiaozhe.bean.Person;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        ArrayList<Person> personList = new ArrayList<Person>();
        //获取数据库
        MySQLiteOpenHelper oh = new MySQLiteOpenHelper(this, "people.db", null, 1);
        SQLiteDatabase db = oh.getWritableDatabase();
        
        
        Cursor cursor = db.query("person", null, null, null, null, null, null, null);
        
       //获取数据封装到集合
       
        while(cursor.moveToNext()){
        	String _id  = cursor.getString(0);
        	String name  = cursor.getString(1);
        	String salary  = cursor.getString(2);
        	String phone = cursor.getString(3);
        	System.out.println("name："+name);
        	
        	Person person = new Person();
        	person.setAll(_id, name, salary, phone);
        	
        	personList.add(person);
        }
        
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        //显示到页面
        for (Person p : personList) {
			TextView tv = new TextView(MainActivity.this);
			
			tv.setText(p.toString());
			System.out.println(p.toString());
			ll.addView(tv);
		}

    }


  
}
