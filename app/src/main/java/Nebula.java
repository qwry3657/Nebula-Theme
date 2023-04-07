package com.sajjad.nebula;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.google.android.material.color.DynamicColors;

public class Nebula extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static Context getAppContext() {
        return Nebula.context;
    }

    public void onCreate() {
        super.onCreate();
        Nebula.context = getApplicationContext();
        DynamicColors.applyToActivitiesIfAvailable(this);
    }
}