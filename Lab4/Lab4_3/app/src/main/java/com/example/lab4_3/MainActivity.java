package com.example.lab4_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvPhone;
    List<Phone> phones = new ArrayList<>();
    Button btnRemoveAll;
    Button btnRemoveSelect;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPhone = findViewById(R.id.lv_items);
        btnRemoveAll = findViewById(R.id.btn_remove_all);
        btnRemoveSelect = findViewById(R.id.btn_remove_select);

        List<Phone> phones = generateRandomItems();

        final PhoneArrayAdapter phoneArrayAdapter = new PhoneArrayAdapter(this, R.layout.ex3_list_items, phones);
        lvPhone.setAdapter(phoneArrayAdapter);
        btnRemoveAll.setOnClickListener((view -> {
            phones.clear();
            phoneArrayAdapter.notifyDataSetChanged();
        }));

        btnRemoveSelect.setOnClickListener((view -> {
            phoneArrayAdapter.removeSelected();
        }));
    }
    private List<Phone> generateRandomItems(){
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Apple", false));
        phones.add(new Phone("Samsung", false));
        phones.add(new Phone("Nokia", false));
        return phones;
    }
}