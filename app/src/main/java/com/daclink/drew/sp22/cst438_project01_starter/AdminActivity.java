package com.daclink.drew.sp22.cst438_project01_starter;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Toast;

import com.daclink.drew.sp22.cst438_project01_starter.databinding.ActivityAdminBinding;

import java.util.List;

public class AdminActivity extends AppCompatActivity {
    private ActivityAdminBinding binding;
    AppDatabase AppDb;
    UserDAO userDAO;
    List<User> allUsers;
    SharedPreferences preferences;
    SharedPreferences.Editor editPrefrences;
    String loggedInUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        preferences = getApplicationContext().
                getSharedPreferences("lastLoginInfo",
                        MODE_PRIVATE);
        editPrefrences = preferences.edit();
        loggedInUser = preferences.getString("username","");

        super.onCreate(savedInstanceState);
        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDb = AppDatabase.getInstance(this);
        userDAO = AppDb.getUserDao();


        binding.displayUsers.setMovementMethod(
                new ScrollingMovementMethod());// includes scrolling
        displayUsers();

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteUser(binding.editTextTextPersonName.getText().toString());
            }
        });

        binding.logoutAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    void displayUsers(){
        allUsers = userDAO.getAllUsers();
        String temp ="";
        for(User x : allUsers){
            temp += "Name: " + x.getFirstName() + " "
            + x.getLastName() +"\n" +
                    "username: " + x.getUsername() + "\n"
            + "====================\n";
        }

        binding.displayUsers.setText(temp);
    }

    void deleteUser(String username){
        if(userDAO.getUser(username) != null){
            if(userDAO.getUser(username).getUsername().equals(loggedInUser)){
                Toast.makeText(this,
                        R.string.Deleting_LoggedIn_Admin, Toast.LENGTH_SHORT).show();
            }
            else{
                userDAO.deleteUser(userDAO.getUser(username));
                displayUsers();
            }
        }
    }
}