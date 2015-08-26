package com.example.mypegasus.viewpagerfragment;


import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GuideFragment extends Fragment implements ViewPager.OnPageChangeListener {


	private ViewPager vp;
	private FragmentPagerAdapter fpAdapter;
	private List<Fragment> views;

	private List<ImageView> dots;
	private int[] dotIds = {R.id.iv1, R.id.iv2, R.id.iv3};

	public GuideFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.fragment_guide, container, false);
		vp = (ViewPager) rootView.findViewById(R.id.viewpager);
		initViews(inflater);
		initDots(rootView);
		return rootView;
	}

	private void initViews(LayoutInflater inflater) {
		views = new ArrayList<Fragment>();
		views.add(new PageOneFragment());
		views.add(new PageTwoFragment());
		PageThreeFragment threeFragment = new PageThreeFragment();
		views.add(threeFragment);

		fpAdapter = new ViewPagerAdapter(getFragmentManager(), views);
		vp.setAdapter(fpAdapter);
		vp.addOnPageChangeListener(this);
	}

	private void initDots(View rootView) {
		dots = new ArrayList<ImageView>();
		for (int i = 0; i < views.size(); i++) {
			dots.add((ImageView) rootView.findViewById(dotIds[i]));
		}
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

	}

	@Override
	public void onPageSelected(int position) {
		for (int i = 0; i < dotIds.length; i++) {
			if(position == i) {
				dots.get(i).setImageResource(R.drawable.login_point_selected);
			} else {
				dots.get(i).setImageResource(R.drawable.login_point);
			}
		}
	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}
}
