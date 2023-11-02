package com.example.permisos3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.permisos3.adapters.RecyclerViewAdapters;
import com.example.permisos3.models.Permisos;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Permisos> permisos = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAllPermissions();
        RecyclerViewAdapters adapter = new RecyclerViewAdapters(permisos, this);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void getAllPermissions(){
        String[] names = getResources().getStringArray(R.array.permisos_txt);
        String[] permissions = getResources().getStringArray(R.array.permissions);

        for(int i = 0; i < names.length; i++){
            permisos.add(new Permisos(names[i], permissions[i]));
        }
    }

}