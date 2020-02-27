package com.example.stigandreaslangeland.myexampleapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.stigandreaslangeland.myexampleapp.utils.Utils;

public class ActiveSession extends AppCompatActivity {

    Button finishButton;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = Utils.getSharedPreferences(this);
        setContentView(R.layout.activity_active_session);

        String date = sp.getString(Utils.SESSION_START_TIME, "not_found");

        Toast.makeText(getApplicationContext(),date,Toast.LENGTH_SHORT).show();

    }

    public void finishButton(View view) {
        Utils.getSharedPreferences(this).edit().clear().commit();
        finish();
    }
}
