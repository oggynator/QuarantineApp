package com.example.quarantineapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import com.example.quarantineapp.fragments.AboutFragment;
import com.example.quarantineapp.fragments.DetailFragment;
import com.example.quarantineapp.fragments.IsolationFragment;
import com.example.quarantineapp.fragments.MapViewFragment;
import com.example.quarantineapp.fragments.SymptomsFragment;
import com.example.quarantineapp.fragments.TestFragment;

public class DetailActivity extends AppCompatActivity {

    public static final String KEY = "intendKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Bundle bundle = getIntent().getExtras(); //Receive the item that was clicked

        switch (bundle.getString(KEY)){
            case "Symptoms":
                SymptomsFragment symptomsFragment = new SymptomsFragment();
                presentFragment(R.id.detailActivityLayout, symptomsFragment);
                break;
            case "Order testkit (DK ONLY)":
                TestFragment testFragment = new TestFragment();
                presentFragment(R.id.detailActivityLayout, testFragment);
                break;
            case "Nearest testing facility":
                MapViewFragment mapViewFragment = new MapViewFragment();
                presentFragment(R.id.detailActivityLayout, mapViewFragment);
                break;
            case "Isolation activities":
                IsolationFragment isolationFragment = new IsolationFragment();
                presentFragment(R.id.detailActivityLayout, isolationFragment);
                break;
            case "About this app":
                AboutFragment aboutFragment = new AboutFragment();
                presentFragment(R.id.detailActivityLayout, aboutFragment);
                break;
        }



    }

    public void onBackPressed(View view){
        finish();
    }

    //Used to present the fragment
    private void presentFragment(int resourceID, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(resourceID, fragment)
                .commit();
    }
}
