package com.sajjad.nebula.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.sajjad.nebula.Nebula;
import com.sajjad.nebula.R;
import com.sajjad.nebula.config.PrefConfig;
import com.sajjad.nebula.installer.FontInstaller;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Objects;

public class FontPacks1 extends AppCompatActivity {

    private static final String fontp1_KEY = "SaOverlaysFONTS1.overlay";
    private static final String fontp2_KEY = "SaOverlaysFONTS2.overlay";
    private static final String fontp4_KEY = "SaOverlaysFONTS3.overlay";
    private static final String fontp4_KEY = "SaOverlaysFONTS4.overlay";
    private static final String fontp5_KEY = "SaOverlaysFONTS5.overlay";
    private static final String fontp6_KEY = "SaOverlaysFONTS6.overlay";
    private static final String fontp7_KEY = "SaOverlaysFONTS7.overlay";
    private static final String fontp8_KEY = "SaOverlaysFONTS8.overlay";
    private static final String fontp9_KEY = "SaOverlaysFONTS9.overlay";
    private static final String fontp10_KEY = "SaOverlaysFONTS10.overlay";
    private static final String fontp11_KEY = "SaOverlaysFONTS11.overlay";
    private static final String fontp12_KEY = "SaOverlaysFONTS12.overlay";
    private static final String fontp13_KEY = "SaOverlaysFONTS13.overlay";
    private static final String fontp14_KEY = "SaOverlaysFONTS14.overlay";
    private static final String fontp15_KEY = "SaOverlaysFONTS15.overlay";
    private static final String fontp16_KEY = "SaOverlaysFONTS16.overlay";
    private static final String fontp17_KEY = "SaOverlaysFONTS17.overlay";
    private static final String fontp18_KEY = "SaOverlaysFONTS18.overlay";

