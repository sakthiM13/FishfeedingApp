package com.example.myapplications;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.checkerframework.checker.nullness.qual.NonNull;

public class Register extends AppCompatActivity {
EditText email1,password1;
FirebaseAuth mAuth;
ProgressBar progressBar;
Button button;
TextView text;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email1=findViewById(R.id.ed1);
        password1=findViewById(R.id.ed2);
        button=findViewById(R.id.b);
        mAuth=FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.p1);
        text=findViewById(R.id.t1);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Login.class);
                startActivity(i);
                finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          progressBar.setVisibility(View.VISIBLE);
                                          String email, password;
                                          email = String.valueOf(email1.getText());
                                          password = String.valueOf(password1.getText());
                                          if (TextUtils.isEmpty(email)) {
                                              Toast.makeText(Register.this, "Enter Email", Toast.LENGTH_SHORT).show();

                                              return;
                                          }
                                          if (TextUtils.isEmpty(password)) {
                                              Toast.makeText(Register.this, "Enter Password", Toast.LENGTH_SHORT).show();
                                              return;
                                          }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {

                                    Toast.makeText(Register.this, "Account Created",
                                            Toast.LENGTH_SHORT).show();
                                    Intent i=new Intent(getApplicationContext(),Login.class);
                                    startActivity(i);
                                    finish();

                                } else {

                                    Toast.makeText(Register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        }
                                      });
            }
}

