package com.example.quarantineapp.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.quarantineapp.R;

public class TestFragment extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.test, container, false);
        Button b = (Button) v.findViewById(R.id.testkitButton);
        b.setOnClickListener(this);
        return v;

    }

    @Override
    public void onClick(View v) {
        Uri uri = Uri.parse("http://www.coronaproever.dk"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
