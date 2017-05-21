package com.example.administrator.newsdemo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/16 0016.
 */

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    private ViewPager viewPager;
    private List<View> views;
    private GuideViewPagerAdapter viewPagerAdapter;
    private int[]imgsId={R.id.point1,R.id.point2,R.id.point3};
    private ImageView[]dots;
    private TextView start_tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        SpTools.setIsFristRun(this,false);
        initView();
        initDots();

        //添加回调
        viewPager.setOnPageChangeListener(this);
    }

    private void initDots() {
        dots=new ImageView[views.size()];
        for (int i = 0; i < views.size(); i++) {
            dots[i]= (ImageView) findViewById(imgsId[i]);
        }
    }

    private void initView() {
        viewPager= (ViewPager) findViewById(R.id.viewPager);

        LayoutInflater inflater=LayoutInflater.from(this);

        views=new ArrayList<View>();

        views.add(inflater.inflate(R.layout.view_guide1,null));
        views.add(inflater.inflate(R.layout.view_guide2,null));
        views.add(inflater.inflate(R.layout.view_guide3,null));

        viewPagerAdapter=new GuideViewPagerAdapter(views,this);
        viewPager.setAdapter(viewPagerAdapter);


        start_tv= (TextView) views.get(2).findViewById(R.id.start_tv);
        start_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this,MainActivity.class));
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < imgsId.length; i++) {
            if(position==i){
                dots[i].setImageResource(R.drawable.login_point_selected);
            }else{
                dots[i].setImageResource(R.drawable.login_point);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
