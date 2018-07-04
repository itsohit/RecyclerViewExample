package com.example.itsohit.hellomyapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondSharedPreference extends AppCompatActivity {

    /* ---------------------------x---------------------- This Example of getPreference()
             this function allow one Current Activity Context (Use only this activity) ---------x-----------
     */

     SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_shared_preference);

            preferences = getPreferences(MODE_PRIVATE);

    }
}
