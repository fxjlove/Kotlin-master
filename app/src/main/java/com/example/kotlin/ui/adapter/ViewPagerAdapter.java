package com.example.kotlin.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by zsc on 2018/8/23.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragments = null;
    private String[] mTitles= null;
    public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> mFragments, String[] mTitles) {
        super(fm);
        this.mFragments = mFragments;
        this.mTitles = mTitles;
    }
    @Override
    public int getCount() {
        return mFragments != null ? mFragments.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles != null ? mTitles[position] : "";
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments !=null ? mFragments.get(position) : null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //先 简单解决来回滑动fragment重新加载
//        super.destroyItem(container, position, object);
    }
}
