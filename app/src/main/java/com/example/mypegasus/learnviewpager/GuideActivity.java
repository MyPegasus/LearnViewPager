package com.example.mypegasus.learnviewpager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPegasus on 2015/8/25.
 */
public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener {

	private ViewPager vp;
	private ViewPagerAdapter vpAdapter;
	private List<View> views;

	private ImageView[] points;
	private int[] pointIds = {R.id.iv1, R.id.iv2, R.id.iv3};

	private Button btnStart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		initViews();
		initPoints();
	}

	private void initViews() {
		LayoutInflater inflater = LayoutInflater.from(this);

		views = new ArrayList<View>();
		views.add(inflater.inflate(R.layout.page_one, null));
		views.add(inflater.inflate(R.layout.page_two, null));
		views.add(inflater.inflate(R.layout.page_three, null));

		vpAdapter = new ViewPagerAdapter(views, this);

		vp = (ViewPager) findViewById(R.id.viewpager);
		vp.setAdapter(vpAdapter);
//		vp.setOnPageChangeListener(this);//已过时，被废弃
		vp.addOnPageChangeListener(this);

		btnStart = (Button) views.get(2).findViewById(R.id.btn_start);
		btnStart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(GuideActivity.this, MainActivity.class));
				finish();
			}
		});
	}

	private void initPoints() {
		points = new ImageView[views.size()];
		for (int i = 0; i < views.size(); i++) {
			points[i] = (ImageView) findViewById(pointIds[i]);
		}
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
		System.out.println("onPageScrolled()...");
	}

	@Override
	public void onPageSelected(int position) {
		for (int i = 0; i < pointIds.length; i++) {
			if(position == i) {
				points[i].setImageResource(R.drawable.login_point_selected);
			} else {
				points[i].setImageResource(R.drawable.login_point);
			}
		}
		System.out.println("onPageSelected()...");
	}

	@Override
	public void onPageScrollStateChanged(int state) {
		System.out.println(state + " onPageScrollStateChanged()...");
	}
}
