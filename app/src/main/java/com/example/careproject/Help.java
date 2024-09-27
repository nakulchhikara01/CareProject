package com.example.careproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class Help extends AppCompatActivity {

    ListView listsupport;

    ImageButton backhelp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        listsupport = findViewById(R.id.listsupport);
        backhelp = findViewById(R.id.backhelp);
        backhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Help.this, HomeActivity.class));
            }
        });

        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person("Instant Appointment Servicing on Whatsapp!\n","8826043740\nSimply Text Hi!\n"));
        arrayList.add(new Person("For Queries Related to Existing Appointment\n","8826043740\t\t\t\t|\t\t\t\t9278135021\n"));
        arrayList.add(new Person("For Queries Related to New Appointment\n","9278135021\n"));


        PersonAdapter personAdapter = new PersonAdapter(this,R.layout.list_row,arrayList);

        listsupport.setAdapter(personAdapter);
    }
}