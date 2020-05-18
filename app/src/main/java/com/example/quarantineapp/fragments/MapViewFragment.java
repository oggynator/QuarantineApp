package com.example.quarantineapp.fragments;

import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.Manifest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.quarantineapp.R;
import com.example.quarantineapp.utils.Hospitals;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapViewFragment extends Fragment implements OnMapReadyCallback {
    private static final int MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 5445;
    private GoogleMap mMap;




    //HOSPITALS, have to be changed to use places, but something seems wrong with my account since the API keeps saying i have used my daily qouta


    public MapViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION) {
            if (grantResults[0] == PackageManager.PERMISSION_DENIED)
                Toast.makeText(getContext(), "Permission denied by uses", Toast.LENGTH_SHORT).show();
            else if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                onMapReady(mMap);
            }

        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.location_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        if(getActivity()!=null) {
            SupportMapFragment mapFragment = (SupportMapFragment)  getChildFragmentManager()
                    .findFragmentById(R.id.mapView);
            if (mapFragment != null) {

                mapFragment.getMapAsync(this);
            }
            else {
                Toast.makeText(getContext(), "Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        float zoomLevel = 14;
        ActivityCompat.requestPermissions(getActivity(),
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);

       mMap.setMyLocationEnabled(true);

       //Naive solution, should proberly be an array
        mMap.addMarker(new MarkerOptions().position(Hospitals.HERLEV).title("Herlev Hospital"));
        mMap.addMarker(new MarkerOptions().position(Hospitals.BISPEBJERG).title("Bispebjerg Hospital"));
        mMap.addMarker(new MarkerOptions().position(Hospitals.FREDERIKSBERG).title("Frederiksberg Hospital"));
        mMap.addMarker(new MarkerOptions().position(Hospitals.ALERIS).title("Aleris Hospital"));
        mMap.addMarker(new MarkerOptions().position(Hospitals.RIGSHOSPITALET).title("Rigshospitalet"));
        mMap.addMarker(new MarkerOptions().position(Hospitals.GENTOFTE).title("Gentofte Hospital"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(Hospitals.BISPEBJERG));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Hospitals.BISPEBJERG, zoomLevel));




    }



}