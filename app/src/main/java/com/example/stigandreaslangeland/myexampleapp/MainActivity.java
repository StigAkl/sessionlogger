package com.example.stigandreaslangeland.myexampleapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.stigandreaslangeland.myexampleapp.utils.Utils;


public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private Intent sessionIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String database = getDatabase();
        sp = Utils.getSharedPreferences(this);

        String hasActiveSession = sp.getString(Utils.IS_ACTIVE_KEY, "");

        sessionIntent = hasActiveSession.equals((Utils.SESSION_IS_ACTIVE_VALUE)) ?
                new Intent(this, ActiveSession.class) :
                new Intent(this, StartSession.class);

        sessionIntent.putExtra(Utils.DATABASE_TABLE_KEY, database);

        startActivity(sessionIntent);
    }


    private String getDatabase() {
        return Utils.isOnEmulator() ? Utils.DEV_DB_TABLE : Utils.PRODUCTION_DB_TABLE;
    }
}
