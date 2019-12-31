package com.jeet.demoapp;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    MainActivity context1;
    Model model;
    ArrayList<Model> al;

    public Adapter(MainActivity context1, ArrayList<Model> al) {
        this.context1 = context1;
        this.al = al;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.man_data, parent, false);
        // create ViewHolder
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        model = al.get(position);
        holder.tvName.setText(model.getName());
        if  (MainActivity.count==5) {
            holder.checkBox.setChecked(true);
        }
        else
        {
            holder.checkBox.setChecked(false);
        }


        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isPressed())
                {
                    if (!isChecked) {
                        MainActivity.count=MainActivity.count-1;
                        context1.checkedBox();
                    } else {
                        MainActivity.count=MainActivity.count+1;

                        context1.checkedBox();
                    }
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            checkBox = itemView.findViewById(R.id.checkbox);

        }
    }
}
