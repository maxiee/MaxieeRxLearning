package com.maxiee.maxieerxlearning.demo.viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maxiee.maxieerxlearning.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WangRui on 2017/7/24.
 */

public class ViewPagerFragment extends Fragment {
    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_viewpager, null);
        ButterKnife.bind(this, v);
        initData();
        return v;
    }

    private void initData() {
        mViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) return new ChildFragment("a", Color.RED);
                if (position == 1) return new ChildFragment("b", Color.GREEN);
                if (position == 2) return new ChildFragment("c", Color.BLUE);
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
    }

    public static class ChildFragment extends Fragment {
        private String mName;
        private int mBackground;

        public ChildFragment(String name, int background) {
            mName = name;
            mBackground = background;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            TextView t = new TextView(container.getContext());
            t.setText(mName);
            t.setGravity(Gravity.CENTER);
            t.setTextSize(60);
            t.setTextColor(Color.WHITE);
            t.setBackgroundColor(mBackground);

            ViewPager.LayoutParams lp = new ViewPager.LayoutParams();
            t.setLayoutParams(lp);

            return t;
        }
    }
}
