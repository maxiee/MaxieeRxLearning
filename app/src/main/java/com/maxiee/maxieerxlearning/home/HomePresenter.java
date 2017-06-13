package com.maxiee.maxieerxlearning.home;

import android.util.Log;

import com.maxiee.maxieerxlearning.demo.button.ButtonFragment;

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
                    "RxJava 学习"),
            ListItem.create(
                    TYPE_SECTION,
                    "RxBindings 学习"),
            ListItem.create(
                    TYPE_BUTTON,
                    "按钮点击实例",
                    object -> mHomeFragment.getMainActivity().openFragment(new ButtonFragment())),
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
