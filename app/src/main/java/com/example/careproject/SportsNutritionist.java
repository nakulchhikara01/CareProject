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

public class SportsNutritionist extends AppCompatActivity {

    ListView listviewsports;

    ImageButton backsports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_nutritionist);

        backsports = findViewById(R.id.backsports);
        backsports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SportsNutritionist.this, BookAppointment.class));
            }
        });

        listviewsports = findViewById(R.id.listviewsports);

        List<String> list = new ArrayList<>();
        list.add("Dr Nutri Kalp Clinic\nDietitian/Nutritionist\nNutri Kalp\nRohini Delhi\n32 yrs exp.₹500\n");
        list.add("Dr Swarnshikha Sharma\nDietitian/Nutritionist\nRising Health\nGreater Kailash Delhi\n16 yrs exp.₹300\n");
        list.add("Dr Ritika Dua\nDietitian/Nutritionist\nDietitian And Nutritian\nDerawal Nagar Delhi\n24 yrs exp.₹1000\n");
        list.add("Dr Kritika Bhola\nDietitian/Nutritionist\nCurewell Therapies\nSultanpur Delhi\n19 yrs exp.₹500\n");
        list.add("Dr Nehha Ahuja\nDietitian/Nutritionist\nDiet Centre\nPatel Nagar Delhi\n16 yrs exp.₹500\n");
        list.add("Dr Divya Gandhi\nDietitian/Nutritionist\nDivya Gandhi Diet N Cure Clinic\nAshok Vihar Delhi\n12 yrs exp.₹3000\n");

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listviewsports.setAdapter(arrayAdapter);

        listviewsports.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listviewsports.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                intent.putExtra("name",str);
                startActivity(intent);
                if (position==0){

                    startActivity(new Intent(SportsNutritionist.this, DateActivity.class));
                }
                else if (position==1){

                    startActivity(new Intent(SportsNutritionist.this, DateActivity.class));
                }
            }
        });
    }
}