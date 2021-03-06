package com.example.itsohit.hellomyapp.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.itsohit.hellomyapp.R;

public class SharedPref extends Fragment{

    EditText name,email,number;
    Button save,clean,getSharedPreferenceButton;
     SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sharedpref,container,false);
          name = (EditText) v.findViewById(R.id.name_sharedPre_et);
          email = (EditText) v.findViewById(R.id.email_id_sharedPre_et);
          number = (EditText) v.findViewById(R.id.number_sharedPre_et);
          save = (Button) v.findViewById(R.id.save_btn);
          clean = (Button) v.findViewById(R.id.clean_btn);
          getSharedPreferenceButton = (Button) v.findViewById(R.id.getData_fragment_btn);

            sharedPreferences = getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
            if(sharedPreferences.contains("Name")){
                name.setText(sharedPreferences.getString("Name",null));
                email.setText(sharedPreferences.getString("Email",null));
                number.setText(sharedPreferences.getString("Number",null));
            }
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editor = sharedPreferences.edit();
                     editor.putString("Name",name.getText().toString());
                     editor.putString("Email",email.getText().toString());
                     editor.putString("Number",number.getText().toString());
                     editor.commit();
                }
            });

            clean.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   SharedPreferences.Editor ed = (getContext().getSharedPreferences("MyPref",Context.MODE_PRIVATE)).edit();
                    ed.clear();
                    ed.commit();
                    Toast.makeText(getContext(),"Clear Data Success",Toast.LENGTH_SHORT).show();
                }
            });

            getSharedPreferenceButton.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onClick(View view) {
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                     fragmentTransaction.replace(R.id.frameLayout,new GetSharedPre(),"GetData").commit();
                }
            });
          return v;
    }


}
