package com.ad.pspsegundapractica.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;

import com.ad.pspsegundapractica.R;
import com.ad.pspsegundapractica.model.room.entity.AmigoPOJO;
import com.ad.pspsegundapractica.view.adapter.ContactoAdapter;
import com.ad.pspsegundapractica.viewmodel.AmigoViewModel;

import java.util.List;

public class ImportAmigoActivity extends AppCompatActivity {

    private AmigoPOJO amigoPOJO = new AmigoPOJO();
    private List<AmigoPOJO> amigoPOJOList;
    private AmigoViewModel amigoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_amigo);

        init();
    }

    private void init() {
        amigoViewModel = new ViewModelProvider(this).get(AmigoViewModel.class);
        amigoPOJOList = amigoViewModel.getAllAmigo();

        getContacts(getApplicationContext());

        RecyclerView recyclerView = findViewById(R.id.recyclerViewContactos);
        final ContactoAdapter adapter = new ContactoAdapter(ImportAmigoActivity.this, amigoPOJOList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getContacts(Context applicationContext) {
        String[] data = new String[]{ContactsContract.Data.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};
        String order = ContactsContract.Data.DISPLAY_NAME + " ASC";
        String selectionNumber = ContactsContract.Data.MIMETYPE + "= '" + ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE + "' AND " + ContactsContract.CommonDataKinds.Phone.NUMBER + " IS NOT NULL";
        Cursor cursor = applicationContext.getContentResolver()
                                           .query(
                                            ContactsContract.Data.CONTENT_URI,
                                            data,
                                            selectionNumber,
                                            null,
                                            order);
        while(cursor.moveToNext()){
            String nombre = cursor.getString(0);
            String telefono = cursor.getString(1);
            String fecha = "Empty";

            telefono = telefono.replaceAll("[^0-9]","");

            System.out.println(telefono);
            System.out.println(nombre);
            System.out.println(fecha);

            amigoPOJO = new AmigoPOJO();
            amigoPOJO.setNombre(nombre);
            amigoPOJO.setTelefono(Integer.parseInt(telefono));
            amigoPOJO.setFechaNacimiento(fecha);
            amigoViewModel.insert(amigoPOJO);
        }
        cursor.close();
    }
}