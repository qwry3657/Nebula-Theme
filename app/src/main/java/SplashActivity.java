package com.sajjad.nebula;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import com.sajjad.nebula.config.PrefConfig;
import com.sajjad.nebula.ui.HomePage;
import com.sajjad.nebula.ui.WelcomePage;
import com.sajjad.nebula.utils.ModuleUtil;
import com.sajjad.nebula.utils.OverlayUtils;
import com.sajjad.nebula.utils.RootUtil;
import com.google.android.material.color.DynamicColors;
import com.topjohnwu.superuser.Shell;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    private static SplashActivity mContext;
    private boolean keepShowing = true;

    static {
        Shell.enableVerboseLogging = BuildConfig.DEBUG;
        Shell.setDefaultBuilder(Shell.Builder.create().setFlags(Shell.FLAG_REDIRECT_STDERR).setTimeout(10));
    }

    private final int versionCode = BuildConfig.VERSION_CODE;
    private final String versionName = BuildConfig.VERSION_NAME;

    public static SplashActivity getContext() {
        return mContext;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);
        splashScreen.setKeepOnScreenCondition(() -> keepShowing);
        DynamicColors.applyToActivitiesIfAvailable(getApplication());

        Thread thread = new Thread(runner);
        thread.start();
    }

    private final Runnable runner = new Runnable() {
        @Override
        public void run() {
            Shell.getShell(shell -> {
                mContext = SplashActivity.this;

                Intent intent;

                if (RootUtil.isDeviceRooted() && RootUtil.isMagiskInstalled() && ModuleUtil.moduleExists() && OverlayUtils.overlayExists() && (versionCode == PrefConfig.loadPrefInt(SplashActivity.this, "versionCode"))) {
                    keepShowing = false;
                    intent = new Intent(SplashActivity.this, HomePage.class);
                } else {
                    keepShowing = false;
                    intent = new Intent(SplashActivity.this, WelcomePage.class);
                }

                startActivity(intent);
                finish();
            });
        }
    };
}