package com.sajjad.nebula.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.sajjad.nebula.BuildConfig;
import com.sajjad.nebula.Nebula;
import com.sajjad.nebula.R;
import com.sajjad.nebula.config.PrefConfig;
import com.sajjad.nebula.services.BackgroundService;
import com.sajjad.nebula.utils.FabricatedOverlay;
import com.sajjad.nebula.utils.OverlayUtils;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.topjohnwu.superuser.Shell;

import java.util.List;

public class HomePage extends AppCompatActivity {

    public static boolean isServiceRunning = false;
    private final String TAG = "WelcomePage";
    LinearLayout home_fontPack1, home_fontPack2, home_extras, home_mediaPlayer, home_progressBar, home_info;
    private ViewGroup container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        PrefConfig.savePrefBool(Nebula.getAppContext(), "onHomePage", true);

        PrefConfig.savePrefInt(this, "versionCode", BuildConfig.VERSION_CODE);
        getBootId();
        
        // Header
        CollapsingToolbarLayout collapsing_toolbar = findViewById(R.id.collapsing_toolbar);
        collapsing_toolbar.setTitle("Font Manager");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Home page list items
        container = (ViewGroup) findViewById(R.id.home_page_list);
        addItem(R.id.home_fontPack1, "Font Pack 1", "Change your stock font");
        addItem(R.id.home_fontPack2, "Font Pack 2", "Change your stock font");
        addItem(R.id.home_mediaPlayer, "Media Player", "Change how media player looks");
        addItem(R.id.home_extras, "Extras", "Additions tweaks and settings");
        // addItem(R.id.home_progressBar, "Progress Bar", "Change progress bar style");
        addItem(R.id.home_info, "About", "Information about this app");

        // Get list of enabled overlays
        Runnable runnable1 = () -> {
            List<String> EnabledOverlays = OverlayUtils.getEnabledOverlayList();
            for (String overlay : EnabledOverlays)
                PrefConfig.savePrefBool(Nebula.getAppContext(), overlay, true);

            List<String> EnabledFabricatedOverlays = FabricatedOverlay.getEnabledOverlayList();
            for (String overlay : EnabledFabricatedOverlays)
                PrefConfig.savePrefBool(Nebula.getAppContext(), "fabricated" + overlay, true);
        };
        Thread thread1 = new Thread(runnable1);
        thread1.start();

        if (Build.VERSION.SDK_INT >= 33) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NOTIFICATION_POLICY) != PackageManager.PERMISSION_GRANTED) {
                ActivityResultLauncher<String> launcher = registerForActivityResult(
                        new ActivityResultContracts.RequestPermission(), isGranted -> {
                            Runnable runnable2 = () -> {
                                if (!isServiceRunning)
                                    startService(new Intent(Nebula.getAppContext(), BackgroundService.class));
                            };
                            Thread thread2 = new Thread(runnable2);
                            thread2.start();
                        }
                );
                launcher.launch(Manifest.permission.POST_NOTIFICATIONS);
            }
        } else {
            Runnable runnable2 = () -> {
                if (!isServiceRunning)
                    startService(new Intent(Nebula.getAppContext(), BackgroundService.class));
            };
            Thread thread2 = new Thread(runnable2);
            thread2.start();
        }

        // font pack item onClick
        home_fontPack1 = findViewById(R.id.home_fontPack1);
        home_fontPack1.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, FontPacks1.class);
            startActivity(intent);
        });
        
        
        // font pack item onClick
        home_fontPack2 = findViewById(R.id.home_fontPack2);
        home_fontPack2.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, FontPacks2.class);
            startActivity(intent);
        });
        

        // Media player item onClick
        home_mediaPlayer = findViewById(R.id.home_mediaPlayer);
        home_mediaPlayer.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, MediaPlayer.class);
            startActivity(intent);
        });
        
        // Extras
        home_extras = findViewById(R.id.home_extras);
        home_extras.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, Extras.class);
            startActivity(intent);
        });

        /* Progress bar item onClick
        home_progressBar = findViewById(R.id.home_progressBar);
        home_progressBar.setOnClickListener(v -> {
                Intent intent = new Intent(HomePage.this, ProgressBar.class);
                startActivity(intent);
            }
        }); */

        // About item onClick
        home_info = findViewById(R.id.home_info);
        home_info.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, Info.class);
            startActivity(intent);
        });
    }

    // Function to add new item in list
    private void addItem(int id, String title, String desc) {
        View list_view = LayoutInflater.from(this).inflate(R.layout.list_view, container, false);

        TextView list_title = (TextView) list_view.findViewById(R.id.list_title);
        TextView list_desc = (TextView) list_view.findViewById(R.id.list_desc);
        
        list_view.setId(id);
        list_title.setText(title);
        list_desc.setText(desc);

        container.addView(list_view);
    }

    // Save unique id of each boot
    public static void getBootId() {
        PrefConfig.savePrefSettings(Nebula.getAppContext(), "boot_id", Shell.cmd("cat /proc/sys/kernel/random/boot_id").exec().getOut().toString());
    }
}