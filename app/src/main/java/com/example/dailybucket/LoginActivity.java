package com.example.dailybucket;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    public void onClick(View view) {
        Log.d(getClass().getCanonicalName(), "!@#$ pressed");
        Intent intent1 = new Intent(this, RegisterActivity.class);
        startActivity(intent1);
    }

    public void onLoginClick(View view) {
        Log.d(getClass().getCanonicalName(), "!@#$ pressed222");

        EditText editText1 = findViewById(R.id.etName);
        EditText editText2 = findViewById(R.id.etPassword);
        TextView hiba = findViewById(R.id.hiba1);

        hiba.setVisibility(View.INVISIBLE);

        String username = editText1.getText().toString();
        String password = editText2.getText().toString();

        AuthenticationManager.logIn(username, password);
        if (AuthenticationManager.isLoggedIn()) {
//            Intent intent2 = new Intent(this, MainActivity.class);
//            startActivity(intent2);
            finish();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle("Hiba")
                    .setMessage("Helytelen adatok")
                    .show();


            hiba.setVisibility(View.VISIBLE);
        }
    }

}

