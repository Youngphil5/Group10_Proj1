package com.daclink.drew.sp22.cst438_project01_starter;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User")
public class User {
    private String firstName;
    private String lastName;
    private String location;
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private Integer uid;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @NonNull
    public Integer getUid() {
        return uid;
    }

    public void setUid(@NonNull Integer uid) {
        this.uid = uid;
    }
}
