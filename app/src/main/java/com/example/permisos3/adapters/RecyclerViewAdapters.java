package com.example.permisos3.adapters;
import android.app.Activity;

import android.content.Context;

import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.permisos3.R;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.permisos3.models.Permisos;
import com.google.android.material.switchmaterial.SwitchMaterial;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapters  extends  RecyclerView.Adapter<RecyclerViewAdapters.MyViewHolder> {

    List<Permisos> userList = new ArrayList<>();
    Context ctx;

    public RecyclerViewAdapters(List<Permisos> userList, Context ctx) {
        this.userList = userList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public RecyclerViewAdapters.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.activity_user, parent, false);
        return new RecyclerViewAdapters.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapters.MyViewHolder holder, int position) {
        Permisos permiso = userList.get(position);
        holder.txtName.setText(permiso.getName());

        SwitchMaterial switchMaterial = holder.sw;
        switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String permission = permiso.getPermiso();
                if (isChecked) {
                    if (ContextCompat.checkSelfPermission(holder.itemView.getContext(), permission) == PackageManager.PERMISSION_DENIED) {
                        ActivityCompat.requestPermissions((Activity) holder.itemView.getContext(), new String[]{permission}, 500);
                    } else {

                    }
                } else {

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        SwitchMaterial sw;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtPermiso);
            sw = itemView.findViewById(R.id.sw1);
        }
    }
}
