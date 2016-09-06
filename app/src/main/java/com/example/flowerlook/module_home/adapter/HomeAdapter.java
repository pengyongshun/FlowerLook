package com.example.flowerlook.module_home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * @Author:pengyongshun
 * @Desc:
 * @Time:2016/9/6
 */
public class HomeAdapter extends FragmentStatePagerAdapter{
    private List<Fragment> fragments;
    private List<String> titles;

    public HomeAdapter(FragmentManager fm,List<Fragment> fragments,List<String> titles) {
        super(fm);
        this.fragments=fragments;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments==null?0:fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles==null?null:titles.get(position);
    }
}
