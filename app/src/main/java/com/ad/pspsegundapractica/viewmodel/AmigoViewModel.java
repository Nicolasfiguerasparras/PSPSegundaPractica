package com.ad.pspsegundapractica.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ad.pspsegundapractica.model.repository.AmigoRepository;
import com.ad.pspsegundapractica.model.room.entity.AmigoPOJO;

import java.util.List;

public class AmigoViewModel extends AndroidViewModel {

    private AmigoRepository repository;
    private LiveData<List<AmigoPOJO>> liveAmigo;

    public AmigoViewModel(@NonNull Application application) {
        super(application);
        repository = new AmigoRepository(application);
        liveAmigo = repository.getAmigos();
    }

    public LiveData<List<AmigoPOJO>> getAllAmigo(){
        return liveAmigo;
    }

    public void insert(AmigoPOJO amigoPOJO){
        repository.addAmigo(amigoPOJO);
    }

    public void delete(AmigoPOJO amigoPOJO){
        repository.deleteAmigo(amigoPOJO);
    }

    public void update(AmigoPOJO amigoPOJO){
        repository.updateAmigo(amigoPOJO);
    }

    public void get(long id){
        repository.get(id);
    }
}