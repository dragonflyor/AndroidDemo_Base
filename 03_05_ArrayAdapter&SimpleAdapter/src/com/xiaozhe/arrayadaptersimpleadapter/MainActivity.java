package com.xiaozhe.arrayadaptersimpleadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        
    
//        ListView lv = (ListView) findViewById(R.id.lv);
//        
//        String [] objects = {"小王","小李","小张"};
//        
//        lv.setAdapter(new ArrayAdapter<String>(this, R.layout.items_listview, R.id.tv_name, objects));
        
      ListView lv = (ListView) findViewById(R.id.lv);  
      String [] objects = {"小王","小李","小张"};
      
      List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
      
      Map<String,Object> map1 = new HashMap<String, Object>();
      map1.put("name", "小王");
      map1.put("photo", R.drawable.p1);
      data.add(map1);
      
      Map<String,Object> map2 = new HashMap<String, Object>();
      map2.put("name", "小222");
      map2.put("photo", R.drawable.p2);
      data.add(map2);
      
      Map<String,Object> map3 = new HashMap<String, Object>();
      map3.put("name", "小333");
      map3.put("photo", R.drawable.p3);
      data.add(map3);
      
      lv.setAdapter(new SimpleAdapter(this, data, R.layout.items_listview, new String[]{"name","photo"}, new int[]{R.id.tv_name,R.id.iv}));

       
    }


   
}
