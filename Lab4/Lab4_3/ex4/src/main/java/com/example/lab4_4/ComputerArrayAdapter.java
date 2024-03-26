package com.example.lab4_4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;


public class ComputerArrayAdapter extends ArrayAdapter<Computer> {

    private Context context;
    private int layoutToBeInflated;
    private List<Computer> computers;

    public ComputerArrayAdapter(@NonNull Context context,
                                int resource,
                                @NonNull List<Computer> computers) {
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
            holder.tvComputerName = row.findViewById(R.id.tv_computer_name);
            holder.ivComputer = row.findViewById(R.id.imv_computer);
            row.setTag(holder);
        } else {
            holder = (ComputerViewHolder) row.getTag();
        }

        Computer computer = computers.get(position);
        holder.tvComputerName.setText(computer.getName());
        if (computer.isSelected()) {
            holder.ivComputer.setImageResource(R.drawable.ic_baseline_computer_24);
        } else {
            holder.ivComputer.setImageResource(R.drawable.ic_baseline_computer_24);
        }

        row.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Computer computer = computers.get(position);
                computer.setSelected(!computer.isSelected());

                notifyDataSetChanged();
            }
        });

        return row;
    }

    private class ComputerViewHolder {

        TextView tvComputerName;
        ImageView ivComputer;
    }
}
