package com.example.myapplications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity3 extends AppCompatActivity {
    FirebaseAuth auth;
    private TextView text;
    Button but;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        text=findViewById(R.id.textView1);
        auth =FirebaseAuth.getInstance();
        but=findViewById(R.id.buttono1);
        user = auth.getCurrentUser();
        if (user == null){
            Intent i=new Intent(getApplicationContext(),Login.class);
            startActivity(i);
            finish();
        }
        else{
            text.setText(user.getEmail());
        }

        but.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();
        });


    }
}