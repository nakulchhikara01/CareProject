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

public class Dentist extends AppCompatActivity {

    ListView listView;

    ImageButton backdentist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dentist);

        backdentist = findViewById(R.id.backdentist);
        backdentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dentist.this, BookAppointment.class));
            }
        });

        listView = findViewById(R.id.listview);

        List<String> list = new ArrayList<>();
        list.add("Dr Devaanshu Dewan\nDentist\nS.K. Dental Care\nUttam Nagar Delhi\n19 yrs exp.₹499\n");
        list.add("Dr Rachit Walia\nDentist\nK.V. Dentals\nGulabi Bagh Delhi\n20 yrs exp.₹500\n");
        list.add("Dr Vikas Yadav\nDentist\nMEDIDENT SUPERSPECIALITY DENTAL\nNajafgarh Delhi\n9 yrs exp.₹499\n");
        list.add("Dr Shipra Rawal\nDentist\nDr Rawal Dental Centre\nUttam Nagar Delhi\n29 yrs exp.₹400\n");
        list.add("Dr Avinash Singh\nDentist\nAmar Dental Clinic\nNawada Delhi\n21 yrs exp.₹300\n");
        list.add("Dr Aashish Pandit\nDentist\nDr Pandit's Dental & Implant Center\nVashist Park Delhi\n14 yrs exp.₹300\n");
        list.add("Dr Vineet Kapoor\nDentist\nCures n Care Dental Clinic\nMayur Vihar Delhi\n16 yrs exp.₹300\n");
        list.add("Dr Amardeep Singh Arora\nDentist\nDr Amar Tooth Town\nVasant Vihar Delhi\n13 yrs exp.₹500\n");


        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listView.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                intent.putExtra("name",str);
                startActivity(intent);
                if (position==0){

                    startActivity(new Intent(Dentist.this, DateActivity.class));
                }
                else if (position==1){

                    startActivity(new Intent(Dentist.this, DateActivity.class));
                }
            }
        });

    }
}