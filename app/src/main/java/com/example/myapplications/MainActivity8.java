package com.example.myapplications;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity8 extends AppCompatActivity {
Button b31,b41;
EditText time,date;
    EditText name,contact,address;
    Button insert,update,delete,view;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        b31=findViewById(R.id.b31);
        b41=findViewById(R.id.b41);
        time=findViewById(R.id.ed12);
        date=findViewById(R.id.ed22);
        b41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c=Calendar.getInstance();
                int h=c.get(Calendar.HOUR_OF_DAY);
                int m=c.get(Calendar.MINUTE);
                TimePickerDialog ts=new TimePickerDialog(MainActivity8.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        time.setText(i+":"+i1);
                    }

                },h,m,false);
                ts.show();
            }
        });

        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int y = c.get(Calendar.YEAR);
                int m = c.get(Calendar.MONTH);
                int d = c.get(Calendar.DATE);

                DatePickerDialog p = new DatePickerDialog(MainActivity8.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dat) {
                        date.setText(dat + "-" + month + "-" + year);
                    }
                }, y, m, d);
                p.show();
            }

        });
        name=findViewById(R.id.ed1);
        contact=findViewById(R.id.ed2);
        address=findViewById(R.id.ed3);
        insert=findViewById(R.id.b1);
        update=findViewById(R.id.b2);
        delete=findViewById(R.id.b3);
        view=findViewById(R.id.b4);
        DB=new DBHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=name.getText().toString();
                String contactTxt=contact.getText().toString();
                String dobTXT=address.getText().toString();
                String timeTXT=time.getText().toString();
                String dateTXT=date.getText().toString();
                Boolean checkpointing= DB.insertuserdata(nameTXT,contactTxt,dobTXT,timeTXT,dateTXT);
                if(checkpointing==true){
                    Toast.makeText(MainActivity8.this, "New Entry Entered", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity8.this, "New entry Not entered", Toast.LENGTH_SHORT).show();
                }
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=name.getText().toString();
                String contactTxt=contact.getText().toString();
                String dobTXT=address.getText().toString();
                String timeTXT=time.getText().toString();
                String dateTXT=date.getText().toString();
                Boolean checkupdate= DB.updateuserdata(nameTXT,contactTxt,dobTXT,timeTXT,dateTXT);
                if(checkupdate==true){
                    Toast.makeText(MainActivity8.this, "New Entry Updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity8.this, "New entry Not updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=name.getText().toString();
                Boolean checkdeletedata= DB.deleteuserdata(nameTXT);
                if(checkdeletedata==true){
                    Toast.makeText(MainActivity8.this, "entry deleted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity8.this, "entry Not deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=DB.viewuserdata();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity8.this, "no entry exists", Toast.LENGTH_SHORT).show();
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()) {
                    buffer.append("Name" + res.getString(0) + "\n");
                    buffer.append("Contact" + res.getString(1) + "\n");
                    buffer.append("Address" + res.getString(2) + "\n");
                    buffer.append("Name" + res.getString(3) + "\n");
                    buffer.append("Contact" + res.getString(4) + "\n\n");

                }
                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity8.this);
                alert.setCancelable(true);
                alert.setMessage(buffer.toString());
                alert.setTitle("User Entries");
                alert.show();
            }
        });
    }
}

