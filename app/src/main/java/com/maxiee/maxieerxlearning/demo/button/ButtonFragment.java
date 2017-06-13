package com.maxiee.maxieerxlearning.demo.button;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_button, null);
        ButterKnife.bind(this, v);

        buttonNormalClick();

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
}
