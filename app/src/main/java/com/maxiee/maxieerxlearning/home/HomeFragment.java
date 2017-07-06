package com.maxiee.maxieerxlearning.home;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.style.TextAppearanceSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.maxiee.maxieerxlearning.R;
import com.maxiee.maxieerxlearning.MainActivity;

import io.reactivex.functions.Consumer;

/**
 * Created by WangRui on 2017/6/13.
 */

public class HomeFragment extends Fragment {
    HomePresenter mHomePresenter;

    LinearLayout mMainContent;

    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, null);

        mMainContent = (LinearLayout) v.findViewById(R.id.main_container);

        mHomePresenter = new HomePresenter(this);
        mHomePresenter.onCreate();

        return v;
    }

    void createTitle(String title) {
        TextView titleView = new TextView(getContext());
        titleView.setText(title);
        titleView.setTextSize(20);
        titleView.setTextColor(Color.BLACK);
        mMainContent.addView(titleView, lp);
    }

    void createButton(String title, Consumer<Object> consumer) {
        Button button = new Button(getContext());
        button.setText(title);
        button.setGravity(Gravity.CENTER);
        mMainContent.addView(button, lp);
        RxView.clicks(button).subscribe(consumer);
    }

    MainActivity getMainActivity() {
        return (MainActivity) getActivity();
    }
}
