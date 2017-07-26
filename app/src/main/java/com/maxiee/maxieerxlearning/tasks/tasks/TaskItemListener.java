package com.maxiee.maxieerxlearning.tasks.tasks;

import com.maxiee.maxieerxlearning.tasks.data.Task;

/**
 * Created by WangRui on 2017/7/26.
 */

public interface TaskItemListener {

    void onTaskClick(Task clickedTask);

    void onCompleteTaskClick(Task completedTask);

    void onActivateTaskClick(Task activatedTask);
}
