package com.maxiee.maxieerxlearning.ui.home;

import android.util.Log;

import io.reactivex.functions.Consumer;

/**
 * Created by WangRui on 2017/6/13.
 */

public class MainPresenter {
    private static final int TYPE_SECTION = 1;
    private static final int TYPE_BUTTON = 2;

    private MainActivity mActivity;

    ListItem[] mListItems = new ListItem[] {
            ListItem.create(TYPE_SECTION, "RxJava 学习"),
            ListItem.create(TYPE_SECTION, "RxBindings 学习"),
            ListItem.create(TYPE_BUTTON, "按钮点击实例", object -> Log.d("maxiee", "clicked!"))
    };

    public MainPresenter(MainActivity activity) {
        mActivity = activity;
    }

    public void onCreate() {
        for (ListItem l: mListItems) {
            if      (l.type == TYPE_SECTION) mActivity.createTitle(l.text);
            else if (l.type == TYPE_BUTTON) mActivity.createButton(l.text, l.mConsumer);
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
