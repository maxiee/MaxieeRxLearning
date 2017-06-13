package com.maxiee.maxieerxlearning.ui.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.maxiee.maxieerxlearning.R;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;

public class MainActivity extends AppCompatActivity {

    MainPresenter mMainPresenter;

    LinearLayout mMainContent;

    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainContent = (LinearLayout) findViewById(R.id.main_container);

        mMainPresenter = new MainPresenter(this);
        mMainPresenter.onCreate();
    }

    void createTitle(String title) {
        TextView titleView = new TextView(this);
        titleView.setText(title);
        titleView.setTextSize(16);
        mMainContent.addView(titleView, lp);
    }

    void createButton(String title, Consumer<Object> consumer) {
        Button button = new Button(this);
        button.setText(title);
        button.setGravity(Gravity.CENTER);
        mMainContent.addView(button, lp);
        RxView.clicks(button).subscribe(consumer);
    }
}
