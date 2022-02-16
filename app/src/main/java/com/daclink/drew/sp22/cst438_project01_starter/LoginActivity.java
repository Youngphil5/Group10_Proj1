package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.daclink.drew.sp22.cst438_project01_starter.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    AppDatabase AppDb;
    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDb = AppDatabase.getInstance(this);
        userDAO = AppDb.getUserDao();

        binding.button2.setOnClickListener(v1 -> attemptLogin(v1));
    }

    public void attemptLogin(View v) {
        String input_username = binding.lUsername.getText().toString();
        String input_password = binding.lPassword.getText().toString();

        if (input_username.length() == 0 || input_password.length() == 0) {
            Toast.makeText(this, R.string.input_length_error, Toast.LENGTH_SHORT).show();
            return;
        }

        User user = userDAO.getUser(input_username);
        if (user == null) {
            Toast.makeText(this, R.string.user_not_found_error, Toast.LENGTH_SHORT).show();
            return;
        }

        if (user.getPassword().equals(input_password)) {
            // go to home activity
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.invalid_password_error, Toast.LENGTH_SHORT).show();
        }
    }
}