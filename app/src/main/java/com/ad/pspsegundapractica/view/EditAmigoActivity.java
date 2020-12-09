package com.ad.pspsegundapractica.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.ad.pspsegundapractica.R;
import com.ad.pspsegundapractica.model.room.entity.AmigoPOJO;
import com.ad.pspsegundapractica.viewmodel.AmigoViewModel;

public class EditAmigoActivity extends AppCompatActivity {

    private AmigoPOJO amigoPOJO;
    EditText tietEditNombre, tietEditTelefono, tietEditFechaNacimiento;
    Button btnEdit, btnDelete;
    AmigoViewModel amigoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_amigo);

        init();
        initValues();
    }

    private void initValues() {
        tietEditNombre.setText(amigoPOJO.getNombre());
        tietEditTelefono.setText(String.valueOf(amigoPOJO.getTelefono()));
        if(amigoPOJO.getFechaNacimiento().equals("")){
            tietEditFechaNacimiento.setText("Sin definir");
        }else{
            tietEditFechaNacimiento.setText(amigoPOJO.getFechaNacimiento());
        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amigoPOJO.setNombre(tietEditNombre.getText().toString());
                amigoPOJO.setTelefono(Integer.parseInt(tietEditTelefono.getText().toString()));
                amigoPOJO.setFechaNacimiento(tietEditFechaNacimiento.getText().toString());
                amigoViewModel.update(amigoPOJO);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amigoViewModel.delete(amigoPOJO);
                finish();
            }
        });
    }

    private void init() {
        amigoPOJO = (AmigoPOJO) getIntent().getExtras().getSerializable("amigo");
        amigoViewModel = new ViewModelProvider(this).get(AmigoViewModel.class);

        tietEditNombre = findViewById(R.id.tietEditNombre);
        tietEditTelefono = findViewById(R.id.tietEditTelefono);
        tietEditFechaNacimiento = findViewById(R.id.tietEditFechaNacimiento);

        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
    }
}