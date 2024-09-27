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

public class Ayurveda extends AppCompatActivity {

    ListView listviewayurveda;

    ImageButton backayurveda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayurveda);

        backayurveda = findViewById(R.id.backayurveda);
        backayurveda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Ayurveda.this, BookAppointment.class));
            }
        });

        listviewayurveda = findViewById(R.id.listviewayurveda);

        List<String> list = new ArrayList<>();
        list.add("Dr G S Lavekar\nAyurvedic Doctor\nLavekar Clinic\nDwarka Delhi\n49 yrs exp.₹500\n");
        list.add("Dr Jiva Ayurveda\nAyurvedic Doctor\nJiva Ayurveda\nShahdara Delhi\n26 yrs exp.₹299\n");
        list.add("Dr Rakesh Agarwal\nAyurvedic Doctor\nArogyadham Ayurveda Treatment Centre\nKalkaji Delhi\n43 yrs exp.₹499\n");
        list.add("Dr Ashish Sharma\nAyurvedic Doctor\nThe Arogyam Ayurveda\nPaschim Vihar Delhi\n18 yrs exp.₹500\n");
        list.add("Dr Sunny Chopra Orthopaedics Gold Medalist\nAyurvedic Doctor\nDr Chopras Spine Joint Solutions\nMoti Nagar Delhi\n14 yrs exp.₹500\n");
        list.add("Dr Mahesh Shah\nAyurvedic\nHakim Hari Kishan Lal Clinic\nPatel Nagar Delhi\n55 yrs exp.₹50\n");


        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listviewayurveda.setAdapter(arrayAdapter);

        listviewayurveda.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listviewayurveda.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                intent.putExtra("name",str);
                startActivity(intent);
                if (position==0){

                    startActivity(new Intent(Ayurveda.this, DateActivity.class));
                }
                else if (position==1){

                    startActivity(new Intent(Ayurveda.this, DateActivity.class));
                }
            }
        });
    }
}