package com.example.cafelegend;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodDetailActivity extends AppCompatActivity {

    TextView foodPriceTV, foodNameTV, foodDescTV;
    ImageView image;
    EditText qtyET;
    ImageButton backBtn;
    String foodName, foodDesc, username;
    Integer foodPrice, foodImageID;
    Button buyBtn;

    void init(){
        backBtn = findViewById(R.id.backBtn);
        buyBtn = findViewById(R.id.buy_btn);
        qtyET = findViewById(R.id.qty_ET);
        foodNameTV = findViewById(R.id.foodNameTV);
        foodPriceTV = findViewById(R.id.foodPriceTV);
        foodDescTV = findViewById(R.id.foodDescTV);
        image = findViewById(R.id.image);

        Bundle extras = getIntent().getExtras();
        if  (extras != null) {
            foodName = extras.getString("foodName");
            foodPrice = extras.getInt("foodPrice");
            foodDesc = extras.getString("foodDesc");
            foodImageID = extras.getInt("foodImageID");
            username = extras.getString("username");
        }
    }

    public void showDialog(String msg){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder
                .setMessage(msg)
                .setNegativeButton("Okay", (i, x) -> {
                    System.out.println("Test");
                })
                .create().show();
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

        buyBtn.setOnClickListener((x) -> {
            Integer qty;
            String qtyStr = qtyET.getText().toString();
            if(qtyStr.isEmpty()){
                showDialog("qty cant be empty");
            }
            else{
                qty = Integer.parseInt(qtyStr);

                if(qty>0){
                    Intent items = new Intent(this, ItemsActivity.class);
                    items.putExtra("username", username);
                    startActivity(items);
                }
                else{
                    showDialog("qty must be greater than 0");
                }
            }
        });

        foodNameTV.setText(foodName);
        foodPriceTV.setText("Rp. " + foodPrice.toString());
        foodDescTV.setText(foodDesc);
        image.setImageResource(foodImageID);
    }
}