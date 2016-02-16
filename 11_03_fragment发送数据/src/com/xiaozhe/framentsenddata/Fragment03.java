package com.xiaozhe.framentsenddata;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Fragment03 extends Fragment {

	EditText  et_blue = null;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		
		//填充布局为view
		View v = inflater.inflate(R.layout.fragmentlayout03, null);
		et_blue = (EditText) v.findViewById(R.id.et_blue);
		Button send = (Button) v.findViewById(R.id.send);
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//调用MainActivity的方法
				String text = et_blue.getText().toString();
				((MainActivity)getActivity()).setText(text);
			}
		});
		
		
		return v;
	}
	
	
	
	
}
