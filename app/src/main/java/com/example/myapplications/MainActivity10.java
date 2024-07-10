package com.example.myapplications;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity10 extends AppCompatActivity {
    EditText name,add,city,state;
    Spinner spin;
    Button button,button1;
    DatabaseReference customerDBref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        name=findViewById(R.id.name);
        add=findViewById(R.id.add);
        city=findViewById(R.id.city);
        state=findViewById(R.id.state);
        spin=findViewById(R.id.spin);
        button=findViewById(R.id.but);
        customerDBref= FirebaseDatabase.getInstance().getReference().child("customer");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertstudentdata();
            }
        });

    }

    private void insertstudentdata(){
        String Name=name.getText().toString();
        String Add=add.getText().toString();
        String City=city.getText().toString();
        String State=state.getText().toString();

        customer cus=new customer(Name,Add,City,State);
        customerDBref.push().setValue(cus);

        Toast.makeText(this, "Form Submitted Succesffully", Toast.LENGTH_SHORT).show();
    }

}