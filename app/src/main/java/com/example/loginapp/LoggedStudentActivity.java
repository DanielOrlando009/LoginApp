package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class LoggedStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_student);

        MaterialButton btnLinks = (MaterialButton)  findViewById(R.id.btnLinks);
        MaterialButton btnCalen = (MaterialButton)  findViewById(R.id.btnCalen);
        MaterialButton btnMarks = (MaterialButton)  findViewById(R.id.btnMarks);
        MaterialButton btnSignOut = (MaterialButton) findViewById(R.id.btnSignOut);


        btnLinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLinksActivity();
            }
        });

        btnCalen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCalenderActivity();
            }
        });

        btnMarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMarksCalcActivity();
            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

    }

    public void openLinksActivity(){
        Intent intent = new Intent(this, LinksActivity.class);
        startActivity(intent);

    }

    public void openCalenderActivity(){
        Intent intent = new Intent(this, CalenderActivity.class);
        startActivity(intent);

    }

    public void openMarksCalcActivity(){
        Intent intent = new Intent(this, MarksCalcActivity.class);
        startActivity(intent);

    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}