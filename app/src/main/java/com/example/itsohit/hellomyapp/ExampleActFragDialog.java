package com.example.itsohit.hellomyapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ExampleActFragDialog extends DialogFragment {

    OnItemDataSend onItemDataSend;
    Button cancel,ok;
    EditText editText;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fragmentdialog,container,false);
          getDialog().setTitle("Enter your name");
            cancel = (Button)  v.findViewById(R.id.btn_cancel_ActFrag);
            ok = (Button)  v.findViewById(R.id.btn_ok_ActFrag);
            editText = (EditText) v.findViewById(R.id.et_actfrag);

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getDialog().dismiss();
                }
            });

            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 //   ((MainActivity)getActivity()).tv.setText(editText.getText().toString());

                    onItemDataSend.setData(editText.getText().toString());
                    getDialog().dismiss();
                }
            });



        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onItemDataSend = (OnItemDataSend) getActivity();
    }
}
