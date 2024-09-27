package com.example.careproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class Offers extends AppCompatActivity {

    ListView listView;

    ImageButton backoffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        listView = findViewById(R.id.listview);
        backoffer = findViewById(R.id.backoffer);
        backoffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Offers.this, HomeActivity.class));
            }
        });

        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person("Get 'Revolutionary' Savings\n","Cure yourself with UPTO Rs 500 Off on Dental and more.\n"));
        arrayList.add(new Person("2023 Rewind Offers\n","Treat yourself with Coupon Rs 800 Off on Skin and more.\n"));
        arrayList.add(new Person("You are gonna it!\n","Get UPTO 80% Off on Surgery.\n"));
        arrayList.add(new Person("One App for your health!\n","CareTaker from Simple,Wanderlust & more\n"));
        arrayList.add(new Person("End of season savings!\n","Get upto 50% off on 50+ diseases Test + Free Blood Checkup on all Tests!\n"));
        arrayList.add(new Person("Get the Blood Pressure Test for less\n","Enjoy UPTO 30% OFF on Test\n"));
        arrayList.add(new Person("Are you missing offers?\n","We have good news! The offers have been extended.\nGet your test before they appointment run out.\n"));
        arrayList.add(new Person("Cyber Monday Special\n","Get UPTO 40% Off on EyeWear.\n"));
        arrayList.add(new Person("Welcome to 2024 with exciting offers\n","Use Code 'WELCOME2024' & get upto 50-80% off on all tests.\n"));
        arrayList.add(new Person("URGENT:\n","Hire Cardiologists within Rs 2000.\n"));


        PersonAdapter personAdapter = new PersonAdapter(this,R.layout.list_row,arrayList);

        listView.setAdapter(personAdapter);

    }
}