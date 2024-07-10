package com.example.myapplications;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
Button buttonlog,button5,button7,button9,button34,button19,button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       buttonlog=findViewById(R.id.buttonlog);
        buttonlog.setOnClickListener(view -> {
            Intent in=new Intent(getApplicationContext(),Login.class);
            startActivity(in);

        });
        button34=findViewById(R.id.button34);
        button34.setOnClickListener(view -> {
            Intent i=new Intent(MainActivity2.this,MainActivity4.class);
            startActivity(i);
        });
       button5=findViewById(R.id.button5);
        button5.setOnClickListener(view -> {
            Intent i=new Intent(MainActivity2.this,MainActivity6.class);
            startActivity(i);
        });

        button9=findViewById(R.id.button9);
        button9.setOnClickListener(view -> {
            Intent i=new Intent(MainActivity2.this,MainActivity5.class);
            startActivity(i);
        });

        button7=findViewById(R.id.button7);
        button7.setOnClickListener(view -> {
            Intent intent=new Intent(getApplicationContext(),Register.class);
            startActivity(intent);

        });

        button19=findViewById(R.id.button19);
        button19.setOnClickListener(view -> {
            Intent i=new Intent(MainActivity2.this,MainActivity8.class);
            startActivity(i);
        });
        button=findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Intent i=new Intent(MainActivity2.this,MainActivity9.class);
            startActivity(i);
        });
    }
}