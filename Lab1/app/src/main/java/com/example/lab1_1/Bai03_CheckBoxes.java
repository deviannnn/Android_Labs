package com.example.lab1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Bai03_CheckBoxes extends AppCompatActivity {
    CheckBox cbAndroid,cbIOS,cbWin,cbRIM;
    Button btnResult;
    TextView tvAndroid,tvIOS,tvWin,tvRIM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai03_check_boxes);
        cbAndroid = findViewById(R.id.cbAndroid);
        cbIOS = findViewById(R.id.cbIOS);
        cbWin = findViewById(R.id.cbWin);
        cbRIM = findViewById(R.id.cbRIM);
        btnResult = findViewById(R.id.btnResult);
        tvAndroid = findViewById(R.id.tvAndroid);
        tvIOS = findViewById(R.id.tvIOS);
        tvWin = findViewById(R.id.tvWin);
        tvRIM = findViewById(R.id.tvRIM);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cbAndroid.isChecked()) {
                    tvAndroid.setText("Android: true");
                }
                else {
                    tvAndroid.setText("Android: false");
                }

                if (cbIOS.isChecked()) {
                    tvIOS.setText("iOS: true");
                }
                else {
                    tvIOS.setText("iOS: false");
                }

                if (cbWin.isChecked()) {
                    tvWin.setText("Windows: true");
                }
                else {
                    tvWin.setText("Windows: false");
                }

                if (cbRIM.isChecked()) {
                    tvRIM.setText("RIM: true");
                }
                else {
                    tvRIM.setText("RIM: false");
                }
            }
        });
    }
}