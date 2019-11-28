package com.petadev.dailybucket.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.petadev.dailybucket.R;

public class LoginActivity extends AppCompatActivity {
    private EditText emailInput;
    private EditText passwordInput;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        this.emailInput = findViewById(R.id.input_email);
        this.passwordInput = findViewById(R.id.input_password);
        this.firebaseAuth = FirebaseAuth.getInstance();
    }

    public void onSignUpClicked(final View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    public void onLoginClicked(final View view) {
        Editable email = emailInput.getText();
        Editable password = passwordInput.getText();

        if (email.length() == 0 || password.length() == 0) {
            new AlertDialog.Builder(this)
                    .setTitle("Fill")
                    .setMessage("Please provide the email and the password!")
                    .show();
        } else {
            this.firebaseAuth.signInWithEmailAndPassword(
                    email.toString(),
                    password.toString()
            ).addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Authentication succeeded!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Authentication failed!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
