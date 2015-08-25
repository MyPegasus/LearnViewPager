package com.example.mypegasus.learnviewpager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by MyPegasus on 2015/8/25.
 */
public class WelcomeActivity extends Activity {

	private boolean isFirstIn;

	private static final int TIME = 2000;
	private static final int GO_HOME = 1000;
	private static final int GO_GUIDE = 1001;

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		init();
	}

	private void init() {
		SharedPreferences sf = getSharedPreferences("jike", MODE_PRIVATE);
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
		startActivity(new Intent(this, MainActivity.class));
		finish();
	}

	private void goGuide() {
		startActivity(new Intent(this, GuideActivity.class));
		finish();
	}
}
