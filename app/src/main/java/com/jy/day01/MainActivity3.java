package com.jy.day01;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.jy.day01.ui.fragment.ShopFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private ViewPager viewpager;
    private TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tablayout = (TabLayout) findViewById(R.id.tablayout);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new ShopFragment());
        fragments.add(new ShopFragment());
        fragments.add(new ShopFragment());
        fragments.add(new ShopFragment());
        fragments.add(new ShopFragment());

        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

        tablayout.setupWithViewPager(viewpager);

        tablayout.getTabAt(0).setText("首页").setIcon(R.drawable.selecter);
        tablayout.getTabAt(1).setText("专题").setIcon(R.drawable.selecter1);
        tablayout.getTabAt(2).setText("分类").setIcon(R.drawable.selecter2);
        tablayout.getTabAt(3).setText("购物车").setIcon(R.drawable.selecter3);
        tablayout.getTabAt(4).setText("我的").setIcon(R.drawable.selecter4);
    }
}