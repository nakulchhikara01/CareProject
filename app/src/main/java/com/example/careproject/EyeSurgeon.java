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

public class EyeSurgeon extends AppCompatActivity {
    ListView listvieweyesurgeon;

    ImageButton backeyesurgeon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_surgeon);

        backeyesurgeon = findViewById(R.id.backeyesurgeon);
        backeyesurgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EyeSurgeon.this, BookAppointment.class));
            }
        });

        listvieweyesurgeon = findViewById(R.id.listvieweyesurgeon);

        List<String> list = new ArrayList<>();
        list.add("Dr Sanjeev Bisla\nOphthalmologist\nPristyn Care Clinic\nRohini Sector 3 Delhi\n23 yrs exp.₹0\n");
        list.add("Dr Ravi Thadani\nOphthalmologist\nRavi Eye Foundation\nNajafgarh Delhi\n43 yrs exp.₹700\n");
        list.add("Dr Ashwani Kumar Ghai\nOphthalmologist\nDr Ashwani Ghai Eye Care Clinic\nRohini Delhi\n27 yrs exp.₹300\n");
        list.add("Dr Minal Kaur\nOphthalmologist\nShroff Eye Centre\nSheikh Sarai Delhi\n23 yrs exp.₹499\n");
        list.add("Dr Deepa Kapoor\nOphthalmologist\nVision Clinic\nKalkaji Delhi\n34 yrs exp.₹600\n");
        list.add("Dr Piyush Kapur\nOphthalmologist\nThe Healing Touch Eye & Maternity Centre\nVikas Puri Delhi\n27 yrs exp.₹800\n");


        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listvieweyesurgeon.setAdapter(arrayAdapter);

        listvieweyesurgeon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listvieweyesurgeon.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                intent.putExtra("name",str);
                startActivity(intent);
                if (position==0){

                    startActivity(new Intent(EyeSurgeon.this, DateActivity.class));
                }
                else if (position==1){

                    startActivity(new Intent(EyeSurgeon.this, DateActivity.class));
                }
            }
        });
    }
}