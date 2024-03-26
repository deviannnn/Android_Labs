package com.example.android_lab3;

import androidx.activity.result.*;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai1Activity1 extends AppCompatActivity {
    private TextView tvAct1;
    private EditText etEmail;
    private Button btnLogin;

    final ActivityResultLauncher<Intent> launcherActivityInfo = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        String name = data.getStringExtra("name");
                        etEmail.setText(name);
                        btnLogin.setVisibility(View.GONE);
                        tvAct1.setText("Hẹn gặp lại");
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1_bai1);

        tvAct1 = findViewById(R.id.tvAct1);
        etEmail = findViewById(R.id.etEmail);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                if (!email.isEmpty()) {
                    Intent intent = new Intent(Bai1Activity1.this, Bai1Activity2.class);
                    intent.putExtra("email", email);
                    launcherActivityInfo.launch(intent);
                }
            }
        });
    }
}