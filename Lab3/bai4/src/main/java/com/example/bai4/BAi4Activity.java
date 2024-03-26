package com.example.bai4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class BAi4Activity extends AppCompatActivity {
    private ImageButton btnEdit;
    private TextView tvJob, tvName, tvPhone, tvMail, tvAddress, tvLink, tvUsername;
    private ImageView imgView;
    private ActivityResultLauncher<Intent> mProfileLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        String job = data.getStringExtra("job");
                        String name = data.getStringExtra("name");
                        String phone = data.getStringExtra("phone");
                        String mail = data.getStringExtra("mail");
                        String address = data.getStringExtra("address");
                        String link = data.getStringExtra("link");
                        tvJob.setText(job);
                        tvName.setText(name);
                        tvPhone.setText(phone);
                        tvMail.setText(mail);
                        tvAddress.setText(address);
                        tvLink.setText(link);
                        tvUsername.setText(name);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);

        btnEdit = findViewById(R.id.btnEdit);
        tvJob = findViewById(R.id.tvJob);
        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);
        tvMail = findViewById(R.id.tvMail);
        tvAddress = findViewById(R.id.tvAddress);
        tvLink = findViewById(R.id.tvLink);
        tvUsername = findViewById(R.id.tvUsername);
        imgView = findViewById(R.id.imgView);

        btnEdit.setOnClickListener(view -> {
            Intent mainProfile = new Intent(BAi4Activity.this, ProfileActivity.class);
            mainProfile.putExtra("job", tvJob.getText().toString());
            mainProfile.putExtra("name", tvName.getText().toString());
            mainProfile.putExtra("phone", tvPhone.getText().toString());
            mainProfile.putExtra("mail", tvMail.getText().toString());
            mainProfile.putExtra("address", tvAddress.getText().toString());
            mainProfile.putExtra("link", tvLink.getText().toString());
            mProfileLauncher.launch(mainProfile);
        });
    }
}