package com.maxiee.maxieerxlearning.demo.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jakewharton.rxbinding2.support.v7.widget.RecyclerViewChildAttachEvent;
import com.jakewharton.rxbinding2.support.v7.widget.RecyclerViewChildAttachStateChangeEvent;
import com.jakewharton.rxbinding2.support.v7.widget.RecyclerViewChildDetachEvent;
import com.jakewharton.rxbinding2.support.v7.widget.RxRecyclerView;
import com.jakewharton.rxbinding2.support.v7.widget.RxRecyclerViewAdapter;
import com.jakewharton.rxbinding2.view.RxView;
import com.maxiee.maxieerxlearning.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by WangRui on 2017/7/6.
 */

public class RecyclerViewFragment extends Fragment {
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @BindView(R.id.btn_replace_item)
    Button mButtonReplaceItem;

    SimpleAdapter mSimpleAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, null);
        ButterKnife.bind(this, v);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mSimpleAdapter = new SimpleAdapter();
        mRecyclerView.setAdapter(mSimpleAdapter);

        RxRecyclerViewAdapter.dataChanges(mSimpleAdapter).subscribe(simpleAdapter -> {
            Log.d("maxiee", "dataChanges");
        });

        RxView.clicks(mButtonReplaceItem).subscribe(e -> {
            mSimpleAdapter.replaceItem(1, "Maxiee");
            mSimpleAdapter.notifyDataSetChanged();
        });

        RxRecyclerView
                .scrollStateChanges(mRecyclerView)
                .subscribe(scrollState -> {
                    Log.d("maxiee", "scrollState = " + scrollState);
                });

        RxRecyclerView.scrollEvents(mRecyclerView)
                .subscribe(scroll -> {
                    Log.d("maxiee", "dx = " + scroll.dx() + ", dy = " + scroll.dy());
                });

        RxRecyclerView.childAttachStateChangeEvents(mRecyclerView).subscribe(event -> {
            Button button = ((SimpleAdapter.ViewHolder) event.child().getTag()).mButton;
            CharSequence text = button.getText();

            if (event instanceof RecyclerViewChildAttachEvent) {
                Log.d("maxiee", "attach " + text);
                return;
            }

            if (event instanceof RecyclerViewChildDetachEvent) {
                Log.d("maxiee", "detach " + text);
                return;
            }
        });

        return v;
    }
}
