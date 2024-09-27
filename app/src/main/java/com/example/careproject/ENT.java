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

public class ENT extends AppCompatActivity {

    ListView listviewent;

    ImageButton backent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ent);

        backent = findViewById(R.id.backent);
        backent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ENT.this, BookAppointment.class));
            }
        });

        listviewent = findViewById(R.id.listviewent);

        List<String> list = new ArrayList<>();
        list.add("Dr Pooja Choudhary\nENT\nGynae and ENT Clinic\nSafarjung Enclave Delhi\n23 yrs exp.₹900\n");
        list.add("Dr Rohit Rajput\nENT\nDr Rohit Rajput's ENT Clinic\nJanakpuri Delhi\n25 yrs exp.₹700\n");
        list.add("Dr Shalabh Sharma\nENT\nENT & Dental Centre\nVasant Vihar Delhi\n34 yrs exp.₹3000\n");
        list.add("Dr Sumit Mrig\nENT\nSankalp ENT & Cochlear Implant Centre\nVisakhapatnam\n24 yrs exp.₹800\n");
        list.add("Dr Ajay Jain\nENT\nDr Jain ENT Clinic\nPreet Vihar Delhi\n28 yrs exp.₹800\n");
        list.add("Dr Rajeev Nangia\nENT\nRatan ENT Clinic\nNew Delhi Delhi\n38 yrs exp.₹1200\n");


        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listviewent.setAdapter(arrayAdapter);

        listviewent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listviewent.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                intent.putExtra("name",str);
                startActivity(intent);
                if (position==0){

                    startActivity(new Intent(ENT.this, DateActivity.class));
                }
                else if (position==1){

                    startActivity(new Intent(ENT.this, DateActivity.class));
                }
            }
        });
    }
}