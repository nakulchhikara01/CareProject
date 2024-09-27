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

public class Cardiologist extends AppCompatActivity {

    ListView listviewcardiologist;

    ImageButton backcardiologist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiologist);

        backcardiologist = findViewById(R.id.backcardiologist);
        backcardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Cardiologist.this, BookAppointment.class));
            }
        });

        listviewcardiologist = findViewById(R.id.listviewcardiologist);

        List<String> list = new ArrayList<>();
        list.add("Dr K.K. Sethi\nCardiologist\nDelhi Heart & Lung Institute\nRamakrishna Metro Station Delhi\n53 yrs exp.₹1500\n");
        list.add("Dr Rajiv Bajaj\nCardiologist\nBatra Hospital & Medical Research Centre\nTughlaqabad Delhi\n44 yrs exp.₹800\n");
        list.add("Dr Raheja Fortis Hospital\nCardiologist\nFortis Le Femme\nSheikh Sarai Delhi\n24 yrs exp.₹500\n");
        list.add("Dr Ripen Gupta\nCardiologist\nMax Smart Super Speciality Hospital\nCity Walk Mall Delhi\n32 yrs exp.₹1500\n");
        list.add("Dr Aman Makhija\nCardiologist\nPulse Skin & Heart Clinic\nMayur Vihar Phase 1 Delhi\n25 yrs exp.₹1000\n");
        list.add("Dr Sajal Gupta\nCardiologist\nManggalam Cardio Neuro Clinic\nKarkardooma Delhi\n20 yrs exp.₹800\n");


        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listviewcardiologist.setAdapter(arrayAdapter);

        listviewcardiologist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listviewcardiologist.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                intent.putExtra("name",str);
                startActivity(intent);
                if (position==0){

                    startActivity(new Intent(Cardiologist.this, DateActivity.class));
                }
                else if (position==1){

                    startActivity(new Intent(Cardiologist.this, DateActivity.class));
                }
            }
        });
    }
}