    LinearLayout[] Container;
    LinearLayout fontp1Container, fontp2Container, fontp4Container, fontp4Container, fontp5Container, fontp6Container, fontp7Container, fontp8Container, fontp9Container, fontp10Container, fontp11Container, fontp12Container, fontp13Container, fontp14Container, fontp15Container, fontp16Container, fontp17Container, fontp18Container;
    Button fontp1_Enable, fontp1_Disable, fontp2_Enable, fontp2_Disable, fontp4_Enable, fontp4_Disable, fontp4_Enable, fontp4_Disable, fontp5_Enable, fontp5_Disable, fontp6_Enable, fontp6_Disable, fontp7_Enable, fontp7_Disable, fontp8_Enable, fontp8_Disable, fontp9_Enable, fontp9_Disable, fontp10_Enable, fontp10_Disable, fontp11_Enable, fontp11_Disable, fontp12_Enable, fontp12_Disable, fontp13_Enable, fontp13_Disable, fontp14_Enable, fontp14_Disable, fontp15_Enable, fontp15_Disable, fontp16_Enable, fontp16_Disable, fontp17_Enable, fontp17_Disable, fontp18_Enable, fontp18_Disable;
    private ViewGroup container;
    LoadingDialog loadingDialog;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fonts_manager);

        // Header
        CollapsingToolbarLayout collapsing_toolbar = findViewById(R.id.collapsing_toolbar);
        collapsing_toolbar.setTitle("Fonts Pack 1");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // Loading dialog while enabling or disabling pack
        loadingDialog = new LoadingDialog(this);

        // Icon Pack list items
        container = (ViewGroup) findViewById(R.id.icon_packs_list);

        // Font.add items in list
        addItem(R.id.fontp1_container, "Fucek", "Tap to enable/desable font.", R.id.fontp1_enable, R.id.fontp1_disable);
        addItem(R.id.fontp2_container, "Nothing", "Tap to enable/desable font.", R.id.fontp2_enable, R.id.fontp2_disable);
        addItem(R.id.fontp4_container, "Noto Serif", "Tap to enable/desable font.", R.id.fontp4_enable, R.id.fontp4_disable);
        addItem(R.id.fontp4_container, "Linnote Bold", "Tap to enable/desable font.", R.id.fontp4_enable, R.id.fontp4_disable);
        addItem(R.id.fontp5_container, "Tinkerbell", "Tap to enable/desable font.", R.id.fontp5_enable, R.id.fontp5_disable);
        addItem(R.id.fontp6_container, "Samsung One", "Tap to enable/desable font.", R.id.fontp6_enable, R.id.fontp6_disable);
        addItem(R.id.fontp7_container, "Corporativ Sans", "Tap to enable/desable font.", R.id.fontp7_enable, R.id.fontp7_disable);
        addItem(R.id.fontp8_container, "FluidSans", "Tap to enable/desable font.", R.id.fontp8_enable, R.id.fontp8_disable);
        addItem(R.id.fontp9_container, "Dosis", "Tap to enable/desable font.", R.id.fontp9_enable, R.id.fontp9_disable);
        addItem(R.id.fontp10_container, "Sfpro", "Tap to enable/desable font.", R.id.fontp10_enable, R.id.fontp10_disable);
        addItem(R.id.fontp11_container, "Opensans", "Tap to enable/desable font.", R.id.fontp11_enable, R.id.fontp11_disable);
        addItem(R.id.fontp12_container, "Cagliostro", "Tap to enable/desable font.", R.id.fontp12_enable, R.id.fontp12_disable);
        addItem(R.id.fontp13_container, "Chula", "Tap to enable/desable font.", R.id.fontp13_enable, R.id.fontp13_disable);
        addItem(R.id.fontp14_container, "Volte-fontp12", "Tap to enable/desable font.", R.id.fontp14_enable, R.id.fontp14_disable);
        addItem(R.id.fontp15_container, "Arial fontp12", "Tap to enable/desable font.", R.id.fontp15_enable, R.id.fontp15_disable);
        addItem(R.id.fontp16_container, "Fucek", "Tap to enable/desable font.", R.id.fontp16_enable, R.id.fontp16_disable);
        addItem(R.id.fontp17_container, "Nothing", "Tap to enable/desable font.", R.id.fontp17_enable, R.id.fontp17_disable);
        addItem(R.id.fontp18_container, "Noto Serif", "Tap to enable/desable font.", R.id.fontp18_enable, R.id.fontp18_disable);

        // Declaration of fontp1
        fontp1Container = findViewById(R.id.fontp1_container);
        fontp1_Enable = findViewById(R.id.fontp1_enable);
        fontp1_Disable = findViewById(R.id.fontp1_disable);

        // Declaration of fontp2
        fontp2Container = findViewById(R.id.fontp2_container);
        fontp2_Enable = findViewById(R.id.fontp2_enable);
        fontp2_Disable = findViewById(R.id.fontp2_disable);

        // Declaration of fontp4
        fontp4Container = findViewById(R.id.fontp4_container);
        fontp4_Enable = findViewById(R.id.fontp4_enable);
        fontp4_Disable = findViewById(R.id.fontp4_disable);

        // Declaration of fontp4
        fontp4Container = findViewById(R.id.fontp4_container);
        fontp4_Enable = findViewById(R.id.fontp4_enable);
        fontp4_Disable = findViewById(R.id.fontp4_disable);

        // Declaration of fontp5
        fontp5Container = findViewById(R.id.fontp5_container);
        fontp5_Enable = findViewById(R.id.fontp5_enable);
        fontp5_Disable = findViewById(R.id.fontp5_disable);

        // Declaration of fontp6
        fontp6Container = findViewById(R.id.fontp6_container);
        fontp6_Enable = findViewById(R.id.fontp6_enable);
        fontp6_Disable = findViewById(R.id.fontp6_disable);

        // Declaration of fontp7
        fontp7Container = findViewById(R.id.fontp7_container);
        fontp7_Enable = findViewById(R.id.fontp7_enable);
        fontp7_Disable = findViewById(R.id.fontp7_disable);

        // Declaration of fontp8
        fontp8Container = findViewById(R.id.fontp8_container);
        fontp8_Enable = findViewById(R.id.fontp8_enable);
        fontp8_Disable = findViewById(R.id.fontp8_disable);

        // Declaration of fontp9
        fontp9Container = findViewById(R.id.fontp9_container);
        fontp9_Enable = findViewById(R.id.fontp9_enable);
        fontp9_Disable = findViewById(R.id.fontp9_disable);

        // Declaration of fontp10
        fontp10Container = findViewById(R.id.fontp10_container);
        fontp10_Enable = findViewById(R.id.fontp10_enable);
        fontp10_Disable = findViewById(R.id.fontp10_disable);

        // Declaration of fontp11
        fontp11Container = findViewById(R.id.fontp11_container);
        fontp11_Enable = findViewById(R.id.fontp11_enable);
        fontp11_Disable = findViewById(R.id.fontp11_disable);

        // Declaration of fontp12
        fontp12Container = findViewById(R.id.fontp12_container);
        fontp12_Enable = findViewById(R.id.fontp12_enable);
        fontp12_Disable = findViewById(R.id.fontp12_disable);

        // Declaration of fontp13
        fontp13Container = findViewById(R.id.fontp13_container);
        fontp13_Enable = findViewById(R.id.fontp13_enable);
        fontp13_Disable = findViewById(R.id.fontp13_disable);

        // Declaration of fontp14
        fontp14Container = findViewById(R.id.fontp14_container);
        fontp14_Enable = findViewById(R.id.fontp14_enable);
        fontp14_Disable = findViewById(R.id.fontp14_disable);
        
        // Declaration of fontp15
        fontp15Container = findViewById(R.id.fontp15_container);
        fontp15_Enable = findViewById(R.id.fontp15_enable);
        fontp15_Disable = findViewById(R.id.fontp15_disable);
        
        // Declaration of fontp16
        fontp16Container = findViewById(R.id.fontp16_container);
        fontp16_Enable = findViewById(R.id.fontp16_enable);
        fontp16_Disable = findViewById(R.id.fontp16_disable);
        
        // Declaration of fontp17
        fontp17Container = findViewById(R.id.fontp17_container);
        fontp17_Enable = findViewById(R.id.fontp17_enable);
        fontp17_Disable = findViewById(R.id.fontp17_disable);

        // Declaration of fontp18
        fontp18Container = findViewById(R.id.fontp18_container);
        fontp18_Enable = findViewById(R.id.fontp18_enable);
        fontp18_Disable = findViewById(R.id.fontp18_disable);
        
        // List of Icon Pack
        Container = new LinearLayout[]{fontp1Container, fontp2Container, fontp4Container, fontp4Container, fontp5Container, fontp6Container, fontp7Container, fontp8Container, fontp9Container, fontp10Container, fontp11Container, fontp12Container, fontp13Container, fontp14Container, fontp15Container, fontp16Container, fontp17Container, fontp18Container};

        // Enable onClick event
        enableOnClickListener(fontp1Container, fontp1_Enable, fontp1_Disable, fontp1_KEY, 1);
        enableOnClickListener(fontp2Container, fontp2_Enable, fontp2_Disable, fontp2_KEY, 2);
        enableOnClickListener(fontp4Container, fontp4_Enable, fontp4_Disable, fontp4_KEY, 3);
        enableOnClickListener(fontp4Container, fontp4_Enable, fontp4_Disable, fontp4_KEY, 4);
        enableOnClickListener(fontp5Container, fontp5_Enable, fontp5_Disable, fontp5_KEY, 5);
        enableOnClickListener(fontp6Container, fontp6_Enable, fontp6_Disable, fontp6_KEY, 6);
        enableOnClickListener(fontp7Container, fontp7_Enable, fontp7_Disable, fontp7_KEY, 7);
        enableOnClickListener(fontp8Container, fontp8_Enable, fontp8_Disable, fontp8_KEY, 8);
        enableOnClickListener(fontp9Container, fontp9_Enable, fontp9_Disable, fontp9_KEY, 9);
        enableOnClickListener(fontp10Container, fontp10_Enable, fontp10_Disable, fontp10_KEY, 10);
        enableOnClickListener(fontp11Container, fontp11_Enable, fontp11_Disable, fontp11_KEY, 11);
        enableOnClickListener(fontp12Container, fontp12_Enable, fontp12_Disable, fontp12_KEY, 12);
        enableOnClickListener(fontp13Container, fontp13_Enable, fontp13_Disable, fontp13_KEY, 13);
        enableOnClickListener(fontp14Container, fontp14_Enable, fontp14_Disable, fontp14_KEY, 14);
        enableOnClickListener(fontp15Container, fontp15_Enable, fontp15_Disable, fontp15_KEY, 15);
        enableOnClickListener(fontp16Container, fontp16_Enable, fontp16_Disable, fontp16_KEY, 16);
        enableOnClickListener(fontp17Container, fontp17_Enable, fontp17_Disable, fontp17_KEY, 17);
        enableOnClickListener(fontp18Container, fontp18_Enable, fontp18_Disable, fontp18_KEY, 18);

        refreshBackground();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    // Function to check for layout changes
    private void refreshLayout(LinearLayout layout) {
        for (LinearLayout linearLayout : Container) {
            if (!(linearLayout == layout)) {
                if (linearLayout == fontp1Container) {
                    fontp1_Enable.setVisibility(View.GONE);
                    fontp1_Disable.setVisibility(View.GONE);
                } else if (linearLayout == fontp2Container) {
                    fontp2_Enable.setVisibility(View.GONE);
                    fontp2_Disable.setVisibility(View.GONE);
                } else if (linearLayout == fontp4Container) {
                    fontp4_Enable.setVisibility(View.GONE);
                    fontp4_Disable.setVisibility(View.GONE);
                 
                } else if (linearLayout == fontp4Container) {
                    fontp4_Enable.setVisibility(View.GONE);
                    fontp4_Disable.setVisibility(View.GONE);
                } else if (linearLayout == fontp5Container) {
                    fontp5_Enable.setVisibility(View.GONE);
                    fontp5_Disable.setVisibility(View.GONE);
                } else if (linearLayout == fontp6Container) {
                    fontp6_Enable.setVisibility(View.GONE);
                    fontp6_Disable.setVisibility(View.GONE);
                } else if (linearLayout == fontp7Container) {
                    fontp7_Enable.setVisibility(View.GONE);
                    fontp7_Disable.setVisibility(View.GONE);
                } else if (linearLayout == fontp8Container) {
                    fontp8_Enable.setVisibility(View.GONE);
                    fontp8_Disable.setVisibility(View.GONE);
                } else if (linearLayout == fontp9Container) {
                    fontp9_Enable.setVisibility(View.GONE);
                    fontp9_Disable.setVisibility(View.GONE);
                } else if (linearLayout == fontp10Container) {
                    fontp10_Enable.setVisibility(View.GONE);
                    fontp10_Disable.setVisibility(View.GONE);
                } else if (linearLayout == fontp11Container) {
                    fontp11_Enable.setVisibility(View.GONE);
                    fontp11_Disable.setVisibility(View.GONE);
                } else if (linearLayout == fontp12Container) {
                    fontp12_Enable.setVisibility(View.GONE);
                    fontp12_Disable.setVisibility(View.GONE);
                } else if (linearLayout == fontp13Container) {
                    fontp13_Enable.setVisibility(View.GONE);
                    fontp13_Disable.setVisibility(View.GONE);
                } else if (linearLayout == fontp14Container) {
                    fontp14_Enable.setVisibility(View.GONE);
                    fontp14_Disable.setVisibility(View.GONE);
                } else if (linearLayout == fontp15Container) {
                    fontp15_Enable.setVisibility(View.GONE);
                    fontp15_Disable.setVisibility(View.GONE);
                } else if (linearLayout == fontp16Container) {
                    fontp16_Enable.setVisibility(View.GONE);
                    fontp16_Disable.setVisibility(View.GONE);
                } else if (linearLayout == fontp17Container) {
                    fontp17_Enable.setVisibility(View.GONE);
                    fontp17_Disable.setVisibility(View.GONE);
                } else if (linearLayout == fontp18Container) {
                    fontp18_Enable.setVisibility(View.GONE);
                    fontp18_Disable.setVisibility(View.GONE);
                   
                }
            }
        }
    }

    // Function to check for bg drawable changes
    private void refreshBackground() {
        checkIfApplied(fontp1Container, 1);
        checkIfApplied(fontp2Container, 2);
        checkIfApplied(fontp4Container, 3);
        
        checkIfApplied(fontp4Container, 4);
        checkIfApplied(fontp5Container, 5);
        checkIfApplied(fontp6Container, 6);
        checkIfApplied(fontp7Container, 7);
        checkIfApplied(fontp8Container, 8);
        checkIfApplied(fontp9Container, 9);
        checkIfApplied(fontp10Container, 10);
        checkIfApplied(fontp11Container, 11);
        checkIfApplied(fontp12Container, 12);
        checkIfApplied(fontp13Container, 13);
        checkIfApplied(fontp14Container, 14);
        checkIfApplied(fontp15Container, 15);
        checkIfApplied(fontp16Container, 16);
        checkIfApplied(fontp17Container, 17);
        checkIfApplied(fontp18Container, 18);
        
    }

    // Function for onClick events
    private void enableOnClickListener(LinearLayout layout, Button enable, Button disable, String key, int index) {

        // Set onClick operation for options in list
        layout.setOnClickListener(v -> {
            refreshLayout(layout);
            if (!PrefConfig.loadPrefBool(Nebula.getAppContext(), key)) {
                disable.setVisibility(View.GONE);
                if (enable.getVisibility() == View.VISIBLE)
                    enable.setVisibility(View.GONE);
                else
                    enable.setVisibility(View.VISIBLE);
            } else {
                enable.setVisibility(View.GONE);
                if (disable.getVisibility() == View.VISIBLE)
                    disable.setVisibility(View.GONE);
                else
                    disable.setVisibility(View.VISIBLE);
            }
        });

        // Set onClick operation for Enable button
        enable.setOnClickListener(v -> {
            refreshLayout(layout);
            // Show loading dialog
            loadingDialog.show("Please Wait");

            Runnable runnable = () -> {
                disable_others(key);
                FontInstaller.install_pack(index);

                runOnUiThread(() -> {
                    PrefConfig.savePrefBool(Nebula.getAppContext(), key, true);

                    new Handler().postDelayed(() -> {
                        // Hide loading dialog
                        loadingDialog.hide();

                        // Change background to selected
                        background(layout.getId(), R.drawable.container_selected);

                        // Change button visibility
                        enable.setVisibility(View.GONE);
                        disable.setVisibility(View.VISIBLE);
                        refreshBackground();

                        Toast.makeText(Nebula.getAppContext(), "Applied", Toast.LENGTH_SHORT).show();
                    }, 3000);
                });
            };
            Thread thread = new Thread(runnable);
            thread.start();
        });

        // Set onClick operation for Disable button
        disable.setOnClickListener(v -> {
            // Show loading dialog
            loadingDialog.show("Please Wait");

            Runnable runnable = () -> {
                FontInstaller.disable_pack(index);

                runOnUiThread(() -> {
                    PrefConfig.savePrefBool(Nebula.getAppContext(), key, false);

                    new Handler().postDelayed(() -> {
                        // Hide loading dialog
                        loadingDialog.hide();

                        // Change background to selected
                        background(layout.getId(), R.drawable.container);

                        // Change button visibility
                        disable.setVisibility(View.GONE);
                        enable.setVisibility(View.VISIBLE);
                        refreshBackground();

                        Toast.makeText(Nebula.getAppContext(), "Disabled", Toast.LENGTH_SHORT).show();
                    }, 3000);
                });
            };
            Thread thread = new Thread(runnable);
            thread.start();
        });
    }

    // Function to disable other packs if one is applied
    private void disable_others(String pack) {
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp1_KEY, pack.equals(fontp1_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp2_KEY, pack.equals(fontp2_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp4_KEY, pack.equals(fontp4_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp4_KEY, pack.equals(fontp4_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp5_KEY, pack.equals(fontp5_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp6_KEY, pack.equals(fontp6_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp7_KEY, pack.equals(fontp7_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp8_KEY, pack.equals(fontp8_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp9_KEY, pack.equals(fontp9_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp10_KEY, pack.equals(fontp10_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp11_KEY, pack.equals(fontp11_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp12_KEY, pack.equals(fontp12_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp13_KEY, pack.equals(fontp13_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp14_KEY, pack.equals(fontp14_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp15_KEY, pack.equals(fontp15_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp16_KEY, pack.equals(fontp16_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp17_KEY, pack.equals(fontp17_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), fontp18_KEY, pack.equals(fontp18_KEY));
        
    }

    // Function to change applied pack's bg
    private void checkIfApplied(LinearLayout layout, int icon) {
        if (PrefConfig.loadPrefBool(Nebula.getAppContext(), "SaOverlaysFONTS" + icon + ".overlay")) {
            background(layout.getId(), R.drawable.container_selected);
        } else {
            background(layout.getId(), R.drawable.container);
        }
    }

    // Function to add border for installed pack
    private void background(int id, int drawable) {
        LinearLayout layout = findViewById(id);
        layout.setBackground(ContextCompat.getDrawable(this, drawable));
    }

    // Function to add new item in list
    private void addItem(int id, String title, String desc, int enableid, int disableid) {
        View list = LayoutInflater.from(this).inflate(R.layout.list_option_fonts_manager, container, false);

        TextView name = list.findViewById(R.id.list_title_iconpack);
        TextView info = list.findViewById(R.id.list_desc_iconpack);
        Button enable = list.findViewById(R.id.list_button_enable_iconpack);
        Button disable = list.findViewById(R.id.list_button_disable_iconpack);

        list.setId(id);
        name.setText(title);
        info.setText(desc);
        enable.setId(enableid);
        disable.setId(disableid);

        container.addView(list);
    }

    @Override
    public void onDestroy() {
        loadingDialog.hide();
        super.onDestroy();
    }
}