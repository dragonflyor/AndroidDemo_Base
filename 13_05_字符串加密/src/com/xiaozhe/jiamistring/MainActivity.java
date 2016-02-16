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
    	System.out.println("加密");
    	//加密
    	EditText et = (EditText) findViewById(R.id.et);
    	String code = et.getText().toString();
    	//加密后回显
    	et.setText(encodeString(code ,code.length()));
    }
    public void ondecode(View v){
    	System.out.println("解密");
    	//解密
    	EditText et = (EditText) findViewById(R.id.et);
    	String code = et.getText().toString();
    	//解密后回显
    	et.setText(decodeString(code,code.length()));
    }

    /**
     * 加密
     * @param code 要加密的字符串
     * @param length 要加密字符串的长度
     * @return 加密后的字符串
     */
    public native String encodeString( String code ,int length);
    /**
     * 解密
     * @param code 要解密的字符串
     * @param length 要解密字符串的长度
     * @return 解密后的字符串
     */
    public native String decodeString( String code ,int length);

}
