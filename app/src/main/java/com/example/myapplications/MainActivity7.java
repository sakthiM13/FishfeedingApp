package com.example.myapplications;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity7 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        ImageView im1 = (ImageView) findViewById(R.id.im1);
        registerForContextMenu(im1);
        TextView t1 = findViewById(R.id.t1);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu pop = new PopupMenu(MainActivity7.this, t1);
                pop.inflate(R.menu.link);
                pop.show();
                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.i2:
                                Intent in = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ieeexplore.ieee.org/document/9759058"));
                                startActivity(in);
                                return true;
                            case R.id.i3:
                             Intent intent=new Intent();
                             intent.setType("text/plain");
                             intent.setAction(Intent.ACTION_SEND);
                             intent.putExtra(Intent.EXTRA_TEXT,"your app link is here");
                             intent.putExtra(Intent.EXTRA_SUBJECT,"check out app");
                             startActivity(Intent.createChooser(intent,"share via"));
                             return true;
                            case R.id.i4:
                                Toast.makeText(MainActivity7.this, "Downloaded", Toast.LENGTH_SHORT).show();
                                String channel="100";
                                NotificationCompat.Builder notifyManager=new NotificationCompat.Builder(MainActivity7.this,channel)
                                        .setSmallIcon(R.drawable.baseline_panorama_fish_eye_24)
                                        .setContentText("Link Downloaded Successfully ")
                                        .setContentTitle("NOTIFICATION From Fish Feeder App")
                                        .setAutoCancel(true);
                                NotificationManager notify=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                                    NotificationChannel nc=new NotificationChannel(channel,"CHANNEL TITLE",NotificationManager.IMPORTANCE_DEFAULT);
                                    notify.createNotificationChannel(nc);
                                }
                                notify.notify(0,notifyManager.build());
                                return true;
                        }
                        return false;
                    }
                });
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.optionmenus,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.i1:
                Intent s=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(s);
                return true;
            case R.id.i2:
                ProgressDialog pro=new ProgressDialog(this);
                pro.setTitle("Our Services");
                pro.setMessage("Loading");
                pro.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pro.show();
                int tpt=100;
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        int jt = 0;
                        while (jt < tpt) {
                            try {
                                Thread.sleep(400);
                                jt += 5;
                                pro.setProgress(jt);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                        Intent si=new Intent(getApplicationContext(),MainActivity5.class);
                        startActivity(si);
                    }
                }).start();

                return true;
            case R.id.i3:
                AlertDialog.Builder al = new AlertDialog.Builder(this);
                al.setMessage("Do you want to exit");
                al.setTitle("EXIT");
                al.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        Intent s=new Intent(getApplicationContext(),MainActivity3.class);
                        startActivity(s);
                    }
                });
                al.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                al.show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.image,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.i1:
                Toast.makeText(MainActivity7.this, "You Clicked Zoom In", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.i2:
                Toast.makeText(MainActivity7.this, "You Clicked Zoom Out", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
