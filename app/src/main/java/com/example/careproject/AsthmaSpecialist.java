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

public class AsthmaSpecialist extends AppCompatActivity {

    ListView listviewasthma;

    ImageButton backasthma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asthma_specialist);
        backasthma = findViewById(R.id.backasthma);
        backasthma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AsthmaSpecialist.this, BookAppointment.class));
            }
        });

        listviewasthma = findViewById(R.id.listviewasthma);

        List<String> list = new ArrayList<>();
        list.add("Dr Hemant Kalra\nPulmonologist\nMaharaja Agrasain Super Speciality Chest Center\nAshok Vihar Delhi\n29 yrs exp.₹1000\n");
        list.add("Dr (Brig.) Ashok Rajput\nPulmonologist\nResidence Cum Clinic\nPitampura Delhi\n47 yrs exp.₹1200\n");
        list.add("Dr Prashant Saxena\nPulmonologist\nFortis Hospital\nVasant Kunj Delhi\n21 yrs exp.₹1000\n");
        list.add("Dr Vikas Maurya\nPulmonologist\nNoble Asthma Allergy & Chest Clinic\nKarol Bagh Delhi\n26 yrs exp.₹800\n");
        list.add("Dr Kshitij Kalra\nPulmonologist\nDr Kalra's Chest & Multispeciality Centre\nPaschim Vihar Delhi\n9 yrs exp.₹500\n");
        list.add("Dr A.P. Bhatia\nPulmonologist\nDr A.P. Bhatia Clinic\nKrishna Nagar Delhi\n35 yrs exp.₹500\n");



        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listviewasthma.setAdapter(arrayAdapter);

        listviewasthma.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listviewasthma.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                intent.putExtra("name",str);
                startActivity(intent);
                if (position==0){

                    startActivity(new Intent(AsthmaSpecialist.this, DateActivity.class));
                }
                else if (position==1){

                    startActivity(new Intent(AsthmaSpecialist.this, DateActivity.class));
                }
            }
        });
    }
}