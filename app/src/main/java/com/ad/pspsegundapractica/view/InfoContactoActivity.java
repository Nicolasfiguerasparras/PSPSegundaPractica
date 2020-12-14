package com.ad.pspsegundapractica.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.ad.pspsegundapractica.R;
import com.ad.pspsegundapractica.model.room.entity.AmigoPOJO;
import com.ad.pspsegundapractica.view.adapter.ContactoAdapter;
import com.ad.pspsegundapractica.viewmodel.AmigoViewModel;

import java.util.ArrayList;

public class InfoContactoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_contacto);

        Intent intent = getIntent();

        ArrayList<String> arrayList = intent.getStringArrayListExtra(ContactoAdapter.INTENT);
        String nombre = arrayList.get(0);
        String telefono = arrayList.get(1);
        String fecha = arrayList.get(2);

        AmigoPOJO amigoPOJO = new AmigoPOJO(nombre, fecha, Integer.parseInt(telefono));

        AmigoViewModel amigoViewModel = new ViewModelProvider(this).get(AmigoViewModel.class);
        amigoViewModel.insert(amigoPOJO);
        Intent intent1 = new Intent(InfoContactoActivity.this, MainActivity.class);
        startActivity(intent1);
    }
}