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
    	builder.setTitle("ȷ��ȡ������");
    	builder.setMessage("���������");
    	
    	builder.setPositiveButton("ȷ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "лл֧�֣�", 0).show();
			}
		});
    	
    	builder.setNegativeButton("ȡ��", new OnClickListener() {
    		
    		@Override
    		public void onClick(DialogInterface dialog, int which) {
    			Toast.makeText(MainActivity.this, "���ǻ����Ŭ����", 0).show();
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
    	builder.setTitle("��ѡ���Ա�");
    	final String [] items = new String[]{"��","Ů"};
    	builder.setSingleChoiceItems(items, -1, new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "ѡ����Ա��ǣ�"+items[which], 0).show();
				dialog.dismiss();
				
			}
		});
    	
    	builder.show();
    }
    
    public void onclick3(View v){
    	AlertDialog.Builder builder = new Builder(MainActivity.this);
    	
    	builder.setTitle("��ѡ�������͵���");
    	final String [] items = new String[]{"Ф��","С��","С��"};
    	final boolean[] checkedItems = new boolean[]{true,true,false};
    	
    	builder.setMultiChoiceItems(items, checkedItems, new OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				checkedItems[which] = isChecked;
				
			}
		});
    	
    	builder.setPositiveButton("ȷ��", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				String text = "";
				for (int i = 0; i < checkedItems.length; i++) {
					
					if(checkedItems[i]){
							text+=items[i]+" ";
					}
					
				}
				
				Toast.makeText(MainActivity.this, "�����͵����ǣ�"+text, 0).show();
				dialog.dismiss();
				
			}
		});
    	
    	builder.show();
    }


}
