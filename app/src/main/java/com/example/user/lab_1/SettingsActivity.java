package com.example.user.lab_1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.ButtonBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.view.MotionEvent;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.larswerkman.holocolorpicker.ColorPicker;

import java.util.Calendar;

/**
 * Created by User on 22.09.2016.
 */

public class SettingsActivity extends AppCompatActivity {

    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_YES);
    }

    int color;
    Context context;
    AlertDialog al;
    AlertDialog.Builder ad;
    TextView textViewSound;
    TextView textViewDate;
    DatePicker datePicker;
    //Button buttonColor;
    FloatingActionButton buttonColor;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);

        context = SettingsActivity.this;
        color = Color.YELLOW;

        //buttonColor = (Button) findViewById(R.id.button_color);
        buttonColor = (FloatingActionButton) findViewById(R.id.button_color);
        buttonColor.setBackgroundTintList(ColorStateList.valueOf(color));
        buttonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(context);
                View layoutView = li.inflate(R.layout.color_input_layout, null);
                ad = new AlertDialog.Builder(context);
                ad.setView(layoutView);

                //final EditText editText = (EditText)layoutView.findViewById(R.id.editText);
                final ColorPicker colorPicker = (ColorPicker) layoutView.findViewById(R.id.colorPicker);
                colorPicker.setColor(color);
                colorPicker.setOldCenterColor(color);

                //ColorDrawable whiteDrawable = (ColorDrawable)layoutView.getResources().getDrawable(R.drawable.button_color);

                ad.setCancelable(true);
                ad.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        color = colorPicker.getColor();
                        buttonColor.setBackgroundTintList(ColorStateList.valueOf(color));
                    }
                });

                ad.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        al.cancel();
                    }
                });
                al = ad.create();
                al.show();
            }
        });
        /////////////////////////////////////////////

        textViewSound = (TextView) findViewById(R.id.textViewSound);
        textViewSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(context);
                View layoutView = li.inflate(R.layout.text_input_dialog_layout, null);
                ad = new AlertDialog.Builder(context);
                ad.setView(layoutView);

                final EditText editText = (EditText) layoutView.findViewById(R.id.editText);

                ad.setCancelable(true);
                ad.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        textViewSound.setText(editText.getText().toString());
                    }
                });

                ad.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        al.cancel();
                    }
                });
                al = ad.create();
                al.show();
            }
        });
        /////////////////////////////////////////////
        Calendar today = Calendar.getInstance();
        String month;// = String.valueOf(today.get(Calendar.MONTH));
        String day;
        if (String.valueOf(today.get(Calendar.MONTH) + 1).length() == 1)
            month = "0" + String.valueOf(today.get(Calendar.MONTH) + 1);
        else month = String.valueOf(today.get(Calendar.MONTH) + 1);
        if (String.valueOf(today.get(Calendar.DAY_OF_MONTH)).length() == 1)
            day = "0" + String.valueOf(today.get(Calendar.DAY_OF_MONTH));
        else day = String.valueOf(today.get(Calendar.DAY_OF_MONTH));
        String date = String.valueOf(day + "." + month + "." + today.get(Calendar.YEAR));

        textViewDate = (TextView) findViewById(R.id.text_date);
        textViewDate.setText(date);
        textViewDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater li = LayoutInflater.from(context);
                View layoutView = li.inflate(R.layout.date_input_layout, null);
                ad = new AlertDialog.Builder(context);
                ad.setView(layoutView);

                /////
                datePicker = (DatePicker) layoutView.findViewById(R.id.datePicker);
                String date = String.valueOf(textViewDate.getText());
                String month = date.substring(3, 5);
                String day = date.substring(0, 2);
                String year = date.substring(6);


                //textViewDate.setText(String.valueOf(date));
                //datePicker.init(Integer.parseInt(day), Integer.parseInt(month)-1,Integer.parseInt(year), null);
                //datePicker.init(12, 9, 2015, null);

                /////

                ad.setCancelable(true);
                ad.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String month;
                        String day;
                        if (String.valueOf(datePicker.getMonth() + 1).length() == 1)
                            month = "0" + String.valueOf(datePicker.getMonth() + 1);
                        else month = String.valueOf(datePicker.getMonth() + 1);
                        if (String.valueOf(datePicker.getDayOfMonth()).length() == 1)
                            day = "0" + String.valueOf(datePicker.getDayOfMonth());
                        else day = String.valueOf(datePicker.getDayOfMonth());
                        String date = String.valueOf(day + "." + month + "." + datePicker.getYear());
                        textViewDate.setText(date);
                    }
                });

                ad.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        al.cancel();
                    }
                });
                al = ad.create();
                al.show();
            }
        });
        ///////////////////////////////////////////////////////////////////


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void onClickCancel(View view) {
        al.cancel();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Settings Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
