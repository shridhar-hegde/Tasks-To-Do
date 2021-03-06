package com.example.shridhar.taskstodo;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();




        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Tasks tasks = new Tasks();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft =  fm.beginTransaction();
        ft.replace(R.id.content_frame, tasks);
        ft.commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.task)
        {
           Tasks tasks = new Tasks();
           FragmentManager fm = getFragmentManager();
            FragmentTransaction ft =  fm.beginTransaction();
            ft.replace(R.id.content_frame, tasks);
            ft.commit();

        }
        else
            if (id == R.id.notes)
            {
                Notes notes = new Notes();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft =  fm.beginTransaction();
                ft.replace(R.id.content_frame, notes);
                ft.commit();

            }
        else
            if (id == R.id.profile)
            {
                Profile profile = new Profile();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft =  fm.beginTransaction();
                ft.replace(R.id.content_frame, profile);
                ft.commit();

        }
        else
            if (id == R.id.help)
            {





        }
        else
            if (id == R.id.about)
            {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void newnote(View view)
    {
        AddNote adn = new AddNote();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content_frame, adn);
//        overridePendingTransition(R.anim.slide_in,R.anim.slide_out);
        ft.commit();

    }



}
