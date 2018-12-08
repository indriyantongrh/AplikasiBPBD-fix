package com.universedeveloper.aplikasibpbd;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.universedeveloper.aplikasibpbd.Beranda.FragmentBeranda;
import com.universedeveloper.aplikasibpbd.Panduan.FragmentPanduan;
import com.universedeveloper.aplikasibpbd.Tentang.FragmentTentang;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        Fragment fragment;
        fragment = new FragmentBeranda();
        loadFragment(fragment);
        //return true;

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_beranda:
                    //toolbar.setTitle("Beranda");
                    fragment = new FragmentBeranda();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_panduan:
                    //toolbar.setTitle("Panduan");
                    fragment = new FragmentPanduan();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_tentang:
                    //toolbar.setTitle("Tentang");
                    fragment = new FragmentTentang();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        Bundle bundle = new Bundle();
        // bundle.putString("kode", kode);
        //bundle.putString("key", key);
        fragment.setArguments(bundle);
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        //transaction.addToBackStack(null);
        transaction.commit();


    }
}
