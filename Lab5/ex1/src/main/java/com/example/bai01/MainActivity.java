package com.example.bai01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ArrayList<Phone> phones;
    private PhoneAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        phones = initData();
        adapter = new PhoneAdapter(phones, this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.removeSelected) {
            for (int k = phones.size() - 1; k >= 0; k--) {
                if (phones.get(k).isChecked()) {
                    phones.remove(k);
                }
            }
            adapter.notifyDataSetChanged();

        } else if (id == R.id.removeAll) {
            DialogConfirmRemoveAll();
        } else if (id == R.id.checkAll) {
            for (int k = phones.size() -1; k >= 0; k--) {
                phones.get(k).setChecked(true);
            }
            adapter.notifyDataSetChanged();
        } else if (id == R.id.uncheckAll) {
            for (int k = phones.size() -1; k >= 0; k--) {
                phones.get(k).setChecked(false);
            }
            adapter.notifyDataSetChanged();
        }

        return super.onOptionsItemSelected(item);
    }

    private void DialogConfirmRemoveAll() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog
                .setTitle("Confirm")
                .setMessage("Do you want to remove all items?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        phones.clear();
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alert = alertDialog.create();
        alert.show();
    }

    public static ArrayList<Phone> initData() {
        int[] pics = {R.drawable.ic_apple, R.drawable.ic_samsung, R.drawable.ic_nokia, R.drawable.ic_oppo};
        String[] names = {"Apple", "Samsung", "Nokia", "Oppo"};
        Phone phone;
        ArrayList<Phone> phones = new ArrayList<>();
        for (int i = 0; i < pics.length; i++) {
            phone = new Phone(pics[i], names[i]);
            phones.add(phone);
        }
        return phones;
    }
}