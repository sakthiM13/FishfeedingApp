package com.example.myapplications;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity {
    private int c=0;
    ImageButton btn;
    TextView txt;
    Button bo1;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        btn = (ImageButton) findViewById(R.id.Btn);
        bo1 = findViewById(R.id.bo1);
        bo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s=new Intent(getApplicationContext(),MainActivity10.class);
                startActivity(s);
            }
        });
        txt = (TextView) findViewById(R.id.count);
        btn.setOnClickListener(view -> {
            c++;
            txt.setText(Integer.toString(c));
        });
        registerForContextMenu(btn);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.add,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.i1:
                c++;
                txt.setText(Integer.toString(c));
                return true;
            case R.id.i2:
                c--;
                txt.setText(Integer.toString(c));
                return true;
        }


        return super.onContextItemSelected(item);
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
                Intent i=new Intent(getApplicationContext(),MainActivity5.class);
                startActivity(i);
                break;
            case R.id.i2:
                ProgressDialog pro=new ProgressDialog(this);
                pro.setMessage("Loading");
                pro.setTitle("Home");
                pro.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pro.show();
                int tpt=100;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int jt = 0;
                        while (jt < tpt) {
                            try {
                                Thread.sleep(500);
                                jt += 10;
                                pro.setProgress(jt);
                            }
                            catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                        Intent is=new Intent(getApplicationContext(),MainActivity2.class);
                        startActivity(is);
                    }
                }).start();
                break;
            case R.id.i3:
                Intent iRs=new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(iRs);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}