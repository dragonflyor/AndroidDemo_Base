package com.xiaozhe.framentsenddata;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment01 extends Fragment {

	TextView tv_data;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		//Ìî³ä²¼¾ÖÎªview
		View v = inflater.inflate(R.layout.fragmentlayout01, null);
		
		tv_data = (TextView) v.findViewById(R.id.tv_frag1_data);
		return v;
	}
	
	public void setText(String text){
		tv_data.setText(text);
	}
	
}
