package com.ad.pspsegundapractica.model;

import android.content.Context;


import androidx.lifecycle.LiveData;

import com.ad.pspsegundapractica.ThreadApplication;
import com.ad.pspsegundapractica.model.dao.AmigoDao;
import com.ad.pspsegundapractica.model.room.AmigoDatabase;
import com.ad.pspsegundapractica.model.entity.AmigoPOJO;

import java.util.List;


public class AmigoRepository {

    private static AmigoRepository amigoRepository;

    private AmigoDao amigoDao;
    private LiveData<List<AmigoPOJO>> amigoLiveList;
    private AmigoDatabase amigoDatabase;

    public AmigoRepository(Context context){
        Context appContext = context.getApplicationContext();
        amigoDatabase = AmigoDatabase.getAmigoDatabase(context);
        amigoDao = amigoDatabase.getAmigoDao();
        amigoLiveList = amigoDao.getAmigos();
    }

    public static AmigoRepository get(Context context) {
        if (amigoRepository == null) {
            amigoRepository = new AmigoRepository(context);
        }
        return amigoRepository;
    }

    public LiveData<List<AmigoPOJO>> getAmigos() {
        return amigoLiveList;
    }

    public void addAmigo(AmigoPOJO amigo) {
        ThreadApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                amigoDao.addAmigo(amigo);
            }
        });
    }

    public void updateAmigo(AmigoPOJO amigo) {
        ThreadApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                amigoDao.updateAmigo(amigo);
            }
        });
    }

    public void deleteAmigo(AmigoPOJO amigo) {
        ThreadApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                amigoDao.deleteAmigo(amigo);
            }
        });
    }

    public void get(long id){
        ThreadApplication.threadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                amigoDao.getAmigo(id);
            }
        });
    }

}
