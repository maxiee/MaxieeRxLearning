package com.maxiee.maxieerxlearning.demo.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by WangRui on 2017/7/6.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.ViewHolder> {

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
        holder.mButton.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return 100;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        Button mButton;

        public ViewHolder(Button button) {
            super(button);
            mButton = button;
        }
    }
}
