package com.example.myapplications;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        Button button11=(Button)findViewById(R.id.button11);
        Button button12=(Button)findViewById(R.id.button12);
        button2.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
            startActivity(intent);
        });
        button3.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Welcome To our Website", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://7esl.com/types-of-fish/"));
            startActivity(intent);
        });
        button11.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), MainActivity5.class);
            startActivity(i);
        });
        button12.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Welcome To our Website", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ieeexplore.ieee.org/document/9759058"));
            startActivity(intent);
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.i1:
                Intent i=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(i);
                break;
            case R.id.i2:
                Intent isr=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(isr);
                break;
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
}