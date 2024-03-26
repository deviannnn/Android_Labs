package com.example.lab4_3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Iterator;
import java.util.List;


public class PhoneArrayAdapter extends ArrayAdapter<Phone> {

    private Context context;
    private int layoutToBeInflated;
    private List<Phone> computers;

    public PhoneArrayAdapter(@NonNull Context context,
                             int resource,
                             @NonNull List<Phone> computers) {
        super(context, resource, computers);
        this.computers = computers;
        this.layoutToBeInflated = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ComputerViewHolder holder;
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutToBeInflated, null);
            holder = new ComputerViewHolder();
            holder.tvPhoneName = row.findViewById(R.id.tv_phone);
            holder.cbSelectPhone = row.findViewById(R.id.cb_select_phone);
            row.setTag(holder);
        } else {

            holder = (ComputerViewHolder) row.getTag();
        }

        Phone phone = computers.get(position);
        holder.tvPhoneName.setText(phone.getName());
        holder.cbSelectPhone.setChecked(phone.isSelected());

        row.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Phone computer = computers.get(position);
                Toast.makeText(context,
                        "PHONE CLICKED - " + computer.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        return row;
    }

    public void removeSelected() {
        for (Iterator<Phone> iterator = computers.iterator(); iterator.hasNext();) {
            Phone phone = iterator.next();
            if (phone.isSelected()) {
                iterator.remove();
            }
        }
        notifyDataSetChanged();
    }

    private class ComputerViewHolder {
        TextView tvPhoneName;
        CheckBox cbSelectPhone;
    }
}


