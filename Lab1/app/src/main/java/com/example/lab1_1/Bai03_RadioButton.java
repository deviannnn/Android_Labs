package com.example.lab1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Bai03_RadioButton extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton rbAndroid,rbIOS,rbWin,rbRIM;
    Button btnResult;
    TextView tvAndroid,tvIOS,tvWin,tvRIM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai03_radio_button);
        radioGroup = findViewById(R.id.radioGroup);
        btnResult = findViewById(R.id.btnResult);
        tvAndroid = findViewById(R.id.tvAndroid);
        tvIOS = findViewById(R.id.tvIOS);
        tvWin = findViewById(R.id.tvWin);
        tvRIM = findViewById(R.id.tvRIM);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int checkedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRB = findViewById(checkedId);
                String selectedRBText = selectedRB.getText().toString();
                tvAndroid.setText("Android: false");
                tvIOS.setText("iOS: false");
                tvWin.setText("Windows: false");
                tvRIM.setText("RIM: false");
                switch (selectedRBText) {
                    case "Android":
                        tvAndroid.setText("Android: true");
                        break;

                    case "iOS":
                        tvIOS.setText("iOS: true");
                        break;

                    case "Windows":
                        tvWin.setText("Windows: true");
                        break;

                    case "RIM":
                        tvRIM.setText("RIM: true");
                        break;
                }
            }
        });
    }
}