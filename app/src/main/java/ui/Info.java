package com.sajjad.nebula.ui;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.sajjad.nebula.BuildConfig;
import com.sajjad.nebula.Nebula;
import com.sajjad.nebula.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Objects;

public class Info extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        
        // App version
        ViewGroup appInfo = findViewById(R.id.appInfo);
        appInfo.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("Nebula Version", "Nebula\nVersion Name: " + BuildConfig.VERSION_NAME + "\nVersion Code: " + BuildConfig.VERSION_CODE);
            clipboard.setPrimaryClip(clip);
            Toast toast = Toast.makeText(Nebula.getAppContext(), "Copied to Clipboard", Toast.LENGTH_SHORT);
            toast.show();
        });
        ImageView ic_appVersion = findViewById(R.id.ic_appVersion);
        ic_appVersion.setBackgroundResource(R.drawable.ic_info);
        TextView appVersion = findViewById(R.id.appVersion);
        appVersion.setText("Version");
        TextView versionCodeAndName = findViewById(R.id.versionCodeAndName);
        versionCodeAndName.setText(BuildConfig.VERSION_NAME);

        // Telegram
        ViewGroup telegramChannel = findViewById(R.id.telegramChannel);
        telegramChannel.setOnClickListener(v -> {
            String url = "https://t.me/sa_sajjad_2";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        ImageView ic_telegram = findViewById(R.id.ic_telegram);
        ic_telegram.setBackgroundResource(R.drawable.ic_telegram);
        TextView telegramTitle = findViewById(R.id.telegramTitle);
        telegramTitle.setText("Telegram Channel");
        TextView telegramDesc = findViewById(R.id.telegramDesc);
        telegramDesc.setText("Follow to get latest news & updates.");

        // Devs

        // Sã Śâjjãd
        ViewGroup sa = findViewById(R.id.sa);
        sa.setOnClickListener(v -> {
            String url = "https://t.me/sa_sajjad_2";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        ImageView ic_sa = findViewById(R.id.ic_sa);
        ic_sa.setBackgroundResource(R.drawable.ic_sa);
        TextView credits2 = findViewById(R.id.credits2);
        credits2.setText("Sã Śâjjãd");
        TextView creditsTo1 = findViewById(R.id.creditsTo1);
        creditsTo1.setText("Author");

        // Drdisagree
        ViewGroup drdisagree = findViewById(R.id.drdisagree);
        drdisagree.setOnClickListener(v -> {
            String url = "https://t.me/DrDisagree";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        ImageView ic_drdisagree = findViewById(R.id.ic_drdisagree);
        ic_drdisagree.setBackgroundResource(R.drawable.ic_drdisagree);
        TextView credits = findViewById(R.id.credits);
        credits.setText("Drdisagree");
        TextView creditsTo = findViewById(R.id.creditsTo);
        creditsTo.setText("Pro sir & Iconify dev.");
        
        // Iconify
        ViewGroup iconify = findViewById(R.id.iconify);
        iconify.setOnClickListener(v -> {
            String url = "https://t.me/IconifyOfficial";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        ImageView ic_iconify = findViewById(R.id.ic_iconify);
        ic_iconify.setBackgroundResource(R.drawable.ic_iconify);
        TextView iconify1 = findViewById(R.id.iconify1);
        iconify1.setText("ICONIFY");
        TextView iconify2 = findViewById(R.id.iconify2);
        iconify2.setText("For base template.");
        
        // Healer's Port Hub
        ViewGroup healer99 = findViewById(R.id.healer99);
        healer99.setOnClickListener(v -> {
            String url = "https://t.me/flipxroms";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
        TextView credits1 = findViewById(R.id.credits1);
        credits1.setText("Healer's Port Hub");
        TextView creditsTo2 = findViewById(R.id.creditsTo2);
        creditsTo2.setText("For Awesome idea.");
        
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
