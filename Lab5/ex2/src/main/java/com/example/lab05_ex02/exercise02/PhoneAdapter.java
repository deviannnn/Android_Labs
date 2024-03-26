package com.example.lab05_ex02.exercise02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab05_ex02.R;
import java.util.List;

public class PhoneAdapter extends ArrayAdapter<Phone> {

    private Context context;
    private int layout;
    private List<Phone> data;

    public PhoneAdapter(@NonNull Context context, int resource, @NonNull List<Phone> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.data = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);

            holder = new ViewHolder();
            holder.icon = convertView.findViewById(R.id.icon);
            holder.name = convertView.findViewById(R.id.name);
            holder.check = convertView.findViewById(R.id.checkbox);

            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Phone p = data.get(position);

        holder.icon.setImageResource(p.getIcon());
        holder.name.setText(p.getName());
        holder.check.setChecked(p.isChecked());
        holder.check.setTag(position); // attach position to checkbox

        holder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Phone p = data.get(position);
                boolean checked = ((CheckBox)v).isChecked();
                p.setChecked(checked);
            }
        });
        return convertView;
    }

    public static class ViewHolder {
        ImageView icon;
        TextView name;
        CheckBox check;
    }
}
