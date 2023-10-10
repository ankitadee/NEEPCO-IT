package com.example.neepco;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class issue extends AppCompatActivity {

    TextView TextView;
    EditText Loc, Phone, Name, Issue, Date;
    DatabaseReference db;


    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.issue);
        TextView = findViewById(R.id.textView);
        Loc = findViewById(R.id.loc);
        Phone = findViewById(R.id.phone);
        Name = findViewById(R.id.name);
        Issue = findViewById(R.id.issue);
        Date = findViewById(R.id.date);
        db= FirebaseDatabase.getInstance("https://neepco-ef97a-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();
    }

    public void addUser (View view){
            if (Name.getText().toString().length() > 0
                    && Issue.getText().toString().length() > 0
                    && Loc.getText().toString().length() > 0) {
                NewUserdata userdata = new NewUserdata(
                        Name.getText().toString(),
                        Issue.getText().toString(),
                        Loc.getText().toString(),
                        Phone.getText().toString(),
                        Date.getText().toString()
                );
                db.child("UserData")
                        .child(Name.getText().toString())
                        .setValue(userdata)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(issue.this, "Issue send succesfully", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(issue.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
            }
            else
                Toast.makeText(this, "invalid data", Toast.LENGTH_SHORT).show();


    }
}