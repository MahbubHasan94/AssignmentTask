package com.example.logwithfrag;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main3Activity extends AppCompatActivity {

    SwitchCompat imageButton;
    ImageView imageView;
    Camera camera;
    Camera.Parameters parameters;
    boolean isflash = false;
    boolean isOn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        imageButton = findViewById(R.id.switch1);
        imageView = findViewById(R.id.back_button3);


        if(getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)){
            camera = Camera.open();
            parameters = camera.getParameters();
            isflash = true;
        }

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isflash)
                {

                    if(!isOn && imageButton.isChecked())
                    {

                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(parameters);
                        camera.startPreview();
                        isOn=true;
                    }

                    else
                    {
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                        camera.setParameters(parameters);
                        camera.stopPreview();
                        isOn=false;
                    }
                }

                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Main3Activity.this);
                    builder.setTitle("Error.....");
                    builder.setMessage("Flashlight is not available in this device");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(camera!=null){
            camera.release();
            camera = null;
        }
    }
}

