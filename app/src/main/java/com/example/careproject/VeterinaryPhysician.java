package com.example.careproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class VeterinaryPhysician extends AppCompatActivity {

    ListView listviewveterinary;

    ImageButton backveterinary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinary_physician);

        backveterinary = findViewById(R.id.backveterinary);
        backveterinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VeterinaryPhysician.this, BookAppointment.class));
            }
        });

        listviewveterinary = findViewById(R.id.listviewveterinary);

        List<String> list = new ArrayList<>();
        list.add("Dr Ajay Rana\nBVSc\nNew Delhi Veterinary Clinic\nKailash Colony Delhi\n27 yrs exp.₹400\n");
        list.add("Dr Ranjith Jha Kumar\nBVSc\nPet Concern Clinic\nLajpat Nagar Delhi\n23 yrs exp.₹0\n");
        list.add("Dr Kumar\nBVSc\nDog and Cat Clinic\nC R Park Delhi\n14 yrs exp.₹499\n");
        list.add("Dr S.K. Singh\nBVSc\nVET PLUS DOG AND CAT CLINIC DELHI\nShakti Nagar Delhi\n13 yrs exp.₹499\n");
        list.add("Dr Dinesh Jaiswal\nBVSc\nDr Kharab's Pet Clinic and Surgery\nMunirka Delhi\n14 yrs exp.₹499\n");
        list.add("Dr I S Kothari\nBVSc\nSouth Delhi Pet Clinic\nSaket Delhi\n32 yrs exp.₹300\n");


        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listviewveterinary.setAdapter(arrayAdapter);

        listviewveterinary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listviewveterinary.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                intent.putExtra("name",str);
                startActivity(intent);
                if (position==0){

                    startActivity(new Intent(VeterinaryPhysician.this, DateActivity.class));
                }
                else if (position==1){

                    startActivity(new Intent(VeterinaryPhysician.this, DateActivity.class));
                }
            }
        });
    }
}