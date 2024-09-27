package com.example.careproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button logout, bookappointment;
    ImageButton notifi, percentage, whatapp, booked, support, chatbot;



    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAuth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                finish();
            }
        });

        notifi = findViewById(R.id.notifi);
        notifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, Notification.class));
            }
        });

        percentage = findViewById(R.id.percentage);
        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, Offers.class));
            }
        });

        whatapp = findViewById(R.id.whatapp);
        whatapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Please install Whatsapp to avail this feature.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        booked = findViewById(R.id.booked);
        booked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, MyBookings.class));
            }
        });

        support = findViewById(R.id.support);
        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, Help.class));
            }
        });

        bookappointment = findViewById(R.id.bookappointment);
        bookappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, BookAppointment.class));
            }
        });

        chatbot = findViewById(R.id.chatbot);
        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, ChatBot.class));
            }
        });



    }
}