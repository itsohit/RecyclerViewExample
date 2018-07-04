package com.example.itsohit.hellomyapp.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.itsohit.hellomyapp.R;


public class GetSharedPre extends Fragment{

    TextView tv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          View v = inflater.inflate(R.layout.getsharedprefre,container,false);
            tv = (TextView)  v.findViewById(R.id.sharedpre_textview_data);
        SharedPreferences sp = this.getActivity().getSharedPreferences("MyPref",Context.MODE_PRIVATE);

            if(sp.contains("Name"))
                tv.setText("Your name : "+sp.getString("Name",null)+", Email : "+sp.getString("Email",null)+", Number : "+sp.getString("Number",null));

        return v;
    }
}
