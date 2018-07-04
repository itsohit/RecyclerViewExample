package com.example.itsohit.hellomyapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itsohit.hellomyapp.DefaultSharedPreference;
import com.example.itsohit.hellomyapp.MainActivity;
import com.example.itsohit.hellomyapp.R;
import com.example.itsohit.hellomyapp.SecondSharedPreference;
import com.example.itsohit.hellomyapp.SharedPreAcitivity;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class MyAdapter extends  RecyclerView.Adapter<MyAdapter.HolderClass> {
    String name[] = {"Shared Prefrence Example 1","Shared Preference Example 2","Default SharedPreference Example","Abhi","Sohit","Sharma","Smart","Hello","Nice","Name","Developer","Designer","Smart Tech","I am Android Developer"};
    int []image = {R.drawable.unnamed,R.drawable.phone_call_icon,R.drawable.mahadev,R.drawable.mahadev,R.drawable.fb,R.drawable.google,
            R.drawable.linkedin,R.drawable.password_icon,R.drawable.person,
    R.drawable.phone_call_icon,R.drawable.unnamed,R.drawable.linkedin,R.drawable.google,R.drawable.fb};
    String s = "This is an Android project allowing to realize a circular ImageView in the simplest way possible.";

    Context context;
    public MyAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public HolderClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_layout,viewGroup,false);
        return new HolderClass(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderClass holderClass, int i) {
            holderClass.title.setText(name[i]);
            holderClass.circularImageView.setImageResource(image[i]);
            holderClass.details.setText(s);
    }



    @Override
    public int getItemCount() {
        return name.length;
    }

    public class HolderClass extends RecyclerView.ViewHolder {
       CircularImageView circularImageView;
       TextView title,details;
        public HolderClass(@NonNull View itemView) {
            super(itemView);
            circularImageView = (CircularImageView) itemView.findViewById(R.id.imageView_recyclerview);
            title  = (TextView) itemView.findViewById(R.id.title_tv);
            details = (TextView) itemView.findViewById(R.id.detail_tv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch(getAdapterPosition()){
                        case 0:
                            context.startActivity(new Intent(context, SharedPreAcitivity.class));
                            break;
                        case 1:
                            context.startActivity(new Intent(context, SecondSharedPreference.class));
                            break;
                        case 2:
                            context.startActivity(new Intent(context, DefaultSharedPreference.class));
                            break;
                        default:

                    }
                    Toast.makeText(context,name[getAdapterPosition()],Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
