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

import butterknife.BindView;
import butterknife.ButterKnife;

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

    @BindView(R.id.check_enable)
    CheckBox mCheckEnable;

    @BindView(R.id.check_clickable)
    CheckBox mCheckClickable;

    @BindView(R.id.check_button)
    Button mCheckButton;

    @BindView(R.id.check_textview)
    TextView mCheckTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_button, null);
        ButterKnife.bind(this, v);

        buttonNormalClick();
        buttonLongClick();
        buttonCheck();

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
     * check button
     */
    private void buttonCheck() {
        RxCompoundButton.checkedChanges(mCheckEnable).subscribe(
                RxView.enabled(mCheckButton));

        RxCompoundButton.checkedChanges(mCheckClickable).subscribe(
                RxView.clickable(mCheckButton));

        RxView.clicks(mCheckButton).subscribe(
                object -> mCheckTextView.setText("Clicked at " + System.currentTimeMillis()));
    }
}
