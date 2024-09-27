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

public class HairTransplantSurgeon extends AppCompatActivity {

    ListView listviewhair;

    ImageButton backhair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_transplant_surgeon);

        backhair = findViewById(R.id.backhair);
        backhair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HairTransplantSurgeon.this, BookAppointment.class));
            }
        });

        listviewhair = findViewById(R.id.listviewhair);

        List<String> list = new ArrayList<>();
        list.add("Dr Sunakshi Singh\nDermatologist\nPristyn Care Clinic\nGreater Kailash Delhi\n15 yrs exp.₹0\n");
        list.add("Dr Itishree Gupta\nDermatologist\nPristyn Care Clinic\nGurugram Sector 29 Haryana\n12 yrs exp.₹0\n");
        list.add("Dr Lokesh Handa\nDermatologist\nMed Esthetiks\nGreater Kailsh Delhi\n24 yrs exp.₹1000\n");
        list.add("Dr Ashwani Kumar\nDermatologist\nBliniq Cosmetic Surgery Clinic and Medspa\nQutab Vihar Delhi\n17 yrs exp.₹1000\n");
        list.add("Dr Sahil Singla\nDermatologist\nCenter for skin\nKarkardooma Delhi\n9 yrs exp.₹500\n");
        list.add("Dr Pankaj Chaturvedi\nDermatologist\nMedLinks\nSafdarjung Enclave Delhi\n19 yrs exp.₹1500\n");


        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listviewhair.setAdapter(arrayAdapter);

        listviewhair.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listviewhair.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                intent.putExtra("name",str);
                startActivity(intent);
                if (position==0){

                    startActivity(new Intent(HairTransplantSurgeon.this, DateActivity.class));
                }
                else if (position==1){

                    startActivity(new Intent(HairTransplantSurgeon.this, DateActivity.class));
                }
            }
        });
    }
}