package com.example.cafelegend.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cafelegend.FoodDetailActivity;
import com.example.cafelegend.R;
import com.example.cafelegend.model.Food;

import java.util.Vector;

public class ItemsRecyclerViewAdapter extends RecyclerView.Adapter<ItemsRecyclerViewAdapter.ViewHolder>{
    private Context context;
    private Vector<Food> foodVector;
    private Bundle args;

    public ItemsRecyclerViewAdapter(Context context, Vector<Food> foodVector, Bundle args) {
        this.context = context;
        this.foodVector = foodVector;
        this.args = args;
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvFoodName, tvFoodPrice;
        ImageView ivFoodImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvFoodName = itemView.findViewById(R.id.tv_foodName);
            tvFoodPrice = itemView.findViewById(R.id.tv_foodPrice);
            ivFoodImg = itemView.findViewById(R.id.ivFoodImg);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Food food = foodVector.get(getAdapterPosition());
            Intent intent = new Intent(context, FoodDetailActivity.class);
            intent.putExtra("foodName", food.getFoodName());
            intent.putExtra("foodPrice", food.getFoodPrice());
            intent.putExtra("foodDesc", food.getFoodDesc());
            intent.putExtra("username", args.getString("username"));
            context.startActivity(intent);
        }
    }
}
