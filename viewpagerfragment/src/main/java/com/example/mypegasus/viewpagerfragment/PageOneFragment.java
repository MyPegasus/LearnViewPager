package com.example.mypegasus.viewpagerfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by MyPegasus on 2015/8/26.
 */
public class PageOneFragment extends Fragment {

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//		return super.onCreateView(inflater, container, savedInstanceState);
		return inflater.inflate(R.layout.page_one, container, false);
	}
}
