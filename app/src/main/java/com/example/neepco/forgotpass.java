package com.example.neepco;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

import java.util.Objects;

public class forgotpass extends AppCompatActivity {


    Button mButton4, mButton5;
    TextView mText5;
    EditText mMail;
    FirebaseAuth fAuth;
    String strMail;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpass);
        mButton4 = findViewById(R.id.button4);
        mButton5 = findViewById(R.id.button5);
        mText5 = findViewById(R.id.text5);
        mMail = findViewById(R.id.mail);

        fAuth = FirebaseAuth.getInstance();

        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(forgotpass.this, employee.class);
                startActivity(intent);

            }
        });


        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strMail = mMail.getText().toString().trim();
                if (!TextUtils.isEmpty(strMail)) {
                    ResetPassword();
                } else {
                    mMail.setError("Email field can't be empty");
                }
            }
        });
    }
    private  void ResetPassword(){
        mButton4.setVisibility(View.INVISIBLE);
        fAuth.sendPasswordResetEmail(strMail)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(forgotpass.this, "Reset Password Link Has Been Sent To Your Registered Email", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(forgotpass.this, employee.class);
                        startActivity(intent);
                        finish();

                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(forgotpass.this, "Error :- " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        mButton4.setVisibility(View.VISIBLE);
                    }
                });
    }
}



