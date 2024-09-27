package com.example.careproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class BookAppointment extends AppCompatActivity {

    ImageButton backappointment;

    ListView list_doctors;

    SearchView searchbarappointment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        backappointment = findViewById(R.id.backappointment);
        backappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookAppointment.this, HomeActivity.class));
            }
        });

        searchbarappointment = findViewById(R.id.searchbarappointment);

        list_doctors = findViewById(R.id.list_doctors);

        List<String> list = new ArrayList<>();
        list.add("Dentist");//0
        list.add("Ayurveda");//1
        list.add("General Physician");//2
        list.add("Dietitian");//3
        list.add("Homeopath");//4
        list.add("Allergist");//5
        list.add("Asthma Specialist");//6
        list.add("Cardiac Surgeon");//7
        list.add("Psychologist");//8
        list.add("Dental Surgeon");//9
        list.add("ENT");//10
        list.add("ENT Surgeon");//11
        list.add("Eye Surgeon");//12
        list.add("Hair Transplant Surgeon");//13
        list.add("Optician");//14
        list.add("Pain Management");//15
        list.add("Shoulder Specialist");//16
        list.add("Sports Nutritionist");//17
        list.add("Veterinary Physician");//18
        list.add("Cardiologist");//19


            ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,list);
        list_doctors.setAdapter(arrayAdapter);

        searchbarappointment.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                arrayAdapter.getFilter().filter(s);

                return false;
            }
        });


        list_doctors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    //dentist done
                    startActivity(new Intent(BookAppointment.this, Dentist.class));
                } else if (position==1) {
                    //ayurveda done
                    startActivity(new Intent(BookAppointment.this, Ayurveda.class));
                }
                else if (position==2) {
                    //General Physician done
                    startActivity(new Intent(BookAppointment.this, GeneralPhysician.class));
                }
                else if (position==3) {
                    //Dietitian done
                    startActivity(new Intent(BookAppointment.this, Dietitian.class));
                }
                else if (position==4) {
                    //Homeopath done
                    startActivity(new Intent(BookAppointment.this, Homeopath.class));
                }
                else if (position==5) {
                    //Allergist done
                    startActivity(new Intent(BookAppointment.this, Allergist.class));
                }
                else if (position==6) {
                    //Asthma Specialist done
                    startActivity(new Intent(BookAppointment.this, AsthmaSpecialist.class));
                }
                else if (position==7) {
                    //Cardiac Surgeon done
                    startActivity(new Intent(BookAppointment.this, CardiacSurgeon.class));
                }
                else if (position==8) {
                    //Psychologist done
                    startActivity(new Intent(BookAppointment.this, Psychologist.class));
                }
                else if (position==9) {
                    //Dental Surgeon done
                    startActivity(new Intent(BookAppointment.this, DentalSurgeon.class));
                }
                else if (position==10) {
                    //ENT done
                    startActivity(new Intent(BookAppointment.this, ENT.class));
                }
                else if (position==11) {
                    //ENT Surgeon done
                    startActivity(new Intent(BookAppointment.this, ENTSurgeon.class));
                }
                else if (position==12) {
                    //Eye Surgeon done
                    startActivity(new Intent(BookAppointment.this, EyeSurgeon.class));
                }
                else if (position==13) {
                    //Hair Transplant Surgeon done
                    startActivity(new Intent(BookAppointment.this, HairTransplantSurgeon.class));
                }
                else if (position==14) {
                    //Optician done
                    startActivity(new Intent(BookAppointment.this, Optician.class));
                }
                else if (position==15) {
                    //Pain Management done
                    startActivity(new Intent(BookAppointment.this, PainManagement.class));
                }
                else if (position==16) {
                    //Shoulder Specialist done
                    startActivity(new Intent(BookAppointment.this, ShoulderSpecialist.class));
                }
                else if (position==17) {
                    //Sports Nutritionist done
                    startActivity(new Intent(BookAppointment.this, SportsNutritionist.class));
                }
                else if (position==18) {
                    //Veterinary Physician done
                    startActivity(new Intent(BookAppointment.this, VeterinaryPhysician.class));
                }
                else {
                    //Cardiologist done
                    startActivity(new Intent(BookAppointment.this, Cardiologist.class));
                }
            }
        });





    }
}