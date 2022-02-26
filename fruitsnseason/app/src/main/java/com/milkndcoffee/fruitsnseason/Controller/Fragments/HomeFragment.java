package com.milkndcoffee.fruitsnseason.Controller.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.milkndcoffee.fruitsnseason.Controller.FruitFetcher;
import com.milkndcoffee.fruitsnseason.Model.Fruit;
import com.milkndcoffee.fruitsnseason.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HomeFragment extends Fragment {

    private FruitFetcher mFruitFetcher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        //get current month
        DateFormat dateFormat = new SimpleDateFormat("MMM");
        Date date = new Date();
        Log.d("Month",dateFormat.format(date));
        String currentMonth = dateFormat.format(date).toLowerCase();

        TextView monthText;
        monthText = rootView.findViewById(R.id.month_text);

        //apply current month to view
        switch (currentMonth) {
            case "jan":
                monthText.setText("january");
                break;
            case "feb":
                monthText.setText("february");
                break;
            case "mar":
                monthText.setText("march");
                break;
            case "apr":
                monthText.setText("april");
                break;
            case "may":
                monthText.setText("may");
                break;
            case "jun":
                monthText.setText("june");
                break;
            case "jul":
                monthText.setText("july");
                break;
            case "aug":
                monthText.setText("august");
                break;
            case "sep":
                monthText.setText("september");
                break;
            case "oct":
                monthText.setText("october");
                break;
            case "nov":
                monthText.setText("november");
                break;
            case "dec":
                monthText.setText("december");
                break;
        }

        //Data fetcher
        mFruitFetcher = new FruitFetcher(getContext());
        mFruitFetcher.fetchFruits(mFetchListener, currentMonth);

        return rootView;
    }

    private final FruitFetcher.OnFruitsDataReceivedListener mFetchListener =
            new FruitFetcher.OnFruitsDataReceivedListener() {
                @Override
                public void onFruitsReceived(List<Fruit> fruits) {
                    // Click listener for the RecyclerView
                    View.OnClickListener onClickListener = itemView -> {
                        // Create fragment arguments containing the selected fruit ID
                        int selectedFruitId = (int) itemView.getTag();
                        Bundle args = new Bundle();
                        args.putInt(FruitDetailFragment.ARG_FRUIT_ID, selectedFruitId);

                        View detailFragmentContainer = getView().findViewById(R.id.fragment_detail);
                        if (detailFragmentContainer == null) {
                            // Replace list with details
                            Navigation.findNavController(itemView).navigate(R.id.show_item_detail, args);
                        }
                    };

                    GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);

                    RecyclerView recyclerView = getView().findViewById(R.id.fruit_list);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(new FruitAdapter(fruits, onClickListener));

                }

                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "Error loading data",
                            Toast.LENGTH_LONG).show();
                    error.printStackTrace();
                    //log.error("Error loading data", e);
                }
            };

    private class FruitAdapter extends RecyclerView.Adapter<FruitHolder> {
        private final List<Fruit> mFruits;
        private final View.OnClickListener mOnClickListener;

        public FruitAdapter(List<Fruit> fruits, View.OnClickListener onClickListener) {
            mFruits = fruits;
            mOnClickListener = onClickListener;
        }

        @NonNull
        @Override
        public FruitHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new FruitHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(FruitHolder holder, int position) {
            Fruit fruit = mFruits.get(position);
            holder.bind(fruit);
            holder.itemView.setTag(fruit.getId());
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mFruits.size();
        }
    }


    private static class FruitHolder extends RecyclerView.ViewHolder {
        private final TextView mNameTextView;
        private final ImageView mImageView;

        public FruitHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_fruit, parent, false));
            mNameTextView = itemView.findViewById(R.id.fruit_name);
            mImageView = itemView.findViewById(R.id.fruit_image);
        }

        public void bind(Fruit fruit) {
            //Name Binding
            mNameTextView.setText(fruit.getName());

            //Image Binding
            Picasso.with(itemView.getContext())
                    .load(fruit.getImgSrc())
                    .into(mImageView);
        }
    }
}