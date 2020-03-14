package com.example.actividad_4;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements FirstFragment.OnFragmentInteractionListener,SecondFragment.OnFragmentInteractionListener {
    FirstFragment firstFragment;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
       String dato = getIntent().getStringExtra("dato");

        if (dato.equals("admin")){
            getSupportFragmentManager().beginTransaction().add(R.id.fragment2,firstFragment).commit();
        }else{
            getSupportFragmentManager().beginTransaction().add(R.id.fragment2,secondFragment).commit();
        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
