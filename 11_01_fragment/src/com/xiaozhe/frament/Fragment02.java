package com.xiaozhe.frament;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment02 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//��䲼��Ϊview
		View v = inflater.inflate(R.layout.fragmentlayout02, null);
		return v;
	}
	
}
