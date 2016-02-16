package com.xiaozhe.showListView;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.xiaozhe.bean.Person;

public class MainActivity extends Activity {
	ArrayList<Person> personList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        personList = new ArrayList<Person>();
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
        
//        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
//        //显示到页面
//        for (Person p : personList) {
//			TextView tv = new TextView(MainActivity.this);
//			
//			tv.setText(p.toString());
//			System.out.println(p.toString());
//			ll.addView(tv);
//		}
        
        
        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new MyListAdapter());

    }
    
    
   class  MyListAdapter extends BaseAdapter{

	@Override
	public int getCount() {
		return personList.size();
	}



	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
//		//创建条目
//		TextView tv = new TextView(MainActivity.this);
//		tv.setText(personList.get(position).toString());
//		Log.i("item_create","第"+position+"个条目被创建");
//		return tv;
		
		Log.i("item_create","第"+position+"个条目被创建");
		View v =null;
		if(convertView==null){
			Log.i("item_create","第"+position+"个条目被重新填充");
			v = View.inflate(MainActivity.this, R.layout.item_listview, null);
		}else{
			v = convertView;
		}
		
		TextView tv_name = (TextView) v.findViewById(R.id.tv_name);
		tv_name.setText(personList.get(position).getName());
		
		TextView tv_salary= (TextView) v.findViewById(R.id.tv_salary);
		tv_salary.setText(personList.get(position).getSalary());
		
		TextView tv_phone = (TextView) v.findViewById(R.id.tv_phone);
		tv_phone.setText(personList.get(position).getPhone());
		
		return v;
	}
	
	
	//
	
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	   
   }


  
}
