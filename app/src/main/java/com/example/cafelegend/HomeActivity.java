package com.example.cafelegend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.cafelegend.adapter.CarouselAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView greetingET;
    String username;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    //    Carousel
    ViewPager carouselVP;
    int images[] = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5};
    int carouselCounter = 0;
    ImageButton carouselNextBtn, carouselPrevBtn;

    void init(){
        carouselVP = findViewById(R.id.carouselVP);
        carouselVP.setAdapter(new CarouselAdapter(images, this));
        carouselNextBtn = findViewById(R.id.nextCarouselIB);
        carouselPrevBtn = findViewById(R.id.prevCarouselIB);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav);
        toolbar = findViewById(R.id.toolbar);

        greetingET = findViewById(R.id.greeting_et);
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

    void carouselChangeImg(int factor){
        carouselCounter += factor;
        if (carouselCounter == images.length){
            carouselCounter = 0 ;
        } else if (carouselCounter < 0){
            carouselCounter = images.length -1;
        }

        carouselVP.setCurrentItem(carouselCounter,true);
    }

    void carouselUpdater(){
        //auto change image
        final Handler handler = new Handler();
        final Runnable update  = () -> carouselChangeImg(1);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },2500,2500);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        setupDrawer();
        carouselUpdater();

        carouselNextBtn.setOnClickListener((v) -> carouselChangeImg(1));
        carouselPrevBtn.setOnClickListener((v) -> carouselChangeImg(-1));

        greetingET.append(" " + username + "!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.side_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.items:
                Intent items = new Intent(this, ItemsActivity.class);
                items.putExtra("username", username);
                startActivity(items);
                break;

            case R.id.find_us:
                Intent find_us = new Intent(this, FindUsActivity.class);
                find_us.putExtra("username", username);
                startActivity(find_us);
                break;

            case R.id.logout:
                Intent login = new Intent(this, LoginActivity.class);
                login.putExtra("username", username);
                startActivity(login);
                finish();
                break;
        }
        return false;
    }
}