package com.example.cafelegend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView greetingET;
    String username;
    void init(){
        greetingET = findViewById(R.id.greeting_et);
        Bundle extras = getIntent().getExtras();
        if  (extras != null) {
            username = extras.getString("username");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        greetingET.append(" " + username + "!");
    }
}