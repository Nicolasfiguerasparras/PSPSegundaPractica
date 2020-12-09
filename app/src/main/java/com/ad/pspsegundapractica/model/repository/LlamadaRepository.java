package com.ad.pspsegundapractica.model.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.ad.pspsegundapractica.model.application.ThreadApplication;
import com.ad.pspsegundapractica.model.room.dao.LlamadaDao;
import com.ad.pspsegundapractica.model.room.database.AmigoDatabase;
import com.ad.pspsegundapractica.model.room.entity.LlamadaPOJO;

import java.util.List;

public class LlamadaRepository {

    private static LlamadaRepository llamadaRepository;

    private LlamadaDao llamadaDao;
    private LiveData<List<LlamadaPOJO>> llamadaLiveList;
    private AmigoDatabase amigoDatabase;

    public LlamadaRepository(Context context){
        Context appContext = context.getApplicationContext();
        amigoDatabase = AmigoDatabase.getAmigoDatabase(context);
        llamadaDao = amigoDatabase.getLlamadaDao();
        llamadaLiveList = llamadaDao.getLlamadasLive();
    }

    public static LlamadaRepository get(Context context) {
        if (llamadaRepository == null) {
            llamadaRepository = new LlamadaRepository(context);
        }
        return llamadaRepository;
    }

    public LiveData<List<LlamadaPOJO>> getLlamadas() {
        return llamadaLiveList;
    }

    public void addLlamada(LlamadaPOJO llamada) {
        ThreadApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                llamadaDao.addLlamada(llamada);
            }
        });
    }

    public void updateLlamada(LlamadaPOJO llamada) {
        ThreadApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                llamadaDao.updateLlamada(llamada);
            }
        });
    }

    public void deleteLlamada(LlamadaPOJO llamada) {
        ThreadApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                llamadaDao.deleteLlamada(llamada);
            }
        });
    }

    public void get(long id){
        ThreadApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                llamadaDao.getLlamada(id);
            }
        });
    }
}
