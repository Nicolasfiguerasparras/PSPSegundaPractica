package com.ad.pspsegundapractica.model.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.ad.pspsegundapractica.model.room.entity.AmigoPOJO;
import com.ad.pspsegundapractica.model.room.entity.LlamadaAmigoPOJO;

import java.util.List;

@Dao
public interface AmigoDao {

    @Query("SELECT * FROM amigo ORDER BY nombre")
    LiveData<List<AmigoPOJO>> getAmigosLive();

    @Query("SELECT * FROM amigo ORDER BY id")
    List<AmigoPOJO> getAmigos();

    @Query("SELECT * FROM amigo WHERE id LIKE :id")
    AmigoPOJO getAmigo(long id);

    @Query("select a.id, a.nombre, a.telefono, a.fechaNacimiento, count(l.id) count from amigo a left join llamada l on a.id = l.idAmigo group by a.id, a.nombre, a.telefono, a.fechaNacimiento order by nombre")
    LiveData<List<LlamadaAmigoPOJO>> getLlamadasAmigo();

    @Query("select id from amigo where telefono = :telefono")
    long selectIdFromIncomingCall (String telefono);

    @Query("delete from amigo where id = :id")
    int delete(long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addAmigo(AmigoPOJO amigo);

    @Delete
    void deleteAmigo(AmigoPOJO amigo);

    @Update
    void updateAmigo(AmigoPOJO amigo);
}