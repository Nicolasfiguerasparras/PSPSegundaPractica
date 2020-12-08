package com.ad.pspsegundapractica.model.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ad.pspsegundapractica.model.dao.AmigoDao;
import com.ad.pspsegundapractica.model.entity.AmigoPOJO;

@Database(entities = {AmigoPOJO.class}, version = 1, exportSchema = false)
public abstract class AmigoDatabase extends RoomDatabase {

    public abstract AmigoDao getAmigoDao();

    private static volatile AmigoDatabase INSTANCE;

    public static synchronized AmigoDatabase getAmigoDatabase(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AmigoDatabase.class, "AmigoDatabase.sqlite").build();
        }
        return INSTANCE;
    }

}