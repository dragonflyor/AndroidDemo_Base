package com.xiaozhe.dialog;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        
        
        

    }
    
    
    public void onclick1(View v){
    	AlertDialog.Builder builder = new Builder(MainActivity.this);
    	
    	builder.setIcon(R.drawable.ic_launcher);
    	builder.setTitle("确认取消窗口");
    	builder.setMessage("程序好用吗？");
    	
    	builder.setPositiveButton("确认", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "谢谢支持！", 0).show();
			}
		});
    	
    	builder.setNegativeButton("取消", new OnClickListener() {
    		
    		@Override
    		public void onClick(DialogInterface dialog, int which) {
    			Toast.makeText(MainActivity.this, "我们会继续努力！", 0).show();
    		}
    	});
    	
//    	AlertDialog ad = builder.create();
//    	
//    	ad.show();
    	builder.show();
    }

    public void onclick2(View v){
    	AlertDialog.Builder builder = new Builder(MainActivity.this);
    	
    	builder.setIcon(R.drawable.ic_launcher);
    	builder.setTitle("请选择性别");
    	final String [] items = new String[]{"男","女"};
    	builder.setSingleChoiceItems(items, -1, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "选择的性别是："+items[which], 0).show();
				dialog.dismiss();
				
			}
		});
    	
    	builder.show();
    }
    
    public void onclick3(View v){
    	AlertDialog.Builder builder = new Builder(MainActivity.this);
    	
    	builder.setTitle("请选择你欣赏的人");
    	final String [] items = new String[]{"肖哲","小明","小李"};
    	final boolean[] checkedItems = new boolean[]{true,true,false};
    	
    	builder.setMultiChoiceItems(items, checkedItems, new OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				checkedItems[which] = isChecked;
				
			}
		});
    	
    	builder.setPositiveButton("确认", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				String text = "";
				for (int i = 0; i < checkedItems.length; i++) {
					
					if(checkedItems[i]){
							text+=items[i]+" ";
					}
					
				}
				
				Toast.makeText(MainActivity.this, "你欣赏的人是："+text, 0).show();
				dialog.dismiss();
				
			}
		});
    	
    	builder.show();
    }


}
