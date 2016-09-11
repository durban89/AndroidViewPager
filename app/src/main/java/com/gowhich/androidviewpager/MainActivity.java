package com.gowhich.androidviewpager;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PagerTitleStrip pagerTitle;
    private List<View> list;
    private List<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) this.findViewById(R.id.viewPager);
        pagerTitle = (PagerTitleStrip) this.findViewById(R.id.pagerTitle);

        View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.pager1, null);
        View view2 = LayoutInflater.from(MainActivity.this).inflate(R.layout.pager2, null);
        View view3 = LayoutInflater.from(MainActivity.this).inflate(R.layout.pager3, null);
        View view4 = LayoutInflater.from(MainActivity.this).inflate(R.layout.pager4, null);

        list = new ArrayList<View>();
        list.add(view1);
        list.add(view2);
        list.add(view3);
        list.add(view4);

        titleList = new ArrayList<String>();
        titleList.add("图片1");
        titleList.add("图片2");
        titleList.add("图片3");
        titleList.add("图片4");

        viewPager.setAdapter(new MyAdapter());
    }


    class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object);

            ((ViewPager)container).removeView(list.get(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
//            return super.getPageTitle(position);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager)container).addView(list.get(position));
            return list.get(position);
//            return super.instantiateItem(container, position);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}
