package com.example.kotlin.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.kotlin.R
import com.example.kotlin.ui.adapter.ViewPageAdapterKotlin
import com.example.kotlin.ui.fragment.ContactsMyFragment
import com.example.kotlin.ui.fragment.ContactsOrganizationalStructureFragment
import kotlinx.android.synthetic.main.activity_tab_layout.*
import java.util.ArrayList

/**
 * tab
 */
class TabLayoutActivity : AppCompatActivity() {

    private val mFragments = ArrayList<Fragment>()
    private val mTitles = arrayOf("我的联系人", "组织架构")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)


        initView()

        initData()

    }
    private fun initView(){


    }
    private fun initData(){
        mFragments.add(ContactsMyFragment())//我的联系人
        mFragments.add(ContactsOrganizationalStructureFragment())//组织架构

//        val adapter = ViewPagerAdapter(supportFragmentManager, mFragments, mTitles)
        val adapter = ViewPageAdapterKotlin(supportFragmentManager, mFragments, mTitles)
        view_pager.adapter = adapter
        sliding_tabLayout.setViewPager(view_pager, mTitles)

    }


}