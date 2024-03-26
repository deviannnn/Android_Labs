package com.example.lab05_ex02;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab05_ex02.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private EventAdapter mAdapter;
    private List<Event> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initData();

        registerForContextMenu(mListView);
    }

    private void initViews() {
        mListView = findViewById(R.id.listView);
    }

    private void initData() {
        mData = new ArrayList<>();
        mData.add(new Event("Sinh hoat chu nhiem", "c120", "09/03/2020", "04:43"));
        mData.add(new Event("Huong dan luan van", "c120", "09/03/2020", "04:43"));

        mAdapter = new EventAdapter(this, R.layout.ex2_row_layout, mData);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.exercise03_option_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.miSwitch);
        menuItem.setActionView(R.layout.action_bar);

        Switch switchEvent = menuItem.getActionView().findViewById(R.id.sw_event);

        switchEvent.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {

                } else {

                }
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.miDeleteAll) {
            showConfirmDialog();
        } else if (item.getItemId() == R.id.miAbout) {
            showAboutDialog();
        } else if (item.getItemId() == R.id.miCreate) {
            openCreateNewEventActivity();
        }
        return super.onOptionsItemSelected(item);
    }

    private void openCreateNewEventActivity() {
        Intent newEventActivityIntent = new Intent(MainActivity.this, NewEventActivity.class);
        startActivityForResult(newEventActivityIntent, 100);
    }

    private void showConfirmDialog() {
        AlertDialog.Builder builder = new Builder(this);
        builder.setTitle("Confirm");
        builder.setMessage("Are you sure to delete all phones?");
        builder.setPositiveButton("OK", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mData.clear();
                mAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "The selected phone is deleted!", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("CANCEL", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog confirmDialog = builder.create();
        confirmDialog.show();
    }

    private void showAboutDialog() {
        AlertDialog.Builder builder = new Builder(this);
        builder.setTitle("About");
        builder.setMessage("The application is developed by android studio!");
        builder.setPositiveButton("OK", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "GOOD LUCK!", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
            Bundle returnedBundle = data.getExtras();
            String title = returnedBundle.getString(NewEventActivity.TITLE);
            String place = returnedBundle.getString(NewEventActivity.PLACE);
            String date = returnedBundle.getString(NewEventActivity.DATE);
            String time = returnedBundle.getString(NewEventActivity.TIME);
            Event newEvent = new Event(title, place, date, time);
            mData.add(newEvent);
            mAdapter.notifyDataSetChanged();
        }
    }
}