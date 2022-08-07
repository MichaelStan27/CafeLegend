package com.example.cafelegend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class FindUsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    String username;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    void init(){
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav);
        toolbar = findViewById(R.id.toolbar);

        Bundle extras = getIntent().getExtras();
        if  (extras != null) {
            username = extras.getString("username");
        }
    }

    void setupDrawer(){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_drawer, R.string.close_drawer);

        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_us);

        init();
        setupDrawer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.side_menu_find_us, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Intent home = new Intent(this, HomeActivity.class);
                home.putExtra("username", username);
                startActivity(home);
                break;

            case R.id.items:
                Intent items = new Intent(this, ItemsActivity.class);
                items.putExtra("username", username);
                startActivity(items);
                break;

            case R.id.logout:
                Intent login = new Intent(this, LoginActivity.class);
                login.putExtra("username", username);
                startActivity(login);
                break;
        }
        return false;
    }
}