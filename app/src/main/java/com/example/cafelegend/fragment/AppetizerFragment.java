package com.example.cafelegend.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cafelegend.R;
import com.example.cafelegend.adapter.ItemsRecyclerViewAdapter;
import com.example.cafelegend.model.Food;

import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AppetizerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppetizerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "username";

    // TODO: Rename and change types of parameters
    private String username;
    Vector<Food> foodVector;


    public AppetizerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment AppetizerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AppetizerFragment newInstance(String param1) {
        AppetizerFragment fragment = new AppetizerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            username = getArguments().getString(ARG_PARAM1);
        }
    }

    void loadFoodData(){
        foodVector = new Vector<>();
        foodVector.add(new Food("Neiman Marcus Dip", 23000, R.drawable.neiman, "This Neiman Marcus dip is a delicious alternative to traditional cheese dips. In this dip, the shredded cheese base is complemented with green onions, almonds, mayo, and bacon."));
        foodVector.add(new Food("Meatball Stuffed Buns", 28000, R.drawable.meatball, "A spin on the traditional meatball, these meatball stuffed buns are warm and filling. For down-home comfort, these stuffed buns are a great choice."));
        foodVector.add(new Food("Cannoli Dip", 20000, R.drawable.cannoli, "Who says you can’t eat dessert first? This easy cannoli dip is excellent party food."));
        foodVector.add(new Food("Sweet Potato Bites", 20000, R.drawable.sweetp, "Comprised of just a few simple ingredients, these sweet potato bites with avocado and bacon are a healthier appetizer."));
        foodVector.add(new Food("Crescent Sausage Bites", 25000, R.drawable.crescent, "With just three ingredients, these semi-homemade crescent sausage bites are simple and always popular at parties."));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        loadFoodData();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_food, container, false);
        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view;

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new ItemsRecyclerViewAdapter(context, foodVector, getArguments()));

        return view;
    }
}