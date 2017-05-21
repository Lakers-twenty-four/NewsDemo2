package com.example.administrator.newsdemo2;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragmentsList=new ArrayList<>();
    private List<String> titles=new ArrayList<>();
    private MainViewPagerAdapter mainViewPagerAdapter;
    private DrawerLayout drawer_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initFragment();

        initPlay();

    }

    private void initView() {

        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        viewPager= (ViewPager) findViewById(R.id.viewPager);


        drawer_layout= (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar  toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
                actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.home_img);
        }

    }


    private void initData() {
        titles = new ArrayList<>();
        titles.add("头条");
        titles.add("社会");
        titles.add("国内");
        titles.add("娱乐");
        titles.add("体育");
        titles.add("军事");
        titles.add("科技");
        titles.add("财经");
        titles.add("时尚");


        for(int i=0;i<titles.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(titles.get(i)));
        }

    }

    private void initFragment() {
        fragmentsList= new ArrayList<>();
        mFragment f1 = new mFragment();
        Bundle bundle1=new Bundle();
        bundle1.putInt("NEWTYPE",1);
        f1.setArguments(bundle1);


        mFragment f2 = new mFragment();
        Bundle bundle2=new Bundle();
        bundle2.putInt("NEWTYPE",2);
        f2.setArguments(bundle2);


        mFragment f3 = new mFragment();
        Bundle bundle3=new Bundle();
        bundle3.putInt("NEWTYPE",3);
        f3.setArguments(bundle3);


        mFragment f4 = new mFragment();
        Bundle bundle4=new Bundle();
        bundle4.putInt("NEWTYPE",1);
        f4.setArguments(bundle4);


        mFragment f5 = new mFragment();
        Bundle bundle5=new Bundle();
        bundle5.putInt("NEWTYPE",5);
        f5.setArguments(bundle5);


        mFragment f6 = new mFragment();
        Bundle bundle6=new Bundle();
        bundle6.putInt("NEWTYPE",6);
        f6.setArguments(bundle6);


        mFragment f7 = new mFragment();
        Bundle bundle7=new Bundle();
        bundle7.putInt("NEWTYPE",7);
        f7.setArguments(bundle7);


        mFragment f8 = new mFragment();
        Bundle bundle8=new Bundle();
        bundle8.putInt("NEWTYPE",8);
        f8.setArguments(bundle8);


        mFragment f9 = new mFragment();
        Bundle bundle9=new Bundle();
        bundle9.putInt("NEWTYPE",9);
        f9.setArguments(bundle9);


        fragmentsList.add(f1);
        fragmentsList.add(f2);
        fragmentsList.add(f3);
        fragmentsList.add(f4);
        fragmentsList.add(f5);
        fragmentsList.add(f6);
        fragmentsList.add(f7);
        fragmentsList.add(f8);
        fragmentsList.add(f9);

}

    private void initPlay() {

        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), titles, fragmentsList);
        //给ViewPager设置适配器
        viewPager.setAdapter(mainViewPagerAdapter);
        //将TabLayout和ViewPager关联起来。
        tabLayout.setupWithViewPager(viewPager);
        //给TabLayout设置适配器
        tabLayout.setTabsFromPagerAdapter(mainViewPagerAdapter);
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }


}
