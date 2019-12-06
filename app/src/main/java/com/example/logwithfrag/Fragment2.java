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
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;


public class Fragment2 extends Fragment {

    RadioGroup radioGroup;
    Button showButton;
    RadioButton rad_butt1,rad_butt2,rad_butt3;
    CheckBox checkID;
    ImageView backbutton,torch;
    CircleImageView user;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2,container,false);

        radioGroup = view.findViewById(R.id.radioGroupId);
        rad_butt1 = view.findViewById(R.id.radButt1);
        rad_butt2 = view.findViewById(R.id.radButt2);
        rad_butt3 = view.findViewById(R.id.radButt3);
        showButton = view.findViewById(R.id.login1);
        checkID = view.findViewById(R.id.checkID);
        backbutton = view.findViewById(R.id.back_button);
        user = view.findViewById(R.id.user);
        torch = view.findViewById(R.id.torch);

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr =getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container,new Fragment3());
                fr.addToBackStack(null);
                fr.commit();
            }
        });

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(),MainActivity.class);
//              startActivity(intent);

                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

        torch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Main3Activity.class);
               startActivity(intent);
            }
        });


        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioGroup.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getContext(), "Choose at least one Option", Toast.LENGTH_SHORT).show();
                }

                else if(rad_butt1.isChecked() && checkID.isChecked()){
                    Intent intent = new Intent(getActivity(),Main2Activity.class);
                    startActivity(intent);
                    Toast.makeText(getContext(), "Car selected", Toast.LENGTH_SHORT).show();
                }

                else if(rad_butt2.isChecked() && checkID.isChecked()){
                    Toast.makeText(getContext(), "Only Car menu is currently available", Toast.LENGTH_SHORT).show();
                }

                else if(rad_butt3.isChecked() && checkID.isChecked()){
                    Toast.makeText(getContext(), "Only Car menu is currently available", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
