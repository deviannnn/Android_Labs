package vn.edu.tdtu.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText etUserName, etPass;
    private Button btnSignIn, btnReset;
    private TextView tvReset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName = findViewById(R.id.etUserName);
        etPass = findViewById(R.id.etPass);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvReset = findViewById(R.id.textView);
        tvReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etUserName.getText().toString();
                if (userName.equals("")) {
                    Toast.makeText(LoginActivity.this,
                            "Vui lòng nhập username",
                            Toast.LENGTH_LONG).show();
                }
                if (userName.equals("admin")) {
                    Toast.makeText(LoginActivity.this,
                            "Reset mật khẩu thành công",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etUserName.getText().toString();
                String password = etPass.getText().toString();
                if (userName.equals("") || password.equals("")) {
                    Toast.makeText(LoginActivity.this,
                            "Vui lòng nhập username hoặc password",
                            Toast.LENGTH_LONG).show();
                }
                if (password.length() < 6
                        || !password.matches(".*[A-Z].*")
                        || !password.matches(".*[a-z].*")) {
                    Toast.makeText(LoginActivity.this,
                            "Mật khẩu không đúng yêu cầu",
                            Toast.LENGTH_LONG).show();
                }
                if (userName.equals("admin") && password.equals("admin1234")) {
                    Toast.makeText(LoginActivity.this,
                            "Đăng nhập thành công",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etUserName.getText().toString();
                if (userName.equals("")) {
                    Toast.makeText(LoginActivity.this,
                            "Vui lòng nhập username",
                            Toast.LENGTH_LONG).show();
                }
                if (userName.equals("admin")) {
                    Toast.makeText(LoginActivity.this,
                            "Reset mật khẩu thành công",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}