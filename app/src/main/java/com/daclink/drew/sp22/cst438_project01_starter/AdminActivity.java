package com.daclink.drew.sp22.cst438_project01_starter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.daclink.drew.sp22.cst438_project01_starter.databinding.ActivityAdminBinding;

public class AdminActivity extends AppCompatActivity {
    private ActivityAdminBinding binding;
    AppDatabase AppDb;
    UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDb = AppDatabase.getInstance(this);
        userDAO = AppDb.getUserDao();



    }
    void displayUsers(){

    }
}