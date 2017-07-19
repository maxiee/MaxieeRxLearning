package com.maxiee.maxieerxlearning.demo.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by WangRui on 2017/7/6.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

    private List<String> mData;

    public SimpleAdapter() {
        mData = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            mData.add(String.valueOf(i));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Button button = new Button(parent.getContext());
        button.setLayoutParams(new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(button);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mButton.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public boolean replaceItem(int index, String newString) {
        if (index < 0 || index >= getItemCount()) {
            return false;
        }

        mData.set(index, newString);
        return true;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        Button mButton;

        public ViewHolder(Button button) {
            super(button);
            mButton = button;
            mButton.setTag(this);
        }
    }
}
