package com.xiaozhe.framenttolowerversion;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment03 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//��䲼��Ϊview
		View v = inflater.inflate(R.layout.fragmentlayout03, null);
		return v;
	}
	
}
