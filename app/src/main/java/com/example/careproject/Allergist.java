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

public class Allergist extends AppCompatActivity {

    ListView listviewallergist;

    ImageButton backallergist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergist);
        backallergist = findViewById(R.id.backallergist);
        backallergist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Allergist.this, BookAppointment.class));
            }
        });

        listviewallergist = findViewById(R.id.listviewallergist);

        List<String> list = new ArrayList<>();
        list.add("Dr S GOEL\nENT & Allergist\nENT Specialist\nRohini Delhi\n14 yrs exp.₹499\n");
        list.add("Dr Rakesh Agarwal\nAllergist\nArogyadham Ayurveda Treatment Centre\nMuzzafarnagar\n43 yrs exp.₹300\n");

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listviewallergist.setAdapter(arrayAdapter);

        listviewallergist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listviewallergist.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                intent.putExtra("name",str);
                startActivity(intent);
                if (position==0){

                    startActivity(new Intent(Allergist.this, DateActivity.class));
                }
                else if (position==1){

                    startActivity(new Intent(Allergist.this, DateActivity.class));
                }
            }
        });
    }
}