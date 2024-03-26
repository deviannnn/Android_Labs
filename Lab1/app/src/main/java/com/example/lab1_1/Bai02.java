package com.example.lab1_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai02 extends AppCompatActivity {
    EditText etContent;
    TextView tvDisplay;
    Button btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai02);
        etContent = findViewById(R.id.etContent);
        tvDisplay = findViewById(R.id.tvDisplay);
        btnClick = findViewById(R.id.btnClick);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etContent.getText().toString().isEmpty())
                {
                    Toast.makeText(Bai02.this, "vui lòng nhập thông tin", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    tvDisplay.setText(etContent.getText());
                    etContent.setText("");
                }
            }
        });

        etContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = charSequence.toString().trim();
                if (input.equals("OFF")) {
                    btnClick.setEnabled(false);
                } else if (input.equals("ON")) {
                    btnClick.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}