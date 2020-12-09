package com.ad.pspsegundapractica.model.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ad.pspsegundapractica.model.room.dao.AmigoDao;
import com.ad.pspsegundapractica.model.room.dao.LlamadaDao;
import com.ad.pspsegundapractica.model.room.entity.AmigoPOJO;
import com.ad.pspsegundapractica.model.room.entity.LlamadaPOJO;

@Database(entities = {AmigoPOJO.class, LlamadaPOJO.class}, version = 1, exportSchema = false)
public abstract class AmigoDatabase extends RoomDatabase {

    public abstract AmigoDao getAmigoDao();
    public abstract LlamadaDao getLlamadaDao();

    private static volatile AmigoDatabase INSTANCE;

    public static synchronized AmigoDatabase getAmigoDatabase(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AmigoDatabase.class, "AmigoDatabase.sqlite").build();
        }
        return INSTANCE;
    }

}