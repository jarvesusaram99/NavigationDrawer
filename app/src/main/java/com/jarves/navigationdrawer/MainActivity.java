package com.jarves.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    private Button btnToggleDark;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();

        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case  R.id.nav_home:

                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_drawer1:
                        Intent intent1 = new Intent(MainActivity.this , NavigationOne.class);

                        startActivity(intent1);
                        break;
                    case R.id.nav_drawer2:
                        Intent intent2 = new Intent(MainActivity.this , NavigationTwo.class);

                        startActivity(intent2);
                        break;
                    case R.id.nav_aboutus:
                        Intent intent3 = new Intent(MainActivity.this , aboutus.class);
                        startActivity(intent3);
                        break;


//Paste your privacy policy link

//                    case  R.id.nav_Policy:{
//
//                        Intent browserIntent  = new Intent(Intent.ACTION_VIEW , Uri.parse(""));
//                        startActivity(browserIntent);
//
//                    }
                    //       break;
                    case  R.id.nav_share:{

                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        String shareBody =  "http://play.google.com/store/apps/detail?id=" + getPackageName();
                        String shareSub = "Try now";
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingIntent, "Share using"));

                    }
                    break;
                }
                return false;
            }
        });
    }

    public void darkbutton(View view) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

    }

    public void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
        actionBarDrawerToggle.syncState();

    }
}