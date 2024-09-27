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

public class CardiacSurgeon extends AppCompatActivity {

    ListView listviewcardiac;

    ImageButton backcardiac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardiac_surgeon);

        backcardiac = findViewById(R.id.backcardiac);
        backcardiac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CardiacSurgeon.this, BookAppointment.class));
            }
        });

        listviewcardiac = findViewById(R.id.listviewcardiac);

        List<String> list = new ArrayList<>();
        list.add("Dr Gaurav Gupta\nCardiologist\nPSRI Hospital\nEnclave Marg Delhi\n27 yrs exp.₹1200\n");
        list.add("Dr Upendra Kaul\nCardiologist\nBatra Hospital & Medical Research\nTughlaqabad Delhi\n54 yrs exp.₹700\n");
        list.add("Dr Z S Mehrawal\nCardiologist\nFortis Escorts Heart Institute\nOkhla Delhi\n36 yrs exp.₹2000\n");
        list.add("Dr Dinesh Kumar Mittal\nCardiologist\nFortis Hospital\nShalimar Bagh Delhi\n30 yrs exp.₹1000\n");
        list.add("Dr Yugal K Mishra\nCardiologist\nManipal Hospital Dwarka\nDwarka Sector 6 Delhi\n44 yrs exp.₹1000\n");
        list.add("Dr S.N. Khanna\nCardiologist\nFortis Escorts Heart Institute\nSukhdev VIhar Delhi\n38 yrs exp.₹1500\n");


        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        listviewcardiac.setAdapter(arrayAdapter);

        listviewcardiac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listviewcardiac.getAdapter().getItem(position).toString();
                Intent intent = new Intent(getApplicationContext(), DateActivity.class);
                intent.putExtra("name",str);
                startActivity(intent);
                if (position==0){

                    startActivity(new Intent(CardiacSurgeon.this, DateActivity.class));
                }
                else if (position==1){

                    startActivity(new Intent(CardiacSurgeon.this, DateActivity.class));
                }
            }
        });
    }
}