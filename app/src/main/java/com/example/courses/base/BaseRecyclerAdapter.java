package com.example.courses.base;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<V extends BaseViewHolder, T> extends RecyclerView.Adapter<V> {
    private List<T> data = new ArrayList<>();

    @NonNull
    @Override
    public V onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(getLayoutRes(), viewGroup, false);
        return getViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull V holder, int position) {
        holder.bind(getItemAt(position));
    }

    private T getItemAt(int position) {
        return data.get(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onViewRecycled(@NonNull V holder) {
        super.onViewRecycled(holder);
        holder.unbind();
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    protected abstract V getViewHolder(View view);

    public void update(List<T> newList) {
        this.data = newList;
        notifyDataSetChanged();
    }
}
