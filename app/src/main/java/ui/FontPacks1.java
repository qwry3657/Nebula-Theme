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

    private static final String sa1_KEY = "SaOverlaysFONTS1.overlay";
    private static final String sa2_KEY = "SaOverlaysFONTS2.overlay";
    private static final String sa3_KEY = "SaOverlaysFONTS3.overlay";
    private static final String sa4_KEY = "SaOverlaysFONTS4.overlay";
    private static final String sa5_KEY = "SaOverlaysFONTS5.overlay";
    private static final String sa6_KEY = "SaOverlaysFONTS6.overlay";
    private static final String sa7_KEY = "SaOverlaysFONTS7.overlay";
    private static final String sa8_KEY = "SaOverlaysFONTS8.overlay";
    private static final String sa9_KEY = "SaOverlaysFONTS9.overlay";
    private static final String sa10_KEY = "SaOverlaysFONTS10.overlay";
    private static final String sa11_KEY = "SaOverlaysFONTS11.overlay";
    private static final String sa12_KEY = "SaOverlaysFONTS12.overlay";
    private static final String sa13_KEY = "SaOverlaysFONTS13.overlay";
    private static final String sa14_KEY = "SaOverlaysFONTS14.overlay";
    private static final String sa15_KEY = "SaOverlaysFONTS15.overlay";
    private static final String sa16_KEY = "SaOverlaysFONTS16.overlay";
    private static final String sa17_KEY = "SaOverlaysFONTS17.overlay";
    private static final String sa18_KEY = "SaOverlaysFONTS18.overlay";

    LinearLayout[] Container;
    LinearLayout sa1Container, sa2Container, sa3Container, sa4Container, sa5Container, sa6Container, sa7Container, sa8Container, sa9Container, sa10Container, sa11Container, sa12Container, sa13Container, sa14Container, sa15Container, sa16Container, sa17Container, sa18Container;
    Button sa1_Enable, sa1_Disable, sa2_Enable, sa2_Disable, sa3_Enable, sa3_Disable, sa4_Enable, sa4_Disable, sa5_Enable, sa5_Disable, sa6_Enable, sa6_Disable, sa7_Enable, sa7_Disable, sa8_Enable, sa8_Disable, sa9_Enable, sa9_Disable, sa10_Enable, sa10_Disable, sa11_Enable, sa11_Disable, sa12_Enable, sa12_Disable, sa13_Enable, sa13_Disable, sa14_Enable, sa14_Disable, sa15_Enable, sa15_Disable, sa16_Enable, sa16_Disable, sa17_Enable, sa17_Disable, sa18_Enable, sa18_Disable;
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
        addItem(R.id.sa1_container, "Fucek", "Tap to enable/desable font.", R.id.sa1_enable, R.id.sa1_disable);
        addItem(R.id.sa2_container, "Nothing", "Tap to enable/desable font.", R.id.sa2_enable, R.id.sa2_disable);
        addItem(R.id.sa3_container, "Noto Serif", "Tap to enable/desable font.", R.id.sa3_enable, R.id.sa3_disable);
        addItem(R.id.sa4_container, "Linnote Bold", "Tap to enable/desable font.", R.id.sa4_enable, R.id.sa4_disable);
        addItem(R.id.sa5_container, "Tinkerbell", "Tap to enable/desable font.", R.id.sa5_enable, R.id.sa5_disable);
        addItem(R.id.sa6_container, "Samsung One", "Tap to enable/desable font.", R.id.sa6_enable, R.id.sa6_disable);
        addItem(R.id.sa7_container, "Corporativ Sans", "Tap to enable/desable font.", R.id.sa7_enable, R.id.sa7_disable);
        addItem(R.id.sa8_container, "FluidSans", "Tap to enable/desable font.", R.id.sa8_enable, R.id.sa8_disable);
        addItem(R.id.sa9_container, "Dosis", "Tap to enable/desable font.", R.id.sa9_enable, R.id.sa9_disable);
        addItem(R.id.sa10_container, "Sfpro", "Tap to enable/desable font.", R.id.sa10_enable, R.id.sa10_disable);
        addItem(R.id.sa11_container, "Opensans", "Tap to enable/desable font.", R.id.sa11_enable, R.id.sa11_disable);
        addItem(R.id.sa12_container, "Cagliostro", "Tap to enable/desable font.", R.id.sa12_enable, R.id.sa12_disable);
        addItem(R.id.sa13_container, "Chula", "Tap to enable/desable font.", R.id.sa13_enable, R.id.sa13_disable);
        addItem(R.id.sa14_container, "Volte-Rounded", "Tap to enable/desable font.", R.id.sa14_enable, R.id.sa14_disable);
        addItem(R.id.sa15_container, "Arial Rounded mt bold", "Tap to enable/desable font.", R.id.sa15_enable, R.id.sa15_disable);
        addItem(R.id.sa16_container, "Modulus", "Tap to enable/desable font.", R.id.sa16_enable, R.id.sa16_disable);
        addItem(R.id.sa17_container, "ReemKufi ", "Tap to enable/desable font.", R.id.sa17_enable, R.id.sa17_disable);
        addItem(R.id.sa18_container, "Vag Rouned", "Tap to enable/desable font.", R.id.sa18_enable, R.id.sa18_disable);

        // Declaration of sa1
        sa1Container = findViewById(R.id.sa1_container);
        sa1_Enable = findViewById(R.id.sa1_enable);
        sa1_Disable = findViewById(R.id.sa1_disable);

        // Declaration of sa2
        sa2Container = findViewById(R.id.sa2_container);
        sa2_Enable = findViewById(R.id.sa2_enable);
        sa2_Disable = findViewById(R.id.sa2_disable);

        // Declaration of sa3
        sa3Container = findViewById(R.id.sa3_container);
        sa3_Enable = findViewById(R.id.sa3_enable);
        sa3_Disable = findViewById(R.id.sa3_disable);

        // Declaration of sa4
        sa4Container = findViewById(R.id.sa4_container);
        sa4_Enable = findViewById(R.id.sa4_enable);
        sa4_Disable = findViewById(R.id.sa4_disable);

        // Declaration of sa5
        sa5Container = findViewById(R.id.sa5_container);
        sa5_Enable = findViewById(R.id.sa5_enable);
        sa5_Disable = findViewById(R.id.sa5_disable);

        // Declaration of sa6
        sa6Container = findViewById(R.id.sa6_container);
        sa6_Enable = findViewById(R.id.sa6_enable);
        sa6_Disable = findViewById(R.id.sa6_disable);

        // Declaration of sa7
        sa7Container = findViewById(R.id.sa7_container);
        sa7_Enable = findViewById(R.id.sa7_enable);
        sa7_Disable = findViewById(R.id.sa7_disable);

        // Declaration of sa8
        sa8Container = findViewById(R.id.sa8_container);
        sa8_Enable = findViewById(R.id.sa8_enable);
        sa8_Disable = findViewById(R.id.sa8_disable);

        // Declaration of sa9
        sa9Container = findViewById(R.id.sa9_container);
        sa9_Enable = findViewById(R.id.sa9_enable);
        sa9_Disable = findViewById(R.id.sa9_disable);

        // Declaration of sa10
        sa10Container = findViewById(R.id.sa10_container);
        sa10_Enable = findViewById(R.id.sa10_enable);
        sa10_Disable = findViewById(R.id.sa10_disable);

        // Declaration of sa11
        sa11Container = findViewById(R.id.sa11_container);
        sa11_Enable = findViewById(R.id.sa11_enable);
        sa11_Disable = findViewById(R.id.sa11_disable);

        // Declaration of sa12
        sa12Container = findViewById(R.id.sa12_container);
        sa12_Enable = findViewById(R.id.sa12_enable);
        sa12_Disable = findViewById(R.id.sa12_disable);

        // Declaration of sa13
        sa13Container = findViewById(R.id.sa13_container);
        sa13_Enable = findViewById(R.id.sa13_enable);
        sa13_Disable = findViewById(R.id.sa13_disable);

        // Declaration of sa14
        sa14Container = findViewById(R.id.sa14_container);
        sa14_Enable = findViewById(R.id.sa14_enable);
        sa14_Disable = findViewById(R.id.sa14_disable);
        
        // Declaration of sa15
        sa15Container = findViewById(R.id.sa15_container);
        sa15_Enable = findViewById(R.id.sa15_enable);
        sa15_Disable = findViewById(R.id.sa15_disable);
        
        // Declaration of sa16
        sa16Container = findViewById(R.id.sa16_container);
        sa16_Enable = findViewById(R.id.sa16_enable);
        sa16_Disable = findViewById(R.id.sa16_disable);
        
        // Declaration of sa17
        sa17Container = findViewById(R.id.sa17_container);
        sa17_Enable = findViewById(R.id.sa17_enable);
        sa17_Disable = findViewById(R.id.sa17_disable);

        // Declaration of sa18
        sa18Container = findViewById(R.id.sa18_container);
        sa18_Enable = findViewById(R.id.sa18_enable);
        sa18_Disable = findViewById(R.id.sa18_disable);
        
        // List of Icon Pack
        Container = new LinearLayout[]{sa1Container, sa2Container, sa3Container, sa4Container, sa5Container, sa6Container, sa7Container, sa8Container, sa9Container, sa10Container, sa11Container, sa12Container, sa13Container, sa14Container, sa15Container, sa16Container, sa17Container, sa18Container};

        // Enable onClick event
        enableOnClickListener(sa1Container, sa1_Enable, sa1_Disable, sa1_KEY, 1);
        enableOnClickListener(sa2Container, sa2_Enable, sa2_Disable, sa2_KEY, 2);
        enableOnClickListener(sa3Container, sa3_Enable, sa3_Disable, sa3_KEY, 3);
        enableOnClickListener(sa4Container, sa4_Enable, sa4_Disable, sa4_KEY, 4);
        enableOnClickListener(sa5Container, sa5_Enable, sa5_Disable, sa5_KEY, 5);
        enableOnClickListener(sa6Container, sa6_Enable, sa6_Disable, sa6_KEY, 6);
        enableOnClickListener(sa7Container, sa7_Enable, sa7_Disable, sa7_KEY, 7);
        enableOnClickListener(sa8Container, sa8_Enable, sa8_Disable, sa8_KEY, 8);
        enableOnClickListener(sa9Container, sa9_Enable, sa9_Disable, sa9_KEY, 9);
        enableOnClickListener(sa10Container, sa10_Enable, sa10_Disable, sa10_KEY, 10);
        enableOnClickListener(sa11Container, sa11_Enable, sa11_Disable, sa11_KEY, 11);
        enableOnClickListener(sa12Container, sa12_Enable, sa12_Disable, sa12_KEY, 12);
        enableOnClickListener(sa13Container, sa13_Enable, sa13_Disable, sa13_KEY, 13);
        enableOnClickListener(sa14Container, sa14_Enable, sa14_Disable, sa14_KEY, 14);
        enableOnClickListener(sa15Container, sa15_Enable, sa15_Disable, sa15_KEY, 15);
        enableOnClickListener(sa16Container, sa16_Enable, sa16_Disable, sa16_KEY, 16);
        enableOnClickListener(sa17Container, sa17_Enable, sa17_Disable, sa17_KEY, 17);
        enableOnClickListener(sa18Container, sa18_Enable, sa18_Disable, sa18_KEY, 18);

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
                if (linearLayout == sa1Container) {
                    sa1_Enable.setVisibility(View.GONE);
                    sa1_Disable.setVisibility(View.GONE);
                } else if (linearLayout == sa2Container) {
                    sa2_Enable.setVisibility(View.GONE);
                    sa2_Disable.setVisibility(View.GONE);
                } else if (linearLayout == sa3Container) {
                    sa3_Enable.setVisibility(View.GONE);
                    sa3_Disable.setVisibility(View.GONE);
                 
                } else if (linearLayout == sa4Container) {
                    sa4_Enable.setVisibility(View.GONE);
                    sa4_Disable.setVisibility(View.GONE);
                } else if (linearLayout == sa5Container) {
                    sa5_Enable.setVisibility(View.GONE);
                    sa5_Disable.setVisibility(View.GONE);
                } else if (linearLayout == sa6Container) {
                    sa6_Enable.setVisibility(View.GONE);
                    sa6_Disable.setVisibility(View.GONE);
                } else if (linearLayout == sa7Container) {
                    sa7_Enable.setVisibility(View.GONE);
                    sa7_Disable.setVisibility(View.GONE);
                } else if (linearLayout == sa8Container) {
                    sa8_Enable.setVisibility(View.GONE);
                    sa8_Disable.setVisibility(View.GONE);
                } else if (linearLayout == sa9Container) {
                    sa9_Enable.setVisibility(View.GONE);
                    sa9_Disable.setVisibility(View.GONE);
                } else if (linearLayout == sa10Container) {
                    sa10_Enable.setVisibility(View.GONE);
                    sa10_Disable.setVisibility(View.GONE);
                } else if (linearLayout == sa11Container) {
                    sa11_Enable.setVisibility(View.GONE);
                    sa11_Disable.setVisibility(View.GONE);
                } else if (linearLayout == sa12Container) {
                    sa12_Enable.setVisibility(View.GONE);
                    sa12_Disable.setVisibility(View.GONE);
                } else if (linearLayout == sa13Container) {
                    sa13_Enable.setVisibility(View.GONE);
                    sa13_Disable.setVisibility(View.GONE);
                } else if (linearLayout == sa14Container) {
                    sa14_Enable.setVisibility(View.GONE);
                    sa14_Disable.setVisibility(View.GONE);
                } else if (linearLayout == sa15Container) {
                    sa15_Enable.setVisibility(View.GONE);
                    sa15_Disable.setVisibility(View.GONE);
                } else if (linearLayout == sa16Container) {
                    sa16_Enable.setVisibility(View.GONE);
                    sa16_Disable.setVisibility(View.GONE);
                } else if (linearLayout == sa17Container) {
                    sa17_Enable.setVisibility(View.GONE);
                    sa17_Disable.setVisibility(View.GONE);
                } else if (linearLayout == sa18Container) {
                    sa18_Enable.setVisibility(View.GONE);
                    sa18_Disable.setVisibility(View.GONE);
                   
                }
            }
        }
    }

    // Function to check for bg drawable changes
    private void refreshBackground() {
        checkIfApplied(sa1Container, 1);
        checkIfApplied(sa2Container, 2);
        checkIfApplied(sa3Container, 3);
        
        checkIfApplied(sa4Container, 4);
        checkIfApplied(sa5Container, 5);
        checkIfApplied(sa6Container, 6);
        checkIfApplied(sa7Container, 7);
        checkIfApplied(sa8Container, 8);
        checkIfApplied(sa9Container, 9);
        checkIfApplied(sa10Container, 10);
        checkIfApplied(sa11Container, 11);
        checkIfApplied(sa12Container, 12);
        checkIfApplied(sa13Container, 13);
        checkIfApplied(sa14Container, 14);
        checkIfApplied(sa15Container, 15);
        checkIfApplied(sa16Container, 16);
        checkIfApplied(sa17Container, 17);
        checkIfApplied(sa18Container, 18);
        
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
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa1_KEY, pack.equals(sa1_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa2_KEY, pack.equals(sa2_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa3_KEY, pack.equals(sa3_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa4_KEY, pack.equals(sa4_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa5_KEY, pack.equals(sa5_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa6_KEY, pack.equals(sa6_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa7_KEY, pack.equals(sa7_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa8_KEY, pack.equals(sa8_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa9_KEY, pack.equals(sa9_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa10_KEY, pack.equals(sa10_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa11_KEY, pack.equals(sa11_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa12_KEY, pack.equals(sa12_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa13_KEY, pack.equals(sa13_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa14_KEY, pack.equals(sa14_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa15_KEY, pack.equals(sa15_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa16_KEY, pack.equals(sa16_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa17_KEY, pack.equals(sa17_KEY));
        PrefConfig.savePrefBool(Nebula.getAppContext(), sa18_KEY, pack.equals(sa18_KEY));
        
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