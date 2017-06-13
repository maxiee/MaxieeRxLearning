package com.maxiee.maxieerxlearning;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.maxiee.maxieerxlearning.R;
import com.maxiee.maxieerxlearning.home.HomeFragment;

public class MainActivity extends AppCompatActivity {
    HomeFragment mHomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHomeFragment = new HomeFragment();

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.main_content, mHomeFragment)
                .commit();
    }

    public void openFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.main_content, fragment)
                .addToBackStack(null)
                .commit();
    }
}
