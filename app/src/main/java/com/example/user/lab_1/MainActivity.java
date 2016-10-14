package com.example.user.lab_1;

import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.PopupMenu;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Context context;
    AlertDialog al;
    AlertDialog.Builder ad;

    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_YES);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.setDrawerListener(toggle);
        drawer.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        drawer.setScrimColor(Color.TRANSPARENT);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        context = MainActivity.this;

        ///////////////////

    }


    public void onClickYES(View view) {
        finish();
    }

    public void onClickNo(View view) {
        al.cancel();
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_help) {
            View v = (View)findViewById(R.id.action_help);
            showPopupMenu(v);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this,v);
        popupMenu.inflate(R.menu.popupmenu);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {

                            case R.id.menu1:
                                ad = new AlertDialog.Builder(context);
                                ad.setView(R.layout.about_layout);
                                //////////////////////////
                                ad.setCancelable(false);
                                al = ad.create();
                                al.show();

                                return true;
                            case R.id.menu2:
                                Toast.makeText(getApplicationContext(),
                                        "Ok, just give me a dollar",
                                        Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.menu3:
                                ad = new AlertDialog.Builder(context);

                                ///////////////////////////
                                /*ad.setTitle(R.string.exit_title);  // заголовок
                                ad.setMessage(R.string.exit_message); // сообщение

                                ad.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int arg1) {
                                        finish();
                                    }
                                });
                                ad.setNegativeButton(R.string.no, null);*/
                                //////////////////////////
                                ad.setView(R.layout.exit_layout);
                                //////////////////////////
                                ad.setCancelable(false);
                                al = ad.create();
                                al.show();

                                //al.getButton(DialogInterface.BUTTON_NEGATIVE).setWidth(300);
                                //al.getWindow().setLayout(600, 500);


                                return true;
                            default:
                                return false;
                        }

                    }
                });

        popupMenu.show();


    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_bio) {
            // Handle the camera action

        } else if (id == R.id.nav_tags) {

        } else if (id == R.id.nav_sett) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_market) {
            Intent intent = new Intent(MainActivity.this, ScreenActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
