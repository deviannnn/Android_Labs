package vn.edu.tdtu.login;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private TextView tvFollower, tvFollowing;
    private Button btnFl;
    private int follower, following;
    private boolean isFollowed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvFollower = findViewById(R.id.tvFollower);
        tvFollowing = findViewById(R.id.tvFollowing);
        btnFl = findViewById(R.id.btnFl);

        follower = (int) (Math.random() * (10000 - 100 + 1) + 100);
        following = (int) (Math.random() * (10000 - 100 + 1) + 100);

        tvFollower.setText(String.valueOf(follower));
        tvFollowing.setText(String.valueOf(following));

        btnFl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFollowed) {
                    follower--;
                    btnFl.setText("Follow");
                } else {
                    follower++;
                    btnFl.setText("Unfollow");
                }
                isFollowed = !isFollowed;
                tvFollower.setText(String.valueOf(follower));
            }
        });
    }
}