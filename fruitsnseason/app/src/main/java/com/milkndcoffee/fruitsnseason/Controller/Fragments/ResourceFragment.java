package com.milkndcoffee.fruitsnseason.Controller.Fragments;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.milkndcoffee.fruitsnseason.R;

import java.util.Objects;


public class ResourceFragment extends Fragment {


    public ResourceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_resource, container, false);

        Button linkButton1 = (Button) rootView.findViewById(R.id.link_button1);
        Button linkButton2 = (Button) rootView.findViewById(R.id.link_button2);
        Button mapButton = (Button) rootView.findViewById(R.id.map_button);


        linkButton1.setOnClickListener(this::onLink1ButtonClick);
        linkButton2.setOnClickListener(this::onLink2ButtonClick);
        mapButton.setOnClickListener(this::onMapButtonClick);



        return rootView;
    }

    private void onMapButtonClick(View view) {
        Uri location = Uri.parse("geo:0,0?q=Ferry+Plaza+Farmers+Market");
        Intent intent = new Intent(Intent.ACTION_VIEW, location);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void onLink2ButtonClick(View view) {
        String url = "https://www.ers.usda.gov/data-products/fruit-and-tree-nuts-data/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    private void onLink1ButtonClick(View view) {
        String url = "https://snaped.fns.usda.gov/seasonal-produce-guide";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }



}