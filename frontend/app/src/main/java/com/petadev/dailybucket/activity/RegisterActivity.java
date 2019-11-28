package com.petadev.dailybucket.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.petadev.dailybucket.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

    }

    public void onLoginClick(final View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void onRegisterButtonClick(final View view) {
        Intent intent = new Intent(this, AppSelectActivity.class);
        startActivity(intent);
    }
}
