package com.example.courses.base;

import android.support.v4.view.ViewPager;

public abstract class ViewPagerPageChaneListener implements ViewPager.OnPageChangeListener {
    @Override
    public void onPageScrolled(int i, float v, int i1) {
        onPageScroll(i, v, i1);
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    public abstract void onPageScroll(int i, float v, int i1);
}
