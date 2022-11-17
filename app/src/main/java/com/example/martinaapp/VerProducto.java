package com.example.martinaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class VerProducto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_producto);
        long id = 0;

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                //id = Integer.parseInt(null);
                id = Long.parseLong(null);
            } else {
                id = extras.getLong("ID");
                String NOMBRE= extras.getString("NOMBRE");
                Toast.makeText(this, Integer.toString(extras.getInt("ID")), Toast.LENGTH_SHORT).show();
                //Log.i("nombre",id);
            }
        }
    }
}