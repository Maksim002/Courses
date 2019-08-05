package com.example.courses.main.home;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.courses.R;
import com.example.courses.base.BaseViewHolder;
import com.example.courses.model.Course;

public class CourseViewHolder extends BaseViewHolder<Course> {
    private ImageView imageView;
    private TextView title;
    private TextView description;

    public CourseViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        title = itemView.findViewById(R.id.titleTextView);
        description = itemView.findViewById(R.id.descriptionTextView);
    }

    @Override
    protected void bind(Course item) {
        Glide.with(itemView)
                .load(item.getMainImageUrl())
                .into(imageView);
        title.setText(item.getTitle());
        description.setText(item.getDescription());
    }

    @Override
    protected void unbind() {
        Glide.with(itemView).clear(imageView);
    }
}
