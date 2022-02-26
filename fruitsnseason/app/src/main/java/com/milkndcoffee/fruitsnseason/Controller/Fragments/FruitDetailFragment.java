package com.milkndcoffee.fruitsnseason.Controller.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.milkndcoffee.fruitsnseason.Controller.FruitFetcher;
import com.milkndcoffee.fruitsnseason.Model.Fruit;
import com.milkndcoffee.fruitsnseason.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FruitDetailFragment extends Fragment {

    private Fruit mFruit;
    private FruitFetcher mFruitFetcher;
    public static final String ARG_FRUIT_ID = "fruit_id";

    public FruitDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int fruitId = 1;

        Bundle args = getArguments();
        if (args != null) {
            fruitId = args.getInt(ARG_FRUIT_ID);
        }

        assert args != null;
        Log.i("FRUITDETAIL", Integer.toString(args.getInt(ARG_FRUIT_ID)));

        //get current month
        DateFormat dateFormat = new SimpleDateFormat("MMM");
        Date date = new Date();
        Log.d("Month",dateFormat.format(date));
        String currentMonth = dateFormat.format(date).toLowerCase();

        //Data fetcher
        mFruitFetcher = new FruitFetcher(getContext());
        mFruitFetcher.fetchFruit(mFetchListener, currentMonth, fruitId);

        // Get the selected fruit
        //mFruit = FruitRepository.getInstance(requireContext()).getFruit(fruitId);
    }

    private final FruitFetcher.OnFruitDataReceivedListener mFetchListener =
            new FruitFetcher.OnFruitDataReceivedListener() {
                @Override
                public void onFruitReceived(Fruit fruit) {
                    //Name Set
                    TextView nameTextView = getView().findViewById(R.id.fruit_name_field);
                    nameTextView.setText(fruit.getName());

                    //ImageSet
                    ImageView fruitImageView = getView().findViewById(R.id.fruit_image_field);
                    //Image Binding
                    Picasso.with(getContext())
                            .load(fruit.getImgSrc())
                            .into(fruitImageView);
                    //Month Set
                    TextView descriptionTextView = getView().findViewById(R.id.fruit_months_field);
                    descriptionTextView.setText(fruit.getMonths());
                }
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "Error loading data",
                            Toast.LENGTH_LONG).show();
                    error.printStackTrace();
                }
            };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fruit_detail, container, false);

        if (mFruit != null) {
            //Name Set
            TextView nameTextView = rootView.findViewById(R.id.fruit_name_field);
            nameTextView.setText(mFruit.getName());
            Toast.makeText(getContext(), mFruit.getName(),
                    Toast.LENGTH_LONG).show();

        }


        return rootView;
    }


}