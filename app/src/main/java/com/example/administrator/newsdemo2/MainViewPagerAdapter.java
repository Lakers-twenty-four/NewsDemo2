package com.example.administrator.newsdemo2;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/18 0018.
 */

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {
    private List<String> mTitles=new ArrayList<>();
    private List<Fragment> mfragmentsList=new ArrayList<>();
    public MainViewPagerAdapter(FragmentManager fragmentManager, List<String> titles, List<Fragment> fragmentsList) {
        super(fragmentManager);
        mfragmentsList=fragmentsList;
        mTitles=titles;
    }


    @Override
    public Fragment getItem(int position) {
        Log.i("Aaaa", mfragmentsList.get(position)+"");
        return mfragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return mfragmentsList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return mTitles.get(position);
    }
}
