package com.example.courses.main.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.courses.R;
import com.example.courses.base.BaseFragment;
import com.example.courses.model.Courses;
import com.example.courses.util.Util;
// https://mikescamell.com/shared-element-transitions-part-4-recyclerview/
public class HomeFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private HomeAdapter adapter;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView(view);
    }

    private Courses readJsonData() {
        String json = Util.loadJSONFromAsset(getContext(), "courses.json");
        return (Courses) Util.parseData(json);
    }

    private void setupRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter = new HomeAdapter());
        Courses courses = readJsonData();
        adapter.update(courses.getResults());
    }
}

/*
* Glide.with(getActivity())
     .load(args.getString(IMAGE_TO_SHOW))
     .listener(new RequestListener<String, GlideDrawable>() {
         @Override
         public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
             return false;
         }

         @Override
         public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
             progressBar.setVisibility(View.GONE);
             return false;
         }
     })
     .into(imageFrame)
;
* */