package com.example.careproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class GuestActivity extends AppCompatActivity {

    ImageButton bookedtemp, guestwhatsapp, guestnotifi, guestoffers, guestsupport;
    Button loginguest, guestappointment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        bookedtemp = findViewById(R.id.bookedtemp);
        bookedtemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuestActivity.this, GuestLoginInterface.class));
            }
        });

        loginguest = findViewById(R.id.loginguest);
        loginguest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuestActivity.this, LoginActivity.class));
            }
        });

        guestwhatsapp = findViewById(R.id.guestwhatsapp);
        guestwhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GuestActivity.this, "Please install Whatsapp to avail this feature.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        guestnotifi = findViewById(R.id.guestnotifi);
        guestnotifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuestActivity.this, GuestLoginInterface.class));
            }
        });

        guestoffers = findViewById(R.id.guestoffers);
        guestoffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuestActivity.this, GuestLoginInterface.class));
            }
        });

        guestsupport = findViewById(R.id.guestsupport);
        guestsupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuestActivity.this, GuestLoginInterface.class));
            }
        });

        guestappointment = findViewById(R.id.guestappointment);
        guestappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuestActivity.this, GuestLoginInterface.class));
            }
        });
    }
}