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

public class ShoulderSpecialist extends AppCompatActivity {

    ListView listviewshoulder;

    ImageButton backshoulder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder_specialist);

        backshoulder = findViewById(R.id.backshoulder);
        backshoulder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShoulderSpecialist.this, BookAppointment.class));
            }
        });

        listviewshoulder = findViewById(R.id.listviewshoulder);

        List<String> list = new ArrayList<>();
        list.add("Dr Jitender Pal Singh\nOrthopedic Doctor\nBone And Joint Clinic\nPunjabi Bagh Delhi\n25 yrs exp.₹700\n");
        list.add("Dr Shekhar Srivastav\nOrthopedic Doctor\nSant Parmanand Hospital\nCivil Lines Delhi\n30 yrs exp.₹1000\n");
        list.add("Dr Abhimanyu Singh\nOrthopedic Doctor\nAvni Healthcare\nSector 24 Delhi\n22 yrs exp.₹300\n");
        list.add("Dr Joginder Kumar\nOrthopedic Doctor\nMax Super Speciality Hospital\nPanchsheel Delhi\n25 yrs exp.₹400\n");
        list.add("Dr Vipul Khera\nOrthopedic Doctor\nKhera Hospital\nNangloi Delhi\n26 yrs exp.₹300\n");
        list.add("Dr Rupali Solanke\nOrthopedic Doctor\nSelf\nRohini Sector 6 Delhi\n12 yrs exp.₹300\n");


        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listviewshoulder.setAdapter(arrayAdapter);

        listviewshoulder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listviewshoulder.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                intent.putExtra("name",str);
                startActivity(intent);
                if (position==0){

                    startActivity(new Intent(ShoulderSpecialist.this, DateActivity.class));
                }
                else if (position==1){

                    startActivity(new Intent(ShoulderSpecialist.this, DateActivity.class));
                }
            }
        });
    }
}