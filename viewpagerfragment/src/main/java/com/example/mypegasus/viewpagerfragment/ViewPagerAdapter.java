package com.example.mypegasus.viewpagerfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by MyPegasus on 2015/8/26.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

	private List<Fragment> views;

	public ViewPagerAdapter(FragmentManager fm, List<Fragment> views) {
		super(fm);
		this.views = views;
	}

	@Override
	public Fragment getItem(int position) {
		return views.get(position);
	}

	@Override
	public int getCount() {
		return views.size();
	}
}
