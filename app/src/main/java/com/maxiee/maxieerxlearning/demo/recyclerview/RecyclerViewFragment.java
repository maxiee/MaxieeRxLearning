package com.maxiee.maxieerxlearning.demo.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxiee.maxieerxlearning.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WangRui on 2017/7/6.
 */

public class RecyclerViewFragment extends Fragment {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    SimpleAdapter mSimpleAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, null);
        ButterKnife.bind(this, v);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mSimpleAdapter = new SimpleAdapter();
        mRecyclerView.setAdapter(mSimpleAdapter);

        return v;
    }
}
