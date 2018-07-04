package com.example.itsohit.hellomyapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecondSharedPreference extends AppCompatActivity {

    /* ---------------------------x---------------------- This Example of Default SharedPreference by using getPreference()
             this function allow one Current Activity Context (Use only this activity) ---------x-----------
     */

     SharedPreferences preferences;
     EditText address,gender;
     Button save,clear,change,view_data_btn;
     TextView tv;
     Set<String> set  = new HashSet<>();
     SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_shared_preference);

            preferences = getPreferences(MODE_PRIVATE);
              address = (EditText) findViewById(R.id.address_et_SecondSharedPreference);
              gender = (EditText) findViewById(R.id.gender_et_SecondSharedPreference);
              save = (Button) findViewById(R.id.save_btn_SecondSharedPreference);
              clear = (Button) findViewById(R.id.clear_btn_SecondSharedPreference);
              change = (Button) findViewById(R.id.change_btn_SecondSharedPreference);
              view_data_btn = (Button) findViewById(R.id.view_btn_SecondSharedPreference);
              tv = (TextView) findViewById(R.id.tv_data_secondSharedPreference);


               if(preferences.contains("Address")){
                    showData();
               }

               save.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       editor = getPreferences(MODE_PRIVATE).edit();
                       if(!set.add(String.valueOf(address.getText().toString())))
                           Toast.makeText(SecondSharedPreference.this,"data already Exits.",Toast.LENGTH_SHORT).show();
                       else if(!set.add(gender.getText().toString()))
                           Toast.makeText(SecondSharedPreference.this,"data already Exits.",Toast.LENGTH_SHORT).show();
                       else{
                            editor.putStringSet("MyData",set);
                            editor.commit();
                             showData();
                       Toast.makeText(getApplicationContext(),"Save Success",Toast.LENGTH_SHORT).show(); }
                   }
               });

               clear.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       editor = (getPreferences(MODE_PRIVATE)).edit();
                        editor.clear();
                        editor.apply();
                        Toast.makeText(SecondSharedPreference.this,"clear Success",Toast.LENGTH_SHORT).show();
                        tv.setText("");
                        address.setText("");
                        gender.setText("");
                        set = null;
                   }
               });

               view_data_btn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       showData();
                   }
               });
    }

   private void showData(){
        set  = preferences.getStringSet("MyData",null);
        tv.setText(set.toString());
    }
}
