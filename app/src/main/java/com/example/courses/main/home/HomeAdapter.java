package com.example.courses.main.home;

import android.view.View;

import com.example.courses.R;
import com.example.courses.base.BaseRecyclerAdapter;
import com.example.courses.model.Course;

public class HomeAdapter extends BaseRecyclerAdapter<CourseViewHolder, Course> {
    @Override
    protected int getLayoutRes() {
        return R.layout.item_course;
    }

    @Override
    protected CourseViewHolder getViewHolder(View view) {
        return new CourseViewHolder(view);
    }
}
