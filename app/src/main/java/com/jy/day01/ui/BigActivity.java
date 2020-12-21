package com.jy.day01.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.jy.day01.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BigActivity extends AppCompatActivity {

    @BindView(R.id.txt_return)
    TextView txtReturn;
    @BindView(R.id.txt_page)
    TextView txtPage;
    @BindView(R.id.txt_down)
    TextView txtDown;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private int currentPos;
    private ArrayList<String> urls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initData() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPos = position;
                txtPage.setText(currentPos + 1 + "/" + urls.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("data")) {
            Bundle data = intent.getBundleExtra("data");
            if (data != null) {
                urls = data.getStringArrayList("urls");
                currentPos = data.getInt("postion");
                txtPage.setText(currentPos + 1 + "/" + urls.size());
            }
        }

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return urls.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View view = LayoutInflater.from(BigActivity.this).inflate(R.layout.item_big, null);
                final ImageView mImg = view.findViewById(R.id.img);
                Glide.with(BigActivity.this).load(urls.get(position)).into(mImg);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });
        viewPager.setCurrentItem(currentPos);
    }

    @OnClick({R.id.txt_return, R.id.txt_down})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt_return:
                finish();
                break;
            case R.id.txt_down:
                break;
        }
    }
}