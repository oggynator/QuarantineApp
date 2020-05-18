package com.example.quarantineapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quarantineapp.MainActivity;
import com.example.quarantineapp.R;

public class ListFragment extends Fragment {


    private MainActivity mainActivity;

    // Used when we create a new instance of the listfragment to be used used in the listlayout for both phone and tablet
    public static ListFragment newInstance(MainActivity mainActivity) {
        ListFragment listFragment = new ListFragment();
        listFragment.mainActivity = mainActivity;
        return listFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.listlayout, container, false); // implements the listlayout to the listFragment view.
        ListView listView = view.findViewById(R.id.mylist);//list with dummy data ("one","two","three" etc.)

        // When an item on the list is clicked it sends that data to the handleItemClick method
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view2, int adapter_pos, long row_id) {
                TextView textView = (TextView) view2;
                if (textView != null) {

                    mainActivity.handleItemClick(textView.getText().toString());
                }

            }
        });
        return view; //Returns fragment to be used in the phonelayout frame or tabletlayout frame
    }
}

