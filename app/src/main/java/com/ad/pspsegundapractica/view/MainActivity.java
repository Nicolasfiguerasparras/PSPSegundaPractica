package com.ad.pspsegundapractica.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.ad.pspsegundapractica.R;
import com.ad.pspsegundapractica.model.room.entity.AmigoPOJO;
import com.ad.pspsegundapractica.view.adapter.AmigoAdapter;
import com.ad.pspsegundapractica.viewmodel.AmigoViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AmigoViewModel amigoViewModel;
    private Intent intent;
    private AmigoPOJO amigoPOJO;
    final AmigoAdapter adapter = new AmigoAdapter(MainActivity.this, new AmigoAdapter.AmigoDiff());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amigoViewModel = new ViewModelProvider(this).get(AmigoViewModel.class);
        init();

    }

    private void init() {
        RecyclerView rv = findViewById(R.id.recyclerViewAmigo);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        amigoViewModel.getAllAmigo().observe(this, new Observer<List<AmigoPOJO>>() {
            @Override
            public void onChanged(List<AmigoPOJO> amigoPOJOS) {
                adapter.submitList(amigoPOJOS);
            }
        });

        initData();
    }

    private void initData() {
        amigoPOJO = new AmigoPOJO();
        amigoPOJO.setNombre("Nicolás");
        amigoPOJO.setFechaNacimiento("22/03/1999");
        amigoPOJO.setTelefono(639941992);
        amigoViewModel.insert(amigoPOJO);
    }
}