package com.ad.pspsegundapractica.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import com.ad.pspsegundapractica.R;
import com.ad.pspsegundapractica.model.room.entity.AmigoPOJO;
import com.ad.pspsegundapractica.view.adapter.AmigoAdapter;
import com.ad.pspsegundapractica.viewmodel.AmigoViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 100;
    private AmigoViewModel amigoViewModel;
    private AmigoPOJO amigoPOJO;
    final AmigoAdapter adapter = new AmigoAdapter(MainActivity.this, new AmigoAdapter.AmigoDiff());
    Button btnImportContacts;
    private String[] permissionCodes = {Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_CALL_LOG};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amigoViewModel = new ViewModelProvider(this).get(AmigoViewModel.class);
        init();

    }

    private void init() {
        getPermissions();
        RecyclerView rv = findViewById(R.id.recyclerViewAmigo);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        amigoViewModel.getAllAmigoLive().observe(this, new Observer<List<AmigoPOJO>>() {
            @Override
            public void onChanged(List<AmigoPOJO> amigoPOJOS) {
                adapter.submitList(amigoPOJOS);
            }
        });

        btnImportContacts = findViewById(R.id.btnImportContactos);

        initData();
    }

    private void initData() {
        amigoPOJO = new AmigoPOJO();
        amigoPOJO.setNombre("Nicolás");
        amigoPOJO.setFechaNacimiento("22/03/1999");
        amigoPOJO.setTelefono(123456789);
        amigoViewModel.insert(amigoPOJO);

        btnImportContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ImportAmigoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int phonePermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
            int callPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG);
            int contactsPermission = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);

            if (phonePermission != PackageManager.PERMISSION_GRANTED || callPermission != PackageManager.PERMISSION_GRANTED || contactsPermission != PackageManager.PERMISSION_GRANTED) {
                if (shouldShowRequestPermissionRationale(String.valueOf(permissionCodes))) {
                    getPermissions();
                }else{
                    requestPermissions(permissionCodes, REQUEST_CODE);
                }
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0) {
                    boolean ReadCallLogPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean ReadPhoneStatePermission = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    boolean ReadContacts = grantResults[2] == PackageManager.PERMISSION_GRANTED;

                    if (!ReadCallLogPermission || !ReadPhoneStatePermission || !ReadContacts) {
                        getPermissions();
                    }
                }
        }
    }
}