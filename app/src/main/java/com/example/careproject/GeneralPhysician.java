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

public class GeneralPhysician extends AppCompatActivity {

    ListView listviewgeneral;

    ImageButton backgeneral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_physician);

        backgeneral = findViewById(R.id.backgeneral);
        backgeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GeneralPhysician.this, BookAppointment.class));
            }
        });

        listviewgeneral = findViewById(R.id.listviewgeneral);

        List<String> list = new ArrayList<>();
        list.add("Dr Prakhar Singh\nGeneral Physician\nSama Hospital\nSiri Fort Delhi\n10 yrs exp.₹500\n");
        list.add("Dr Anil Mehta\nGeneral Physician\nAakash Medical Centre\nSheikh Sarai Delhi\n30 yrs exp.₹500\n");
        list.add("Dr Ajit K Thakur\nGeneral Physician\nAl Shifa Hospital\nOkhla Delhi\n25 yrs exp.₹500\n");
        list.add("Dr Hanish Gupta\nGeneral Physician\nLifeAID Clinia\nMayur Vihar Delhi\n21 yrs exp.₹700\n");
        list.add("Dr Rajiva Gupta\nGeneral Physician\nCK Birla Hospital\nPunjabi Bagh Delhi\n44 yrs exp.₹1500\n");
        list.add("Dr Ranneek Verma\nGeneral Physician\nSukhmani Hospital\nSafdarjung Enclave Delhi\n48 yrs exp.₹1200\n");


        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listviewgeneral.setAdapter(arrayAdapter);

        listviewgeneral.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listviewgeneral.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                intent.putExtra("name",str);
                startActivity(intent);
                if (position==0){

                    startActivity(new Intent(GeneralPhysician.this, DateActivity.class));
                }
                else if (position==1){

                    startActivity(new Intent(GeneralPhysician.this, DateActivity.class));
                }
            }
        });
    }
}