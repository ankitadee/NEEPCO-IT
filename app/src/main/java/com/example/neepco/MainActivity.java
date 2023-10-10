package com.example.neepco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button mButton2, mButton;
    TextView mTextView2, mTextView3;
    ImageView mImageView, mImageView2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView2 = findViewById(R.id.textView2);
        mTextView3 = findViewById(R.id.textView3);
        mButton2 = findViewById(R.id.button2);
        mButton = findViewById(R.id.button);
        mImageView = findViewById(R.id.imageView);
        mImageView2 = findViewById(R.id.imageView2);

        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent( MainActivity.this, signup.class);
                startActivity(intent);
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, employee.class );
                startActivity(intent);
            }
        });
        

        
    }
}