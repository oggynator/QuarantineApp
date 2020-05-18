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


public class IsolationFragment extends Fragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.isolation, container, false);
        Button kidButton = (Button) v.findViewById(R.id.kidButton);
        kidButton.setOnClickListener(this);
        Button gameButton = (Button) v.findViewById(R.id.gameButton);
        gameButton.setOnClickListener(this);
        Button fitnessButton = (Button) v.findViewById(R.id.fitnessButton);
        fitnessButton.setOnClickListener(this);

        return v;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.kidButton:
                Uri uri = Uri.parse("https://www.northshoremums.com.au/fun-home-activities-with-kids/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

            case R.id.gameButton:
                Uri uri1 = Uri.parse("https://www.standard.co.uk/tech/gaming/best-games-play-iself-solation-coronavirus-playstation-xbox-nintendo-a4389896.html"); // missing 'http://' will cause crashed
                Intent intent1 = new Intent(Intent.ACTION_VIEW, uri1);
                startActivity(intent1);
                break;

            case R.id.fitnessButton:
                Uri uri2 = Uri.parse("https://www.bodybuilding.com/content/10-best-muscle-building-isolation-exercises.html"); // missing 'http://' will cause crashed
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                startActivity(intent2);
                break;

            default:
                break;
        }

    }


}


