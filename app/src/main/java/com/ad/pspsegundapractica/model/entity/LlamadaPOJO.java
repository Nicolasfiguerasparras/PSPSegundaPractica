package com.ad.pspsegundapractica.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "llamada")
public class LlamadaPOJO implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @NonNull
    @ColumnInfo(name = "idAmigo")
    private long idAmigo;

    @NonNull
    @ColumnInfo(name = "fechaLlamada")
    private String fechaLlamada;

    public LlamadaPOJO() {
    }

    public LlamadaPOJO(@NonNull long idAmigo, @NonNull String fechaLlamada) {
        this.id = id;
        this.idAmigo = idAmigo;
        this.fechaLlamada = fechaLlamada;
    }

    @NonNull
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public long getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(long idAmigo) {
        this.idAmigo = idAmigo;
    }

    @NonNull
    public String getFechaLlamada() {
        return fechaLlamada;
    }

    public void setFechaLlamada(@NonNull String fechaLlamada) {
        this.fechaLlamada = fechaLlamada;
    }
}