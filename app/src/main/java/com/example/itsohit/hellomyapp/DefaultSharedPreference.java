package com.example.itsohit.hellomyapp;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DefaultSharedPreference extends AppCompatActivity implements View.OnClickListener{

    LinearLayout linear;
    Button clear,red,blue,green;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_shared_preference);

         sharedPreferences = getSharedPreferences("Color",MODE_PRIVATE);

        clear = (Button) findViewById(R.id.clear_btn_DefaultSharedPreference);
        red = (Button) findViewById(R.id.red_color);
        blue = (Button) findViewById(R.id.blue_color);
        green = (Button) findViewById(R.id.green_color);
        linear = (LinearLayout) findViewById(R.id.linearLayout);

        red.setOnClickListener(this);
        blue.setOnClickListener(this);
        green.setOnClickListener(this);
        clear.setOnClickListener(this);
        setBackgroundColor();

    }

    @Override
    public void onClick(View view) {
        getColorShared(view.getId());
    }

  private  void getColorShared(int id){
     editor = sharedPreferences.edit();
      if(id==R.id.red_color){
          editor.putInt("color",android.R.color.holo_red_light);
           }
      else if(id==R.id.green_color){
          editor.putInt("color",android.R.color.holo_green_light); }
      else if(id==R.id.blue_color)
      {
          editor.putInt("color",android.R.color.holo_blue_light);
      }else if(id==R.id.clear_btn_DefaultSharedPreference){
        editor.clear();
      }else{}
      editor.apply();
      setBackgroundColor();
    }

    void setBackgroundColor(){
        linear.setBackgroundColor(getResources().getColor(sharedPreferences.getInt("color",0)));
    }
}
