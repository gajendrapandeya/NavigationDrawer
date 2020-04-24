package com.codermonkeys.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_inbox:
                Toast.makeText(getApplicationContext(), "Inbox", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_starred:
                Toast.makeText(getApplicationContext(), "Starred", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_sent:
                Toast.makeText(getApplicationContext(), "Mail Sent", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_drafts:
                Toast.makeText(getApplicationContext(), "Drafts", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_all_mails:
                Toast.makeText(getApplicationContext(), "All Mails", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_trash:
                Toast.makeText(getApplicationContext(), "Trash", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_spam:
                Toast.makeText(getApplicationContext(), "Spam", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
