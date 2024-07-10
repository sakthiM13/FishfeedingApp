package com.example.myapplications;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        ImageView im1=(ImageView)findViewById(R.id.im1);
        ImageView im2=(ImageView)findViewById(R.id.im2);
        ImageView im3=(ImageView)findViewById(R.id.im3);
        Button b1=(Button)findViewById(R.id.b1);
        Button b2=(Button)findViewById(R.id.b2);
        Button b3=(Button)findViewById(R.id.b3);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity7.class);
                startActivity(intent);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity6.class);
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity6.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenus,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.i1:
                Intent i=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(i);
                break;

            case R.id.i3:
                Intent is=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(is);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}