package com.maxiee.maxieerxlearning.home;

import android.content.Intent;

import com.maxiee.maxieerxlearning.demo.button.ButtonFragment;
import com.maxiee.maxieerxlearning.demo.recyclerview.RecyclerViewFragment;
import com.maxiee.maxieerxlearning.demo.viewpager.ViewPagerFragment;
import com.maxiee.maxieerxlearning.tasks.TasksActivity;

import io.reactivex.functions.Consumer;

/**
 * Created by WangRui on 2017/6/13.
 */

public class HomePresenter {
    private static final int TYPE_SECTION = 1;
    private static final int TYPE_BUTTON = 2;

    private HomeFragment mHomeFragment;

    ListItem[] mListItems = new ListItem[] {
            ListItem.create(
                    TYPE_SECTION,
                    "Android Architecture"),
            ListItem.create(
                    TYPE_BUTTON,
                    "todo-mvp-rxjava2-maxiee",
                    object -> {
                        Intent i = new Intent(mHomeFragment.getContext(), TasksActivity.class);
                        mHomeFragment.startActivity(i);
                    }),
            ListItem.create(
                    TYPE_SECTION,
                    "RxJava 学习"),
            ListItem.create(
                    TYPE_SECTION,
                    "RxBindings 学习"),
            ListItem.create(
                    TYPE_BUTTON,
                    "按钮点击实例",
                    object -> mHomeFragment.getMainActivity().openFragment(new ButtonFragment())),
            ListItem.create(
                    TYPE_SECTION,
                    "RxRecyclerView 学习"),
            ListItem.create(
                    TYPE_BUTTON,
                    "RxRecyclerView 实例",
                    object -> mHomeFragment.getMainActivity().openFragment(new RecyclerViewFragment())),
            ListItem.create(
                    TYPE_SECTION,
                    "RxViewPager 学习"),
            ListItem.create(
                    TYPE_BUTTON,
                    "RxViewPager 实例",
                    object -> mHomeFragment.getMainActivity().openFragment(new ViewPagerFragment()))
    };

    public HomePresenter(HomeFragment homeFragment) {
        mHomeFragment = homeFragment;
    }

    public void onCreate() {
        for (ListItem l: mListItems) {
            if      (l.type == TYPE_SECTION) mHomeFragment.createTitle(l.text);
            else if (l.type == TYPE_BUTTON) mHomeFragment.createButton(l.text, l.mConsumer);
        }
    }

    private static class ListItem {
        int type;
        String text;
        Consumer<Object> mConsumer;

        public ListItem(int type, String text) {
            this.type = type;
            this.text = text;
        }

        public ListItem(int type, String text, Consumer<Object> consumer) {
            this.type = type;
            this.text = text;
            this.mConsumer = consumer;
        }

        public static ListItem create(int type, String text) {
            return new ListItem(type, text);
        }

        public static ListItem create(int type, String text, Consumer<Object> consumer) {
            return new ListItem(type, text, consumer);
        }
    }
}
