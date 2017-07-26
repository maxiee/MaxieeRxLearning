package com.maxiee.maxieerxlearning.tasks.tasks;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.jakewharton.rxbinding2.widget.RxCheckedTextView;
import com.maxiee.maxieerxlearning.R;
import com.maxiee.maxieerxlearning.tasks.data.Task;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by WangRui on 2017/7/26.
 */

public class TaskAdapter extends BaseAdapter {

    private List<Task> mTasks;
    private TaskItemListener mItemListener;

    public TaskAdapter(List<Task> tasks, TaskItemListener itemListener) {
        setList(tasks);
        mItemListener = itemListener;
    }

    public void replaceData(List<Task> tasks) {
        setList(tasks);
        notifyDataSetChanged();
    }

    private void setList(List<Task> tasks) {
        mTasks = checkNotNull(tasks);
    }

    @Override
    public int getCount() {
        return mTasks.size();
    }

    @Override
    public Task getItem(int position) {
        return mTasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View rowView = view;
        if (rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            rowView = inflater.inflate(R.layout.task_item, viewGroup, false);
        }

        final Task task = getItem(position);

        TextView titleTV = (TextView) rowView.findViewById(R.id.title);
        titleTV.setText(task.getTitleForList());

        CheckBox completeCB = (CheckBox) rowView.findViewById(R.id.complete);

        // Active/completed task UI
        completeCB.setChecked(task.isCompleted());
        if (task.isCompleted()) {
            rowView.setBackground(
                    ResourcesCompat.getDrawable(
                            viewGroup.getResources(),
                            R.drawable.list_completed_touch_feedback,
                            null));
        } else {
            rowView.setBackground(
                    ResourcesCompat.getDrawable(
                            viewGroup.getResources(),
                            R.drawable.touch_feedback,
                            null));
        }

        completeCB.setOnClickListener(__ -> {
            if (!task.isCompleted()) {
                mItemListener.onCompleteTaskClick(task);
            } else {
                mItemListener.onActivateTaskClick(task);
            }
        });

        rowView.setOnClickListener(__ -> mItemListener.onTaskClick(task));

        return rowView;
    }
}
