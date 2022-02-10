package com.daclink.drew.sp22.cst438_project01_starter;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        UserDAO testDb = Room.databaseBuilder(appContext, AppDatabase.class, "app_db")
                .allowMainThreadQueries()
                .build()
                .getUserDao();

        User user = new User("John", "Smith", "JohnA", "Smith");

        try {
            testDb.deleteUser(testDb.getUser(user.getUsername()));
        } catch (Exception e) { }

        testDb.insertUser(user);
        user = testDb.getUser(user.getUsername());

        User user2 = testDb.getUser(user.getUsername());

        assertEquals(user, user2);

        user2.setFirstName("Bill");

        testDb.updateUser(user2);

        User user3 = testDb.getUser(user.getUsername());

        assertNotEquals(user, user3);
        assertEquals(user2,user3);
        assertEquals("com.daclink.drew.sp22.cst438_project01_starter", appContext.getPackageName());
    }
}