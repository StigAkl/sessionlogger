package com.example.stigandreaslangeland.myexampleapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.stigandreaslangeland.myexampleapp.utils.Utils;

import java.util.Date;

public class StartSession extends AppCompatActivity {
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_session);

        sp = Utils.getSharedPreferences(this);
    }

    public void startSession(View view) {

        Log.d("Btn", "Button clicked");
        SharedPreferences.Editor editor = sp.edit();

        Date date = new Date();
        editor.putString(Utils.IS_ACTIVE_KEY, Utils.SESSION_IS_ACTIVE_VALUE);
        editor.putString(Utils.SESSION_START_TIME, "kake");
        Intent intent = new Intent(this, ActiveSession.class);

        startActivity(intent);
    }
}
