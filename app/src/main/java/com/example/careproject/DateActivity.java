package com.example.careproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class DateActivity extends AppCompatActivity {

    TextView textdetailsfromdentist;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton, timeButton;
    Button btnbook, btnview, btnback;
    EditText name ,email;
    DatabaseReference databaseUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        textdetailsfromdentist = findViewById(R.id.textdetailsfromdentist);
        textdetailsfromdentist.setText(getIntent().getExtras().getString("name"));

        btnbook = findViewById(R.id.btnbook);
        btnview = findViewById(R.id.btnview);
        name = findViewById(R.id.editname);
        email = findViewById(R.id.editmobile);
        databaseUsers = FirebaseDatabase.getInstance().getReference();

        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertData();
            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DateActivity.this, MyBookings.class));
                finish();
            }
        });

        btnback=findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DateActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        dateButton = findViewById(R.id.btndate);
        timeButton = findViewById(R.id.btntime);

        initDatePicker();

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });


        initTimePicker();

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });


    }

    private void InsertData() {

        String username = name.getText().toString();
        String useremail = email.getText().toString();
        String id = databaseUsers.push().getKey();

        User user = new User(username, useremail);
        databaseUsers.child("users").child(id).setValue(user)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(DateActivity.this,"Your Appointment Have Been Done Successfully",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                dateButton.setText(i2+"/"+i1+"/"+i);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        //int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }

    private void initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeButton.setText(i+":"+i1);
            }
        };

        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int mins = cal.get(Calendar.MINUTE);

        //int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new TimePickerDialog(this,timeSetListener,hrs,mins,true);
    }
}