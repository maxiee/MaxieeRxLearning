/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.maxiee.maxieerxlearning.tasks.tasks;

import android.support.annotation.NonNull;

import com.maxiee.maxieerxlearning.tasks.BasePresenter;
import com.maxiee.maxieerxlearning.tasks.BaseView;
import com.maxiee.maxieerxlearning.tasks.data.Task;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface TasksContract {

    interface View extends BaseView<Presenter> {

        /**
         * 设置加载控件
         * @param active
         */
        void setLoadingIndicator(boolean active);

        /**
         * 显示所有任务
         * @param tasks
         */
        void showTasks(List<Task> tasks);

        void showAddTask();

        void showTaskDetailsUi(String taskId);

        void showTaskMarkedComplete();

        void showTaskMarkedActive();

        void showCompletedTasksCleared();

        void showLoadingTasksError();

        void showNoTasks();

        void showActiveFilterLabel();

        void showCompletedFilterLabel();

        void showAllFilterLabel();

        void showNoActiveTasks();

        void showNoCompleteTasks();

        void showSuccessfullySavedMessage();

        boolean isActive();

        void showFilteringPopUpMenu();

    }

    interface Presenter extends BasePresenter {
        void result(int requestCode, int resultCode);

        void loadTasks(boolean forceUpdate);

        void addNewTask();

        void openTaskDetails(@NonNull Task requestedTask);

        void completeTask(@NonNull Task completedTask);

        void activateTask(@NonNull Task activeTask);

        void clearCompletedTasks();

        void setFiltering(TasksFilterType requestType);

        TasksFilterType getFiltering();
    }
}
