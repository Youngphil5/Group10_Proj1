package com.daclink.drew.sp22.cst438_project01_starter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;

import com.daclink.drew.sp22.cst438_project01_starter.databinding.ActivityAdminBinding;

import java.util.List;

public class AdminActivity extends AppCompatActivity {
    private ActivityAdminBinding binding;
    AppDatabase AppDb;
    UserDAO userDAO;
    List<User> allUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDb = AppDatabase.getInstance(this);
        userDAO = AppDb.getUserDao();
        allUsers = userDAO.getAllUsers();

        binding.displayUsers.setMovementMethod(
                new ScrollingMovementMethod());// includes scrolling
        displayUsers();

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    void displayUsers(){
        String temp ="";
        for(User x : allUsers){
            temp += "Name: " + x.getFirstName() + " "
            + x.getLastName() +"\n" +
                    "username: " + x.getUsername() + "\n"
            + "====================\n";
        }

        binding.displayUsers.setText(temp);
    }
    /*void deleteUser(String username){
        if(userDAO.getUser(username) =)
    }*/
}