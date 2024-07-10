package com.example.myapplications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity4 extends AppCompatActivity {
ImageView im1,im2,im3;
EditText t1,t2,t3;
Button b1;
    DatabaseReference customerDBref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        im1=findViewById(R.id.im1);
        im2=findViewById(R.id.im2);
        im3=findViewById(R.id.im3);
        t1=findViewById(R.id.ed1);
        t2=findViewById(R.id.ed2);
        t3=findViewById(R.id.ed3);
        b1=findViewById(R.id.b1);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Welcome To our Website", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                startActivity(intent);
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Welcome To our Website", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"));
                startActivity(intent);
            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Welcome To our Website", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/?lang=en-in"));
                startActivity(intent);
            }
        });
        customerDBref= FirebaseDatabase.getInstance().getReference().child("customer");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Form Submitted", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity4.this, "Thank You,Visit Again", Toast.LENGTH_SHORT).show();

                String channel="100";
                NotificationCompat.Builder notifyManager=new NotificationCompat.Builder(MainActivity4.this,channel)
                        .setSmallIcon(R.drawable.baseline_panorama_fish_eye_24)
                        .setContentText("Form Submitted Successfully ")
                        .setContentTitle("NOTIFICATION From Fish Feeder App")
                        .setAutoCancel(true);
                NotificationManager notify=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                    NotificationChannel nc=new NotificationChannel(channel,"CHANNEL TITLE",NotificationManager.IMPORTANCE_DEFAULT);
                    notify.createNotificationChannel(nc);
                }
                notify.notify(0,notifyManager.build());
            }
        });
    }


}