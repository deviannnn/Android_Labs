package com.example.lab05_ex02.exercise02;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.lab05_ex02.R;
import java.util.ArrayList;
import java.util.List;

public class Exercise02Activity extends AppCompatActivity {

    private ListView mListView;
    private PhoneAdapter mAdapter;
    private List<Phone> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise02_activity_main);

        initViews();
        initData();

        registerForContextMenu(mListView);
    }

    private void initViews() {
        mListView = findViewById(R.id.listView);
    }

    private void initData() {
        mData = new ArrayList<>();
        mData.add(new Phone(R.drawable.mobile, "Apple"));
        mData.add(new Phone(R.drawable.mobile2, "Samsung"));
        mData.add(new Phone(R.drawable.mobile3, "Nokia"));
        mData.add(new Phone(R.drawable.mobile, "Oppo"));
        mData.add(new Phone(R.drawable.mobile2, "HTC"));
        mData.add(new Phone(R.drawable.mobile3, "Google"));
        mData.add(new Phone(R.drawable.mobile, "Microsoft"));
        mData.add(new Phone(R.drawable.mobile2, "BKav"));
        mData.add(new Phone(R.drawable.mobile3, "VinSmart"));

        mAdapter = new PhoneAdapter(this, R.layout.ex2_row_layout, mData);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        int position = ((AdapterContextMenuInfo) menuInfo).position;
        menu.setHeaderTitle(mData.get(position).getName());

        menu.add("Check/uncheck");
        menu.add("Delete");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int position = ((AdapterContextMenuInfo) item.getMenuInfo()).position;
        if (item.getTitle().equals("Check/uncheck")) {
            Phone phone = mData.get(position);
            phone.setChecked(!phone.isChecked());
            mAdapter.notifyDataSetChanged();
        } else if (item.getTitle().equals("Delete")) {
            mData.remove(position);
            mAdapter.notifyDataSetChanged();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.exercise02_option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.miDeleteAll) {
            showConfirmDialog();
        } else if (item.getItemId() == R.id.miAbout) {
            showAboutDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showConfirmDialog() {
        Builder builder = new Builder(this);
        builder.setTitle("Confirm");
        builder.setMessage("Are you sure to delete all phones?");
        builder.setPositiveButton("OK", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mData.clear();
                mAdapter.notifyDataSetChanged();
                Toast.makeText(Exercise02Activity.this, "The selected phone is deleted!", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("CANCEL", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // do nothing
            }
        });

        AlertDialog confirmDialog = builder.create();
        confirmDialog.show();
    }

    private void showAboutDialog() {
        Builder builder = new Builder(this);
        builder.setTitle("About");
        builder.setMessage("The application is developed by thChung!");
        builder.setPositiveButton("OK", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Exercise02Activity.this, "GOOD LUCK!", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
