package com.sajjad.nebula.utils;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

import com.sajjad.nebula.Nebula;
import com.sajjad.nebula.R;

public class AppUtils {
    public static boolean isAppInstalled(String packageName) {
        PackageManager pm = Nebula.getAppContext().getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return pm.getApplicationInfo(packageName, 0).enabled;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Drawable getAppIcon(String packageName) {
        Drawable appIcon = null;
        try {
            appIcon = Nebula.getAppContext().getPackageManager().getApplicationIcon(packageName);
            return appIcon;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            appIcon = Nebula.getAppContext().getResources().getDrawable(R.drawable.ic_android);
            return appIcon;
        }
    }

    public static String getAppName(String packageName) {
        final PackageManager pm = Nebula.getAppContext().getApplicationContext().getPackageManager();
        ApplicationInfo ai;
        try {
            ai = pm.getApplicationInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            ai = null;
        }
        return (String) (ai == null ? "..." : pm.getApplicationLabel(ai));
    }

    public static void launchApp(Activity activity, String packageName) {
        Intent launchIntent = Nebula.getAppContext().getPackageManager().getLaunchIntentForPackage(packageName);
        if (launchIntent != null) {
            activity.startActivity(launchIntent);
        } else {
            Toast.makeText(Nebula.getAppContext(), "Application not found!", Toast.LENGTH_SHORT).show();
        }
    }
}
