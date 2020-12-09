package com.ad.pspsegundapractica.model.room;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.ad.pspsegundapractica.model.application.ThreadApplication;
import com.ad.pspsegundapractica.model.room.dao.AmigoDao;
import com.ad.pspsegundapractica.model.room.dao.LlamadaDao;
import com.ad.pspsegundapractica.model.room.database.AmigoDatabase;
import com.ad.pspsegundapractica.model.room.entity.AmigoPOJO;
import com.ad.pspsegundapractica.model.room.entity.LlamadaAmigoPOJO;
import com.ad.pspsegundapractica.model.room.entity.LlamadaPOJO;

import java.util.List;

public class Repository {

    private AmigoDao amigoDao;
    private LlamadaDao llamadaDao;

    private LiveData<List<AmigoPOJO>> liveDataAmigoPOJO;
    private LiveData<List<LlamadaPOJO>> liveDataLlamadaPOJO;
    private LiveData<List<LlamadaAmigoPOJO>> liveDataLlamadaAmigoPOJO;

    public Repository(Context context) {
        AmigoDatabase db = AmigoDatabase.getAmigoDatabase(context);
        amigoDao = db.getAmigoDao();
        llamadaDao = db.getLlamadaDao();
        liveDataAmigoPOJO = amigoDao.getAmigosLive();
        liveDataLlamadaAmigoPOJO = amigoDao.getLlamadasAmigo();
        liveDataLlamadaPOJO = llamadaDao.getLlamadasLive();
    }


    public LiveData<List<AmigoPOJO>> getLiveDataAmigoPOJO() {
        return liveDataAmigoPOJO;
    }

    public void setLiveDataAmigoPOJO(LiveData<List<AmigoPOJO>> liveDataAmigoPOJO) {
        this.liveDataAmigoPOJO = liveDataAmigoPOJO;
    }

    public LiveData<List<LlamadaPOJO>> getLiveDataLlamadaPOJO() {
        return liveDataLlamadaPOJO;
    }

    public void setLiveDataLlamadaPOJO(LiveData<List<LlamadaPOJO>> liveDataLlamadaPOJO) {
        this.liveDataLlamadaPOJO = liveDataLlamadaPOJO;
    }

    public LiveData<List<LlamadaAmigoPOJO>> getLiveDataLlamadaAmigoPOJO() {
        return liveDataLlamadaAmigoPOJO;
    }

    public void setLiveDataLlamadaAmigoPOJO(LiveData<List<LlamadaAmigoPOJO>> liveDataLlamadaAmigoPOJO) {
        this.liveDataLlamadaAmigoPOJO = liveDataLlamadaAmigoPOJO;
    }

    public void insert(AmigoPOJO amigoPOJO){
        ThreadApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                amigoDao.addAmigo(amigoPOJO);
            }
        });
    }

    public void insert(LlamadaPOJO llamadaPOJO){
        ThreadApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                llamadaDao.addLlamada(llamadaPOJO);
            }
        });
    }

    public void update(AmigoPOJO amigoPOJO){
        ThreadApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                amigoDao.updateAmigo(amigoPOJO);
            }
        });
    }

    public void delete(long id){
        ThreadApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                amigoDao.delete(id);
            }
        });
    }

    public void insertLlamada(String telefono){
        ThreadApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                long id = amigoDao.selectIdFromIncomingCall(telefono);
                String fecha = "01/01/2020";
                LlamadaPOJO llamadaPOJO = new LlamadaPOJO(id, fecha);
                llamadaDao.addLlamada(llamadaPOJO);
            }
        });
    }
}
