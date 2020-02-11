package com.example.kotlin.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.ViewGroup
import java.util.ArrayList

class ViewPageAdapterKotlin(fm: FragmentManager, mFragments: ArrayList<Fragment> , mTitles: Array<String>) : FragmentPagerAdapter(fm) {
    private var mFragments = mFragments
    private var mTitles = mTitles
    override fun getCount(): Int {
        return if (mFragments != null) mFragments.size else 0
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return if (mTitles != null) mTitles[position] else ""
    }

    override fun getItem(position: Int): Fragment? {
        return if (mFragments != null) mFragments[position] else null
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        //先 简单解决来回滑动fragment重新加载
        //        super.destroyItem(container, position, object);
    }
}