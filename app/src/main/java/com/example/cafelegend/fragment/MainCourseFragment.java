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
 * Use the {@link MainCourseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainCourseFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "username";

    // TODO: Rename and change types of parameters
    private String username;
    Vector<Food> foodVector;


    public MainCourseFragment() {
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
    public static MainCourseFragment newInstance(String param1) {
        MainCourseFragment fragment = new MainCourseFragment();
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
        foodVector.add(new Food("Furikake Salmon", 35000, R.drawable.furikake, "Furikake Salmon is a delicious and healthy recipe where salmon fillets are coated with a layer of Furikake seasoning."));
        foodVector.add(new Food("Thai Pumpkin Curry", 30000, R.drawable.thai, "Make this spicy Thai Pumpkin Curry in under 20 minutes for your weeknight dinner."));
        foodVector.add(new Food("Air Fryer Salmon", 29000, R.drawable.air, "This air fryer salmon is tender, juicy, and perfectly seasoned."));
        foodVector.add(new Food("Chicken Curry", 40000, R.drawable.chicken, "Love the chicken curry that is served at the Indian restaurants? Then try my super easy recipe which is made using basic ingredients."));
        foodVector.add(new Food("Hibachi Chicken", 25000, R.drawable.hibachi, "This Japanese steakhouse-style Hibachi Chicken makes for a quick, easy, and super- delicious dinner."));
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