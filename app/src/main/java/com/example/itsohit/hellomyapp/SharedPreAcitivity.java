package com.example.itsohit.hellomyapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.itsohit.hellomyapp.Fragment.SharedPref;

public class SharedPreAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pre_acitivity);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
         ft.replace(R.id.frameLayout,new SharedPref(),"UserDataGet").commit();

    }
}
