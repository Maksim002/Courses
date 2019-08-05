package com.example.courses.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.courses.R;
import com.example.courses.base.ViewPagerAdapter;
import com.example.courses.base.ViewPagerPageChaneListener;
import com.example.courses.main.category.CategoryFragment;
import com.example.courses.main.home.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViewPager();
        setupBottomNavigationView();
    }

    private void setupViewPager() {
        viewPager = findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.add(new HomeFragment());
        adapter.add(new CategoryFragment());
        viewPager.setAdapter(adapter);
    }

    private void setupBottomNavigationView() {
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);
        viewPager.addOnPageChangeListener(pageListener);
    }

    private OnNavigationItemSelectedListener listener = new OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.itemHome:
                    viewPager.setCurrentItem(0, true);
                    return true;
                case R.id.itemCategories:
                    viewPager.setCurrentItem(1, true);
                    return true;
            }
            return false;
        }
    };

    private ViewPagerPageChaneListener pageListener = new ViewPagerPageChaneListener() {
        @Override
        public void onPageScroll(int position, float v, int i1) {
            bottomNavigationView.getMenu().getItem(position).setChecked(true);
        }
    };
}
