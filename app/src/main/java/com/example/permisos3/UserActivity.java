package com.example.permisos3;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;


public class UserActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private static final int REQUEST_CAMERA_PERMISSION = 1;
    private static final int REQUEST_PHONE_PERMISSION = 1;

    SwitchMaterial sw1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 500) {

            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

            }
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
