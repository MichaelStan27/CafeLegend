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
 * Use the {@link BeverageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeverageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "username";

    // TODO: Rename and change types of parameters
    private String username;
    Vector<Food> foodVector;


    public BeverageFragment() {
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
    public static BeverageFragment newInstance(String param1) {
        BeverageFragment fragment = new BeverageFragment();
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
        foodVector.add(new Food("Affogato", 30000, R.drawable.affogato_0, "Espresso poured on a vanilla ice cream. Served in a cappuccino cup."));
        foodVector.add(new Food("Americano", 30000, R.drawable.americano, "Espresso with added hot water (100–150 ml). Often served in a cappuccino cup."));
        foodVector.add(new Food("Caffé Latte", 25000, R.drawable.cafe_late, "A tall, mild 'milk coffee' (about 150-300 ml). An espresso with steamed milk."));
        foodVector.add(new Food("Caffé Mocha", 27000, R.drawable.cafe_mocha, "A caffè latte with chocolate and whipped cream, made by pouring about 2 cl of chocolate."));
        foodVector.add(new Food("Cappucino", 27000, R.drawable.cappuccino_0, "A coffee drink consisting of espresso and a milk foam mixture (drink size about 160–240 ml)."));
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