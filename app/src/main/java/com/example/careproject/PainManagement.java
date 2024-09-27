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

public class PainManagement extends AppCompatActivity {

    ListView listviewpain;

    ImageButton backpain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pain_management);

        backpain = findViewById(R.id.backpain);
        backpain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PainManagement.this, BookAppointment.class));
            }
        });

        listviewpain = findViewById(R.id.listviewpain);

        List<String> list = new ArrayList<>();
        list.add("Dr G.P. Dureja\nPain Management Specialist\nDelhi Pain Management Centre\nRajouri Garden Delhi\n47 yrs exp.₹600\n");
        list.add("Dr Neeraj Jain\nPain Management Specialist\nSpine Disc & Pain Clinics\nPitampura Delhi\n42 yrs exp.₹600\n");
        list.add("Dr Amod Manocha\nPain Management Specialist\nMax Hospital\nSaket Delhi\n26 yrs exp.₹1200\n");
        list.add("Dr Manish Raj\nPain Management Specialist\nSCI International Hospital\nGreater Kailash Delhi\n19 yrs exp.₹1000\n");
        list.add("Dr Madhur Chadha\nPain Management Specialist\nPrimus Super Speciality Hospital\nChanakya Puri Delhi\n18 yrs exp.₹700\n");
        list.add("Dr Gaurav Chanana\nPain Management Specialist\nMax Super Speciality Hospital\nSaket Delhi\n19 yrs exp.₹800\n");


        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listviewpain.setAdapter(arrayAdapter);

        listviewpain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listviewpain.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                intent.putExtra("name",str);
                startActivity(intent);
                if (position==0){

                    startActivity(new Intent(PainManagement.this, DateActivity.class));
                }
                else if (position==1){

                    startActivity(new Intent(PainManagement.this, DateActivity.class));
                }
            }
        });
    }
}