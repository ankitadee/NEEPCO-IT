package com.example.neepco;

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

import java.util.Objects;

public class admin extends AppCompatActivity {


    Button mButton;
    TextView mTextView4;
    EditText mPass;

    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.admin);
    mButton= findViewById(R.id.button);
    mTextView4= findViewById(R.id.textView4);
    mPass= findViewById(R.id.pass);

    mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String pass = mPass.getText().toString();
                String X = "IT123";
                if (pass.equals(X)) {
                    Intent intent = new Intent(admin.this, data.class);
                    startActivity(intent);
                }

            }
        });
    }
}



