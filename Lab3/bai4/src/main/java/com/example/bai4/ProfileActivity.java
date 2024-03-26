package com.example.bai4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {
    private EditText etJob, etName, etPhone, etMail, etAddress, etLink;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        etJob = findViewById(R.id.etJob);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etMail = findViewById(R.id.etMail);
        etAddress = findViewById(R.id.etAddress);
        etLink = findViewById(R.id.etLink);
        btnSave = findViewById(R.id.btnSave);

        Intent ProfileIntent = getIntent();
        String job = ProfileIntent.getStringExtra("job");
        String name = ProfileIntent.getStringExtra("name");
        String phone = ProfileIntent.getStringExtra("phone");
        String mail = ProfileIntent.getStringExtra("mail");
        String address = ProfileIntent.getStringExtra("address");
        String link = ProfileIntent.getStringExtra("link");

        etJob.setText(job);
        etName.setText(name);
        etPhone.setText(phone);
        etMail.setText(mail);
        etAddress.setText(address);
        etLink.setText(link);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("job",  etJob.getText().toString());
                resultIntent.putExtra("name",  etName.getText().toString());
                resultIntent.putExtra("phone",  etPhone.getText().toString());
                resultIntent.putExtra("mail",  etMail.getText().toString());
                resultIntent.putExtra("address",  etAddress.getText().toString());
                resultIntent.putExtra("link",  etLink.getText().toString());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}