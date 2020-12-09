package com.ad.pspsegundapractica.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import com.ad.pspsegundapractica.R;

import androidx.recyclerview.widget.RecyclerView;



public class AmigoHolder extends RecyclerView.ViewHolder {

    private TextView tvItemId, tvItemNombre, tvItemTelefono, tvItemFechaNacimiento, tvItemNumeroLlamadas;

    public AmigoHolder(@NonNull View itemView) {
        super(itemView);

        tvItemId = itemView.findViewById(R.id.tvItemId);
        tvItemNombre = itemView.findViewById(R.id.tvItemNombre);
        tvItemTelefono = itemView.findViewById(R.id.tvItemTelefono);
        tvItemFechaNacimiento = itemView.findViewById(R.id.tvItemFechaNacimiento);
        tvItemNumeroLlamadas = itemView.findViewById(R.id.tvItemNumeroLlamadas);
    }

    public void onBindViewHolder(long textId, String textNombre, int textTelefono, String textFechaNacimiento, int textNumeroLlamadas) {
        tvItemId.setText(String.valueOf(textId));
        tvItemNombre.setText(textNombre);
        tvItemTelefono.setText(String.valueOf(textTelefono));
        tvItemFechaNacimiento.setText(textFechaNacimiento);
        tvItemNumeroLlamadas.setText(String.valueOf(textNumeroLlamadas));
    }

    static AmigoHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.amigo_item, parent, false);
        return new AmigoHolder(view);
    }
}