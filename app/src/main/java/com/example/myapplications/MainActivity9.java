package com.example.myapplications;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity9 extends AppCompatActivity {
    Button ONbutton, OFFbutton;
    TextView display;
    Boolean connected = false;
    SeekBar seekbar;
    int seeked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        ONbutton = findViewById(R.id.ONbutton);
        OFFbutton = findViewById(R.id.OFFbutton);
        display = findViewById(R.id.display);
        seekbar = findViewById(R.id.seekBar);
        seekbar.setMax(180);


        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        connected = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED || connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED;

        if (!connected) {
            display.setText("No Internet");
            display.setTextColor(Color.BLACK);
            display.setBackgroundColor(Color.RED);
        } else {

            // Write a message to the database
            final FirebaseDatabase database = FirebaseDatabase.getInstance();

            final DatabaseReference onlineDbStatus = database.getReference("online");
            onlineDbStatus.setValue(0);
            final DatabaseReference intensityDbStatus = database.getReference("angle");

            DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();

            // Read from the database
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String onlinedb = dataSnapshot.child("online").getValue().toString();
                    String withXtdb = dataSnapshot.child("withXt").getValue().toString();
                    String withAsusdb = dataSnapshot.child("withAsus").getValue().toString();

                    if (Integer.parseInt(onlinedb) == 0) {
                        display.setText("Node MCU is Offline");
                        display.setTextColor(Color.RED);
                        display.setBackgroundColor(Color.MAGENTA);
                    }
                    if (Integer.parseInt(onlinedb) == 1) {

                        if (Integer.parseInt(withXtdb) == 1) {
                            display.setText("Node MCU is Online with XT");
                            display.setTextColor(Color.BLUE);
                            display.setBackgroundColor(Color.TRANSPARENT);
                        }

                        if (Integer.parseInt(withAsusdb) == 1) {
                            display.setText("Node MCU is Online with ASUS");
                            display.setTextColor(Color.BLUE);
                            display.setBackgroundColor(Color.TRANSPARENT);
                        }


                    }


                }

                @Override
                public void onCancelled(DatabaseError error) {

                }
            });


            ONbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DatabaseReference ledDb = database.getReference("ledDb");
                    ledDb.setValue(1);
                }
            });

            OFFbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DatabaseReference ledDb = database.getReference("ledDb");
                    ledDb.setValue(0);
                }
            });


            seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                    seeked = i;
                    seekBar.setProgress(seeked);
                    display.setText("Rotation in deg. "+ seeked);

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    intensityDbStatus.setValue(seeked);
                }
            });


        }
    }

}