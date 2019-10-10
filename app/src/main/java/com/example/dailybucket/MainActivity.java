package com.example.dailybucket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanseState) {
        super.onCreate(savedInstanseState);
        setContentView(R.layout.activity_main);
    }
    public void openActivity (View view)
    {
        Intent intent =new Intent (this,LoginActivity.class);
        startActivity (intent);
    }
}


