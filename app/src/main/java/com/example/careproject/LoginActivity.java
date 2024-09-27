package com.example.careproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {
    EditText phoneedit, verifyotp;
    Button btnpin, btnotp, btnguest;
    FirebaseAuth mAuth;
    String verificationID;
    ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phoneedit = findViewById(R.id.phoneedit);
        verifyotp = findViewById(R.id.verifyotp);
        btnpin = findViewById(R.id.btnpin);
        btnotp = findViewById(R.id.btnotp);
        btnguest = findViewById(R.id.btnguest);
        mAuth = FirebaseAuth.getInstance();
        bar = findViewById(R.id.bar);

        btnguest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, GuestActivity.class));
            }
        });

        btnpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(phoneedit.getText().toString()))
                {
                    Toast.makeText(LoginActivity.this,"Enter Valid Phone No.",Toast.LENGTH_SHORT).show();
                }
                else {
                    String number = phoneedit.getText().toString();
                    bar.setVisibility(View.VISIBLE);
                    sendverificationcode(number);
                }
            }
        });

        btnotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(verifyotp.getText().toString()))
                {
                    Toast.makeText(LoginActivity.this,"Wrong OTP Entered",Toast.LENGTH_SHORT).show();
                }
                else
                verifycode(verifyotp.getText().toString());
            }
        });


    }

    private void sendverificationcode(String phoneNumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91"+phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // (optional) Activity for callback binding
                        // If no activity is passed, reCAPTCHA verification can not be used.
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
    mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {

          final String code = credential.getSmsCode();
          if (code!=null)
          {
              verifycode(code);
          }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {

            Toast.makeText(LoginActivity.this, "Verification Failed", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent(@NonNull String s,
                @NonNull PhoneAuthProvider.ForceResendingToken token) {

            super.onCodeSent(s, token);
            verificationID = s;
            Toast.makeText(LoginActivity.this, "Code sent", Toast.LENGTH_SHORT).show();
            btnotp.setEnabled(true);
            bar.setVisibility(View.INVISIBLE);
        }
    };

    private void verifycode(String Code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationID,Code);
        signinbyCredentials(credential);
    }

    private void signinbyCredentials(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        }
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser!=null)
        {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
        }
    }
}