package com.example.bai05;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<User> users;
    private UserAdapter adapter;

    private TextView tvTotalUsers;
    private Button btnAddUser;
    private Button btnRemoveUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        users = new ArrayList<>();
        adapter = new UserAdapter(users, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        tvTotalUsers = findViewById(R.id.tvTotalUsers);
        btnAddUser = findViewById(R.id.btnAddUser);
        btnRemoveUser = findViewById(R.id.btnRemoveUser);

        handlerEvent();
    }

    private void handlerEvent() {
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser(5);
                setTotalUsers();
                adapter.notifyDataSetChanged();
            }
        });

        btnRemoveUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (users.isEmpty()) {
                    Toast.makeText(MainActivity.this, "List of users is empty", Toast.LENGTH_LONG).show();
                } else {
                    removeUser(5);
                    setTotalUsers();
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void createUser(int number) {
        int from = users.size() + 1;
        int to = from + number;
        for (int i = from; i < to; i++) {
            users.add(new User("User " + i, "user" + i + "@tdtu.edu.vn"));
        }
    }

    private void removeUser(int number) {
        for (int i = 0; i < number; i++) {
            users.remove(users.size() - 1);
        }
    }

    private void setTotalUsers() {
        int total = users.size();
        tvTotalUsers.setText("Total user: " + total);
    }
}