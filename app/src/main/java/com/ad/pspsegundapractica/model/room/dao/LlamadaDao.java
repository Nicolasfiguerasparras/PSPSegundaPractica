package com.ad.pspsegundapractica.model.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.ad.pspsegundapractica.model.room.entity.LlamadaPOJO;

import java.util.List;

@Dao
public interface LlamadaDao {
    @Query("SELECT * FROM llamada")
    LiveData<List<LlamadaPOJO>> getLlamadasLive();

    @Query("SELECT * FROM llamada")
    List<LlamadaPOJO> getLlamadas();

    @Query("SELECT * FROM llamada WHERE id LIKE :id")
    LlamadaPOJO getLlamada(long id);

    @Query("DELETE FROM llamada WHERE id = :id")
    int delete(long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addLlamada(LlamadaPOJO llamada);

    @Delete
    void deleteLlamada(LlamadaPOJO llamada);

    @Update
    void updateLlamada(LlamadaPOJO llamada);
}
