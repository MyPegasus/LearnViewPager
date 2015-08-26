package com.example.mypegasus.viewpagerfragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {


	private boolean isFirstIn;

	private static final int TIME = 2000;
	private static final int GO_HOME = 1000;
	private static final int GO_GUIDE = 1001;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.fragment_welcome, container, false);
		init();
		return rootView;
	}

	private Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
//			super.handleMessage(msg);
			switch (msg.what) {
				case GO_HOME:
					goHome();
					break;
				case GO_GUIDE:
					goGuide();
					break;
			}
		}
	};

	private void init() {
		SharedPreferences sf = getActivity().getSharedPreferences("jike", Context.MODE_PRIVATE);
		isFirstIn = sf.getBoolean("isFirstIn", true);
		if (!isFirstIn) {
			mHandler.sendEmptyMessageDelayed(GO_HOME, TIME);
		} else {
			mHandler.sendEmptyMessageDelayed(GO_GUIDE, TIME);
			SharedPreferences.Editor editor = sf.edit();
			editor.putBoolean("isFirstIn", false);
			editor.commit();
		}
	}

	private void goHome() {
		startActivity(new Intent(getActivity(), MainActivity.class));
		getActivity().finish();
	}

	private void goGuide() {
		getFragmentManager().beginTransaction().replace(R.id.fragment, new GuideFragment()).commit();
	}

}
