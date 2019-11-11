package com.example.dailybucket;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanseState) {
        super.onCreate(savedInstanseState);
        setContentView(R.layout.login_activity);
    }
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        @SuppressLint("WrongViewCast") Button button2 = findViewById(R.id.image2);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button2) {
            Intent intent1 = new Intent(this, RegisterActivity.class);
            startActivity(intent1);
        }