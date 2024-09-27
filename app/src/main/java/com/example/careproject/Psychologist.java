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

public class Psychologist extends AppCompatActivity {

    ListView listviewsycho;

    ImageButton backsycho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psychologist);

        backsycho = findViewById(R.id.backsycho);
        backsycho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Psychologist.this, BookAppointment.class));
            }
        });

        listviewsycho = findViewById(R.id.listviewsycho);

        List<String> list = new ArrayList<>();
        list.add("Dr Vikas Khanna\nPsychologist\nKhanna's Counseling & Hypnotherapy Clinic\nRajouri Garden Delhi\n24 yrs exp.₹1800\n");
        list.add("Dr Pooja Anand Sharma\nPsychologist\nVishwas Healing Centre\nRohini Delhi\n20 yrs exp.₹2000\n");
        list.add("Dr Aradhana Sharma\nPsychologist\nAnubhuti Clinic\nPitampura Delhi\n33 yrs exp.₹1000\n");
        list.add("Dr Arti Anand\nPsychologist\nEast West Medical Centre\nGolf Link Delhi\n30 yrs exp.₹2000\n");
        list.add("Dr Prabhjeet Singh Narula\nPsychologist\nPSY Signs\nMalviya Nagar Delhi\n11 yrs exp.₹1200\n");
        list.add("Dr Rachna Mishra\nPsychologist\nSAMBHAV CLINIC\nDwarka Mor Delhi\n12 yrs exp.₹1500\n");


        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listviewsycho.setAdapter(arrayAdapter);

        listviewsycho.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listviewsycho.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                intent.putExtra("name",str);
                startActivity(intent);
                if (position==0){

                    startActivity(new Intent(Psychologist.this, DateActivity.class));
                }
                else if (position==1){

                    startActivity(new Intent(Psychologist.this, DateActivity.class));
                }
            }
        });
    }
}