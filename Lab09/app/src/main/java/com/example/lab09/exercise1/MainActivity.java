package com.example.lab09.exercise1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.lab09.R;
import com.example.lab09.exercise1.recycler.DownloadFile;
import com.example.lab09.exercise1.recycler.FileAdapter;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtUrl;
    private Button btnDownload;
    private RecyclerView recyclerView;
    private LinearLayout emptyView;
    private FileAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Download Manager");

        initViews();
        initObject();
        updateUI();
    }

    private void updateUI() {
        if (adapter.getItemCount() == 0) {
            emptyView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }else {
            emptyView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    private void initObject() {
        adapter = new FileAdapter();
        adapter.setFiles(DownloadFile.generate());
        recyclerView.setAdapter(adapter);
    }

    private void initViews() {
        txtUrl = findViewById(R.id.txtUrl);
        btnDownload = findViewById(R.id.btnDownload);
        emptyView = findViewById(R.id.emptyView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));

        btnDownload.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}