package com.enping.customviewpager;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MyPagerAdapter();
        vp = (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(adapter);
        vp.setOffscreenPageLimit(adapter.getCount());
        vp.setClipChildren(false);
        vp.setPageTransformer(true,new DimTransformer());

    }

    private class MyPagerAdapter extends PagerAdapter {

        ArrayList<View> views = new ArrayList<>();

        public MyPagerAdapter() {
            for(int i=0;i<getCount();i++){
                View view = getLayoutInflater().inflate(R.layout.slip_item,null,false);
                views.add(view);
            }
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = views.get(position);
            container.addView(v);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }
    }
}
