package com.ad.pspsegundapractica.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.ad.pspsegundapractica.model.entity.AmigoPOJO;
import com.ad.pspsegundapractica.view.EditAmigoActivity;
import com.ad.pspsegundapractica.view.MainActivity;

public class AmigoAdapter  extends ListAdapter<AmigoPOJO, AmigoHolder> {

    private Context context;

    public AmigoAdapter(Context context, @NonNull DiffUtil.ItemCallback<AmigoPOJO> diffCallback) {
        super(diffCallback);
        this.context = context;
    }

    public AmigoAdapter(@NonNull AsyncDifferConfig<AmigoPOJO> config) {
        super(config);
    }

    @NonNull
    @Override
    public AmigoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return AmigoHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull AmigoHolder holder, int position) {
        AmigoPOJO posItem = getItem(position);
        holder.onBindViewHolder(posItem.getId(), posItem.getNombre(), posItem.getTelefono(), posItem.getFechaNacimiento(), 0);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditAmigoActivity.class);
                intent.putExtra("amigo", posItem);
                context.startActivity(intent);
            }
        });
    }

    public static class AmigoDiff extends DiffUtil.ItemCallback<AmigoPOJO> {

        @Override
        public boolean areItemsTheSame(@NonNull AmigoPOJO oldItem, @NonNull AmigoPOJO newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull AmigoPOJO oldItem, @NonNull AmigoPOJO newItem) {
            return oldItem.getNombre().equals(newItem.getNombre());
        }
    }
}