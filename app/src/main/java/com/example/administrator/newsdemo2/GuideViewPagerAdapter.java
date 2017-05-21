package com.example.administrator.newsdemo2;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * Created by Administrator on 2017/5/16 0016.
 */

public class GuideViewPagerAdapter extends PagerAdapter{
    private List<View> views;
    private Context context;

    public GuideViewPagerAdapter(List<View> views, Context context){
        this.views=views;
        this.context=context;
    }

   //销毁不需要的view
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager)container).removeView(views.get(position));
    }

    //类似于ListView的getView,绑定View
    public Object instantiateItem(View container, int position) {
        ((ViewPager)container).addView(views.get(position));
        return views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }

    //判断当前的view是不是我们要的对象
    public boolean isViewFromObject(View view, Object object) {
        return (view==object);
    }
}
