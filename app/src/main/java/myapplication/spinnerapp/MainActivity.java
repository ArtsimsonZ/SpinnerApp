package com.example.android.spinner;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import myapplication.spinnerapp.CustomOnItemSelectedListener;
import myapplication.spinnerapp.NextActivity;

public class MainActivity extends ActionBarActivity {
    Button next;
    Spinner gender,android;
    Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next=(Button) findViewById(R.id.Next);
        setTitle("Intent 1");
        gender=(Spinner)findViewById(R.id.Gender);
        android=(Spinner)findViewById(R.id.Android);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("Options", MODE_PRIVATE);
        editor=pref.edit();
        gender.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        next.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
                String gen=gender.getSelectedItem().toString();
                String and=android.getSelectedItem().toString();
                editor.putString("gender", gen);
                editor.putString("android", and);
                editor.commit();
                Toast.makeText(getApplicationContext(), "Settings saved!",Toast.LENGTH_LONG ).show();
                Intent in=new Intent(MainActivity.this,NextActivity.class);
                startActivity(in);
                //finish();
            }
        });
    }
}