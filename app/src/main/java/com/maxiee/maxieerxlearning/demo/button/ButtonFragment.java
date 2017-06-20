package com.maxiee.maxieerxlearning.demo.button;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxCompoundButton;
import com.maxiee.maxieerxlearning.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * Created by WangRui on 2017/6/13.
 */

public class ButtonFragment extends Fragment {
    @BindView(R.id.normal_click_button)
    Button mNormalClickButton;

    @BindView(R.id.normal_click_textview)
    TextView mNormalClickTextView;

    @BindView(R.id.long_click_button)
    Button mLongClickButton;

    @BindView(R.id.long_click_textview)
    TextView mLongClickTextView;

    @BindView(R.id.throttle_click_button)
    Button mThrottleClickButton;

    @BindView(R.id.throttle_click_textview)
    TextView mThrottleTextView;

    @BindView(R.id.check_enable)
    CheckBox mCheckEnable;

    @BindView(R.id.check_button)
    Button mCheckButton;

    @BindView(R.id.check_textview)
    TextView mCheckTextView;

    @BindView(R.id.homebrew_button)
    Button mHomeBrewButton;

    @BindView(R.id.homebrew_textview)
    TextView mHomeBrewTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_button, null);
        ButterKnife.bind(this, v);

        buttonNormalClick();
        buttonLongClick();
        buttonThrottleClick();
        buttonCheck();
        buttonHomeBrewClick();

        return v;
    }

    /**
     * Normal Click
     */
    private void buttonNormalClick() {
        RxView.clicks(mNormalClickButton).subscribe(
                Object -> mNormalClickTextView.setText(
                        "Clicked at " + System.currentTimeMillis()));
    }

    /**
     * Long Click
     */
    private void buttonLongClick() {
        RxView.longClicks(mLongClickButton).subscribe(
                object -> mLongClickTextView.setText(
                        "Long click at " + System.currentTimeMillis()));
    }

    /**
     * Throttle Click
     */
    private void buttonThrottleClick() {
        RxView.clicks(mThrottleClickButton)
                .throttleFirst(5, TimeUnit.SECONDS)
                .subscribe(
                        object -> mThrottleTextView.setText(
                                "Clicked at " + System.currentTimeMillis()));
    }

    /**
     * check button
     */
    private void buttonCheck() {
        RxCompoundButton.checkedChanges(mCheckEnable).subscribe(
                RxView.enabled(mCheckButton));

        RxView.clicks(mCheckButton).subscribe(
                object -> mCheckTextView.setText(
                        "Clicked at " + System.currentTimeMillis()));
    }

    /**
     * HomeBrew RxView.clicks()
     */
    private void buttonHomeBrewClick() {
        clicks(mHomeBrewButton).subscribe(
                object -> mHomeBrewTextView.setText(
                        "Clicked at " + System.currentTimeMillis()));
    }

    public static Observable<Object> clicks(View view) {
        return new MaxieeViewClickObservable(view);
    }

    private static class MaxieeViewClickObservable extends Observable<Object> {
        private View mView;

        MaxieeViewClickObservable(View view) {
            mView = view;
        }

        @Override
        protected void subscribeActual(Observer<? super Object> observer) {
            mView.setOnClickListener(v -> observer.onNext(null));
        }
    }
}
