package com.example.lab09;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lab09.exercise01.DownloadFileListActivity;
import com.example.lab09.exercise02.MediaFileActivity;
import com.example.lab09.exercise1.MainActivity;

public class MoveActivity extends AppCompatActivity {

    Button exer1, exer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        exer1 = findViewById(R.id.exer1);
        exer2 = findViewById(R.id.exer2);
        exer1.setOnClickListener(view -> {
            startActivity(new Intent(this, DownloadFileListActivity.class));
        });
        exer2.setOnClickListener(view -> {
            startActivity(new Intent(this, MediaFileActivity.class));
        });
    }
}