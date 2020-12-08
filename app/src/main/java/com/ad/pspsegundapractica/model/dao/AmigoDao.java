package com.ad.pspsegundapractica.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ad.pspsegundapractica.model.entity.AmigoPOJO;

import java.util.List;

@Dao
public interface AmigoDao {

    @Query("SELECT * FROM amigo")
    LiveData<List<AmigoPOJO>> getAmigos();

    @Query("SELECT * FROM amigo WHERE id LIKE :id")
    AmigoPOJO getAmigo(long id);

    @Insert
    void addAmigo(AmigoPOJO amigo);

    @Delete
    void deleteAmigo(AmigoPOJO amigo);

    @Update
    void updateAmigo(AmigoPOJO amigo);
}