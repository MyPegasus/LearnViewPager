package com.example.mypegasus.viewpagerfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by MyPegasus on 2015/8/26.
 */
public class PageThreeFragment extends Fragment {

	private Button btnStart;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//		return super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.page_three, container, false);
		btnStart = (Button) rootView.findViewById(R.id.btn_start);
		btnStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getActivity(), MainActivity.class));
				getActivity().finish();
			}
		});
		return rootView;
	}
}
