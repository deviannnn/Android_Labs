package com.phamtung230801.lab71;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tvLaunch,tvPause;
    SharedPreferences pref;
    int launchCount, pauseCount;
    long lastStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLaunch = findViewById(R.id.tvOpenTimes);
        tvPause = findViewById(R.id.textView2);

        pref = getPreferences(MODE_PRIVATE);
        launchCount = pref.getInt("launch",0);
        pauseCount = pref.getInt("pause",0);

        launchCount++;

        tvLaunch.setText(String.valueOf(launchCount));
        tvPause.setText(String.valueOf(pauseCount));

    }

    @Override
    protected void onStop() {
        super.onStop();
        lastStop = System.currentTimeMillis();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        long duration = System.currentTimeMillis() - lastStop;
        if (duration >= 5*1000){
            pauseCount++;
            tvPause.setText(String.valueOf(pauseCount));
        }
    }

    @Override
    protected void onDestroy() {

        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("launch",launchCount);
        editor.putInt("pause",pauseCount);

        editor.apply();
        super.onDestroy();
    }
}