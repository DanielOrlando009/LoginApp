package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class LoggedAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_admin);
        MaterialButton btnRisks = (MaterialButton)  findViewById(R.id.btnRisks);
        MaterialButton btnDash = (MaterialButton)  findViewById(R.id.btnDash);
        MaterialButton btnSignOut = (MaterialButton) findViewById(R.id.btnSignOut);


        btnRisks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRiskFactorsActivity();
            }
        });

        btnDash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDashboardActivity();
            }
        });

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

    }

    public void openRiskFactorsActivity(){
        Intent intent = new Intent(this, RiskFactorsActivity.class);
        startActivity(intent);

    }

    public void openDashboardActivity(){
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);

    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}