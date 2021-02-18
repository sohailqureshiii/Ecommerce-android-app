package com.example.shopisthan_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginActivity extends AppCompatActivity {

    private Button  phonelog,google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phonelog = findViewById(R.id.gopopup);
        phonelog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        google = findViewById(R.id.google_signin);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}