package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class LinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        MaterialButton btnReturn = (MaterialButton)  findViewById(R.id.btnReturn);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoggedStudentActivity();
            }
        });
    }

    public void openLoggedStudentActivity(){
        Intent intent = new Intent(this, LoggedStudentActivity.class);
        startActivity(intent);

    }
}