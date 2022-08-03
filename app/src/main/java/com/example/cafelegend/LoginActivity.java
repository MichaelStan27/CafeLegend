package com.example.cafelegend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cafelegend.Utils.Utility;

public class LoginActivity extends AppCompatActivity {

    EditText usernameET, passwordET;
    Button loginBtn;
    TextView errorTV;

    void init(){
        usernameET = findViewById(R.id.username_et);
        passwordET = findViewById(R.id.password_et);
        loginBtn = findViewById(R.id.login_btn);
        errorTV = findViewById(R.id.errorMsg_tv);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        loginBtn.setOnClickListener((x) -> {

            String username, password, errorMsg = "";
            username = usernameET.getText().toString();
            password = passwordET.getText().toString();
            boolean isError = true;

            // Validation
            if (username.isEmpty()){
                errorMsg = "Username must be filled";
            } else if (password.isEmpty()){
                errorMsg = "Password must be filled";
            } else if (username.length() < 5 || username.length() > 20){
                errorMsg = "Username length must between 5-20";
            } else if (!password.matches("^[A-z0-9]+$")){
                errorMsg = "Password must be alphanumeric";
            } else if (password.matches("^[A-z]+$") || password.matches("^[0-9]+$")){
                errorMsg = "Password must contain at least one number & one character";
            } else {
                isError = false;
            }

            if (isError){
                errorTV.setText(errorMsg);
                errorTV.setVisibility(View.VISIBLE);
                Utility.setTimeout(() -> errorTV.setVisibility(View.INVISIBLE), 2000);
            } else {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
            }

        });
    }
}