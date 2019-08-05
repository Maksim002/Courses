package com.example.courses.main.category;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.courses.R;
import com.example.courses.base.BaseFragment;

public class CategoryFragment extends BaseFragment {
    @Override
    public int getLayoutRes() {
        return R.layout.fragment_category;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
