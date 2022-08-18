package com.example.cafelegend.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cafelegend.HomeActivity;
import com.example.cafelegend.R;
import com.example.cafelegend.model.Food;

import java.util.Vector;

public class ItemsRecyclerViewAdapter extends RecyclerView.Adapter<ItemsRecyclerViewAdapter.ViewHolder>{
    private Context context;
    private Vector<Food> foodVector;

    public ItemsRecyclerViewAdapter(Context context, Vector<Food> foodVector) {
        this.context = context;
        this.foodVector = foodVector;
    }

    public void setFoodVector(Vector<Food> foodVector) {
        this.foodVector = foodVector;
    }

    @NonNull
    @Override
    public ItemsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_food_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsRecyclerViewAdapter.ViewHolder holder, int position) {
        Food food = foodVector.get(position);
        holder.tvFoodName.setText(food.getFoodName());
        holder.tvFoodPrice.setText("IDR " + food.getFoodPrice());
        holder.ivFoodImg.setImageResource(food.getImageId());
    }

    @Override
    public int getItemCount() {
        return foodVector.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvFoodName, tvFoodPrice;
        ImageView ivFoodImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvFoodName = itemView.findViewById(R.id.tv_foodName);
            tvFoodPrice = itemView.findViewById(R.id.tv_foodPrice);
            ivFoodImg = itemView.findViewById(R.id.ivFoodImg);

        }

    }
}
