package com.ad.pspsegundapractica.model.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ad.pspsegundapractica.model.dao.LlamadaDao;
import com.ad.pspsegundapractica.model.entity.LlamadaPOJO;

@Database(entities = {LlamadaPOJO.class}, version = 1, exportSchema = false)
public abstract class LlamadaDatabase extends RoomDatabase {

    public abstract LlamadaDao getLlamadaDao();

    private static volatile LlamadaDatabase INSTANCE;

    public static synchronized LlamadaDatabase getLlamadaDatabase(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    LlamadaDatabase.class, "LlamadaDatabase.sqlite").build();
        }
        return INSTANCE;
    }
}
