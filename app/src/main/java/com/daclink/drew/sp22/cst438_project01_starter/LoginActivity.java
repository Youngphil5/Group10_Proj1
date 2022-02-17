package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.daclink.drew.sp22.cst438_project01_starter.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    AppDatabase AppDb;
    UserDAO userDAO;
    SharedPreferences preferences;
    SharedPreferences.Editor editPrefrences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        preferences = getApplicationContext().
                getSharedPreferences("lastLoginInfo",
                        MODE_PRIVATE);
        editPrefrences = preferences.edit();
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
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
        

        binding.button2.setOnClickListener(v1 -> attemptLogin(v1));
    }

    public void attemptLogin(View v) {
        String input_username = binding.lUsername.getText().toString();
        String input_password = binding.lPassword.getText().toString();

        // password or username is empty
        if (input_username.length() == 0 || input_password.length() == 0) {
            Toast.makeText(this, R.string.input_length_error, Toast.LENGTH_SHORT).show();
            return;
        }

        // user does not exist
        User user = userDAO.getUser(input_username);
        if (user == null) {
            Toast.makeText(this, R.string.user_not_found_error, Toast.LENGTH_SHORT).show();
            return;
        }

        // password is correct
        if (user.getPassword().equals(input_password)) {


            editPrefrences.putString("username",user.getUsername());
            editPrefrences.apply();

            if(user.getIsAdmin() == true){ // go to Admin activity
                Intent intent = new Intent(this, AdminActivity.class);
                startActivity(intent);
            }
            else{// go to home activity
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
            }
        } else {
            // incorrect password
            Toast.makeText(this, R.string.invalid_password_error, Toast.LENGTH_SHORT).show();
        }
    }
}