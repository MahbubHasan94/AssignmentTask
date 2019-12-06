package com.example.logwithfrag;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.Inflater;


public class Fragment1 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragment1,container,false);
        final EditText userName,passWord;
        Button logIn;

        userName = view.findViewById(R.id.uname);
        passWord = view.findViewById(R.id.pass);
        logIn = view.findViewById(R.id.login);


       logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(userName.getText().toString(), passWord.getText().toString());
            }
        });

        Toast.makeText(getContext(), "This is a Demo login page", Toast.LENGTH_SHORT).show();

        return view;
    }

    private void validate(String username , String password)
    {
//        if((username.equals("Admin"))&&(password.equals("1234")))
//        {
//
            FragmentTransaction fr =getFragmentManager().beginTransaction();
            fr.replace(R.id.fragment_container,new Fragment2());
            fr.addToBackStack(null);
            fr.commit();
//        }
    }
}
