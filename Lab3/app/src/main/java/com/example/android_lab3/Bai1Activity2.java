package com.example.android_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai1Activity2 extends AppCompatActivity {
    private TextView tvAct2;
    private EditText etName;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_bai1);

        tvAct2 = findViewById(R.id.tvAct2);
        etName = findViewById(R.id.etName);
        btnSave = findViewById(R.id.btnSave);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        tvAct2.setText("Xin chào, "+ email +". Vui lòng nhập tên");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                String name = etName.getText().toString();
                resultIntent.putExtra("name", name);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

}