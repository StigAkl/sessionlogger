package com.example.stigandreaslangeland.myexampleapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by stigandreaslangeland on 16/02/2020.
 */

public class Utils {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String IS_ACTIVE_KEY = "session_started";
    public static final String SESSION_IS_ACTIVE_VALUE = "ACTIVE";
    public static final String SESSION_IS_NOT_ACTIVE = "INACTIVE";
    public static final String DATABASE_TABLE_KEY = "DB_TABLE";
    public static final String PRODUCTION_DB_TABLE = "sessions";
    public static final String DEV_DB_TABLE = "sessions_dev";

    public static boolean isOnEmulator() {
        return Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || "google_sdk".equals(Build.PRODUCT);
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
    }
}
