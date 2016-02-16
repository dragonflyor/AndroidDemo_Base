package com.xiaozhe.jiamistring;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	static{
		System.loadLibrary("encode");
	}
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

      
    }
    
    public void onencode(View v){
    	System.out.println("����");
    	//����
    	EditText et = (EditText) findViewById(R.id.et);
    	String code = et.getText().toString();
    	//���ܺ����
    	et.setText(encodeString(code ,code.length()));
    }
    public void ondecode(View v){
    	System.out.println("����");
    	//����
    	EditText et = (EditText) findViewById(R.id.et);
    	String code = et.getText().toString();
    	//���ܺ����
    	et.setText(decodeString(code,code.length()));
    }

    /**
     * ����
     * @param code Ҫ���ܵ��ַ���
     * @param length Ҫ�����ַ����ĳ���
     * @return ���ܺ���ַ���
     */
    public native String encodeString( String code ,int length);
    /**
     * ����
     * @param code Ҫ���ܵ��ַ���
     * @param length Ҫ�����ַ����ĳ���
     * @return ���ܺ���ַ���
     */
    public native String decodeString( String code ,int length);

}
