package com.example.bai01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder>{
    private ArrayList<Phone> phones;
    private Context context;

    public PhoneAdapter(ArrayList<Phone> phones, Context context) {
        this.phones = phones;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPic;
        TextView tvName;
        CheckBox cbxChoose;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPic = itemView.findViewById(R.id.ivPic);
            tvName = itemView.findViewById(R.id.tvName);
            cbxChoose = itemView.findViewById(R.id.cbxChoose);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View itemView = inflater.inflate(R.layout.row_item_phone, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Phone phone = this.phones.get(position);
        holder.ivPic.setImageResource(phone.getPicAvatar());
        holder.tvName.setText(phone.getName());

        holder.cbxChoose.setChecked(phone.isChecked());
        holder.cbxChoose.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                phone.setChecked(holder.cbxChoose.isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.phones.size();
    }
}
