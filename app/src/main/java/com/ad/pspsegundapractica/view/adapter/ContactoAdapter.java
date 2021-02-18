package com.ad.pspsegundapractica.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ad.pspsegundapractica.R;
import com.ad.pspsegundapractica.model.room.entity.AmigoPOJO;
import com.ad.pspsegundapractica.view.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ViewHolder> {
    private Context contexto;
    private List<AmigoPOJO> listAmigoPojo;
    private Intent intent;
    public static final String INTENT = "I";

    public ContactoAdapter(Context contexto, List<AmigoPOJO> listAmigoPojo) {
        this.contexto = contexto;
        this.listAmigoPojo = listAmigoPojo;
    }

    @NonNull
    @Override
    public ContactoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoAdapter.ViewHolder holder, int position) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(listAmigoPojo.get(position).getNombre());
        arrayList.add(String.valueOf(listAmigoPojo.get(position).getTelefono()));
        arrayList.add(listAmigoPojo.get(position).getFechaNacimiento());

        holder.name.setText(listAmigoPojo.get(position).getNombre());
        holder.parentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(contexto, MainActivity.class);
                intent.putExtra(INTENT, arrayList);
                contexto.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listAmigoPojo != null){
            return listAmigoPojo.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ConstraintLayout parentlayout;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvNombreContacto);
            parentlayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
