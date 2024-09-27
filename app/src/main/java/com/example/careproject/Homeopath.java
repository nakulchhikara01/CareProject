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

public class Homeopath extends AppCompatActivity {

    ListView listviewhomeopath;

    ImageButton backhomeopath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeopath);
        backhomeopath = findViewById(R.id.backhomeopath);
        backhomeopath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homeopath.this, BookAppointment.class));
            }
        });

        listviewhomeopath = findViewById(R.id.listviewhomeopath);

        List<String> list = new ArrayList<>();
        list.add("Dr Rashid Akhtar\nHomeopathy Doctor\nDr Rana's Health Care Centre\nKrishan Nagar Delhi\n23 yrs exp.₹600\n");
        list.add("Dr Mukesh Singh\nHomeopathy Doctor\nMission Chronic Cure\nMayur Vihar Delhi\n23 yrs exp.₹500\n");
        list.add("Dr Sanket Gupta\nHomeopathy Doctor\nHomoeo\nSatya Niketan Delhi\n15 yrs exp.₹499\n");
        list.add("Dr Swati\nHomeopathy Doctor\nHarmony Homoeo Heal\nDwarka Delhi\n9 yrs exp.₹500\n");
        list.add("Dr Ranjana Gupta\nHomeopathy Doctor\nSanjeevni Homeo Clinic\nDwarka Delhi\n27 yrs exp.₹500\n");
        list.add("Dr Hemant Kumar Mittal\nHomeopathy Doctor\nHealing Touch Homoeopathy\nRohini Delhi\n16 yrs exp.₹800\n");

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listviewhomeopath.setAdapter(arrayAdapter);

        listviewhomeopath.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listviewhomeopath.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                intent.putExtra("name",str);
                startActivity(intent);
                if (position==0){

                    startActivity(new Intent(Homeopath.this, DateActivity.class));
                }
                else if (position==1){

                    startActivity(new Intent(Homeopath.this, DateActivity.class));
                }
            }
        });
    }
}