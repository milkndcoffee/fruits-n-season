package com.milkndcoffee.fruitsnseason.Controller.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.milkndcoffee.fruitsnseason.R;


public class MonthPickerFragment extends Fragment {
    public MonthPickerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_month_picker, container, false);


        Button janButton = (Button) rootView.findViewById(R.id.button_jan);
        Button febButton = (Button) rootView.findViewById(R.id.button_feb);
        Button marButton = (Button) rootView.findViewById(R.id.button_mar);
        Button aprButton = (Button) rootView.findViewById(R.id.button_apr);
        Button mayButton = (Button) rootView.findViewById(R.id.button_may);
        Button junButton = (Button) rootView.findViewById(R.id.button_jun);
        Button julButton = (Button) rootView.findViewById(R.id.button_jul);
        Button augButton = (Button) rootView.findViewById(R.id.button_aug);
        Button sepButton = (Button) rootView.findViewById(R.id.button_sep);
        Button octButton = (Button) rootView.findViewById(R.id.button_oct);
        Button novButton = (Button) rootView.findViewById(R.id.button_nov);
        Button decButton = (Button) rootView.findViewById(R.id.button_dec);

        janButton.setOnClickListener(this::onJanButtonClick);
        febButton.setOnClickListener(this::onFebButtonClick);
        marButton.setOnClickListener(this::onMarButtonClick);
        aprButton.setOnClickListener(this::onAprButtonClick);
        mayButton.setOnClickListener(this::onMayButtonClick);
        junButton.setOnClickListener(this::onJunButtonClick);
        julButton.setOnClickListener(this::onJulButtonClick);
        augButton.setOnClickListener(this::onAugButtonClick);
        sepButton.setOnClickListener(this::onSepButtonClick);
        octButton.setOnClickListener(this::onOctButtonClick);
        novButton.setOnClickListener(this::onNovButtonClick);
        decButton.setOnClickListener(this::onDecButtonClick);

        return rootView;
    }

    private void onDecButtonClick(View view) {
        Bundle args = new Bundle();
        args.putString(ListFragment.ARG_MONTH, "dec");

        View listFragmentContainer = getView().findViewById(R.id.fragment_list);
        if (listFragmentContainer == null) {
            // Replace list with details
            Navigation.findNavController(view).navigate(R.id.action_navigation_search_to_navigation_list, args);
        }
    }

    private void onNovButtonClick(View view) {
        Bundle args = new Bundle();
        args.putString(ListFragment.ARG_MONTH, "nov");

        View listFragmentContainer = getView().findViewById(R.id.fragment_list);
        if (listFragmentContainer == null) {
            // Replace list with details
            Navigation.findNavController(view).navigate(R.id.action_navigation_search_to_navigation_list, args);
        }
    }

    private void onOctButtonClick(View view) {
        Bundle args = new Bundle();
        args.putString(ListFragment.ARG_MONTH, "oct");

        View listFragmentContainer = getView().findViewById(R.id.fragment_list);
        if (listFragmentContainer == null) {
            // Replace list with details
            Navigation.findNavController(view).navigate(R.id.action_navigation_search_to_navigation_list, args);
        }
    }

    private void onSepButtonClick(View view) {
        Bundle args = new Bundle();
        args.putString(ListFragment.ARG_MONTH, "sep");

        View listFragmentContainer = getView().findViewById(R.id.fragment_list);
        if (listFragmentContainer == null) {
            // Replace list with details
            Navigation.findNavController(view).navigate(R.id.action_navigation_search_to_navigation_list, args);
        }
    }

    private void onAugButtonClick(View view) {
        Bundle args = new Bundle();
        args.putString(ListFragment.ARG_MONTH, "aug");

        View listFragmentContainer = getView().findViewById(R.id.fragment_list);
        if (listFragmentContainer == null) {
            // Replace list with details
            Navigation.findNavController(view).navigate(R.id.action_navigation_search_to_navigation_list, args);
        }
    }

    private void onJulButtonClick(View view) {
        Bundle args = new Bundle();
        args.putString(ListFragment.ARG_MONTH, "jul");

        View listFragmentContainer = getView().findViewById(R.id.fragment_list);
        if (listFragmentContainer == null) {
            // Replace list with details
            Navigation.findNavController(view).navigate(R.id.action_navigation_search_to_navigation_list, args);
        }
    }

    private void onJunButtonClick(View view) {
        Bundle args = new Bundle();
        args.putString(ListFragment.ARG_MONTH, "jun");

        View listFragmentContainer = getView().findViewById(R.id.fragment_list);
        if (listFragmentContainer == null) {
            // Replace list with details
            Navigation.findNavController(view).navigate(R.id.action_navigation_search_to_navigation_list, args);
        }
    }

    private void onMayButtonClick(View view) {
        Bundle args = new Bundle();
        args.putString(ListFragment.ARG_MONTH, "may");

        View listFragmentContainer = getView().findViewById(R.id.fragment_list);
        if (listFragmentContainer == null) {
            // Replace list with details
            Navigation.findNavController(view).navigate(R.id.action_navigation_search_to_navigation_list, args);
        }
    }

    private void onAprButtonClick(View view) {
        Bundle args = new Bundle();
        args.putString(ListFragment.ARG_MONTH, "apr");

        View listFragmentContainer = getView().findViewById(R.id.fragment_list);
        if (listFragmentContainer == null) {
            // Replace list with details
            Navigation.findNavController(view).navigate(R.id.action_navigation_search_to_navigation_list, args);
        }
    }

    private void onMarButtonClick(View view) {
        Bundle args = new Bundle();
        args.putString(ListFragment.ARG_MONTH, "mar");

        View listFragmentContainer = getView().findViewById(R.id.fragment_list);
        if (listFragmentContainer == null) {
            // Replace list with details
            Navigation.findNavController(view).navigate(R.id.action_navigation_search_to_navigation_list, args);
        }
    }

    private void onJanButtonClick(View view) {
        Bundle args = new Bundle();
        args.putString(ListFragment.ARG_MONTH, "jan");

        View listFragmentContainer = getView().findViewById(R.id.fragment_list);
        if (listFragmentContainer == null) {
            // Replace list with details
            Navigation.findNavController(view).navigate(R.id.action_navigation_search_to_navigation_list, args);
        }
    }

    public void onFebButtonClick(View view){
        Bundle args = new Bundle();
        args.putString(ListFragment.ARG_MONTH, "feb");

        View listFragmentContainer = getView().findViewById(R.id.fragment_list);
        if (listFragmentContainer == null) {
            // Replace list with details
            Navigation.findNavController(view).navigate(R.id.action_navigation_search_to_navigation_list, args);
        }
    }

}