package com.example.itsohit.hellomyapp;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.itsohit.hellomyapp.Adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

//    AppCompatButton openDialogFragment;
//    TextView tv;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//            openDialogFragment = (AppCompatButton) findViewById(R.id.openDailogFragment_btn);
//            tv = (TextView) findViewById(R.id.textview_data);
//
//            openDialogFragment.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    ExampleActFragDialog ActFrag = new ExampleActFragDialog();
//                     ActFrag.show(getSupportFragmentManager(),"Activity Fragment");
//                }
//            });
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new MyAdapter(this));
    }

//    @Override
//    public void setData(String s) {
//        tv.setText(s);
//    }
}
