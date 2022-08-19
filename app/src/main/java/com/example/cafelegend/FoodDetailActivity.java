package com.example.cafelegend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class FoodDetailActivity extends AppCompatActivity {

    TextView foodPriceTV, foodNameTV;
    ImageButton backBtn;
    String foodName;
    Integer foodPrice;

    void init(){
        backBtn = findViewById(R.id.backBtn);
        foodNameTV = findViewById(R.id.foodNameTV);
        foodPriceTV = findViewById(R.id.foodPriceTV);

        Bundle extras = getIntent().getExtras();
        if  (extras != null) {
            foodName = extras.getString("foodName");
            foodPrice = extras.getInt("foodPrice");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        init();

        backBtn.setOnClickListener((v) -> {
            Intent intent = new Intent(this, ItemsActivity.class);
            startActivity(intent);
            finish();
        });

        foodNameTV.setText(foodName);
        foodPriceTV.setText(foodPrice.toString());
    }
}