package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.daclink.drew.sp22.cst438_project01_starter.databinding.ActivitySignupBinding;


public class SignUpActivity extends AppCompatActivity {
    private ActivitySignupBinding binding;
    AppDatabase AppDb;
    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDb = AppDatabase.getInstance(this);
        userDAO = AppDb.getUserDao();

        if(userDAO.getUser("admin") == null){// means there is no admin user
           //create admin user
            User admin = new User("admin",
                    "admin", "admin", "admin");
            admin.setAdmin(true);

            userDAO.insertUser(admin);
        }

        binding.button.setOnClickListener(v1 -> saveUser(v1));
    }

    public void saveUser(View v) {
        String firstName = binding.firstName.getText().toString();
        String lastName = binding.lastName.getText().toString();
        String username = binding.username.getText().toString();
        String password = binding.password.getText().toString();

        // username or password is empty
        if (username.length() == 0 || password.length() == 0) {
            Toast.makeText(this, R.string.input_length_error, Toast.LENGTH_SHORT).show();
            return;
        }

        // username is already taken
        if (userDAO.getUser(username) != null) {
            Toast.makeText(this, R.string.user_already_exists_error, Toast.LENGTH_SHORT).show();
            return;
        }

        User user = new User(firstName, lastName, username, password);
        userDAO.insertUser(user);

        // Return to main activity
        startActivity(new Intent(this, MainActivity.class));
    }

}