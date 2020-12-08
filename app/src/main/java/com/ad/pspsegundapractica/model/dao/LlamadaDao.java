package com.ad.pspsegundapractica.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ad.pspsegundapractica.model.entity.LlamadaPOJO;

import java.util.List;

@Dao
public interface LlamadaDao {
    @Query("SELECT * FROM llamada")
    LiveData<List<LlamadaPOJO>> getLlamadas();

    @Query("SELECT * FROM llamada WHERE id LIKE :id")
    LlamadaPOJO getLlamada(long id);

    @Insert
    void addLlamada(LlamadaPOJO llamada);

    @Delete
    void deleteLlamada(LlamadaPOJO llamada);

    @Update
    void updateLlamada(LlamadaPOJO llamada);
}
