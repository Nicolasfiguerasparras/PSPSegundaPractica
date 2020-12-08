package com.ad.pspsegundapractica.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ad.pspsegundapractica.R;

public class AmigoHolder extends RecyclerView.ViewHolder {

    //private TextView tvItemId, tvItemNombre, tvItemApellidos, tvItemTelefono, tvItemFechaNacimiento, tvItemLocalidad, tvItemCalle, tvItemNumero;

    public AmigoHolder(@NonNull View itemView) {
        super(itemView);
        /*
            tvItemId = itemView.findViewById(R.id.tvItemId);
            tvItemNombre = itemView.findViewById(R.id.tvItemNombre);
            tvItemApellidos = itemView.findViewById(R.id.tvItemApellidos);
            tvItemTelefono = itemView.findViewById(R.id.tvItemTelefono);
            tvItemFechaNacimiento = itemView.findViewById(R.id.tvItemFechaNacimiento);
            tvItemLocalidad = itemView.findViewById(R.id.tvItemLocalidad);
            tvItemCalle = itemView.findViewById(R.id.tvItemCalle);
            tvItemNumero = itemView.findViewById(R.id.tvItemNumero);
         */
    }

    public void onBindViewHolder(long textId, String textNombre, int textTelefono, String textFechaNacimiento) {
        /*
            tvItemId.setText(String.valueOf(textId));
            tvItemNombre.setText(textNombre);
            tvItemApellidos.setText(textApellidos);
            tvItemTelefono.setText(textTelefono);
            tvItemFechaNacimiento.setText(textFechaNacimiento);
            tvItemLocalidad.setText(textLocalidad);
            tvItemCalle.setText(textCalle);
            tvItemNumero.setText(String.valueOf(textNumero));
         */
    }

    static AmigoHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.amigo_item, parent, false);
        return new AmigoHolder(view);
    }
}