package com.ad.pspsegundapractica.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

import com.ad.pspsegundapractica.model.room.Repository;
import com.ad.pspsegundapractica.model.room.entity.LlamadaPOJO;

public class LlamadaReciever extends BroadcastReceiver {

    private LlamadaPOJO llamadaPOJO;
    private Repository repository;
    private String telefono;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.intent.action.PHONE_STATE")) {
            String phoneStatus = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            if(phoneStatus.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                telefono = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                repository = new Repository(context);
                repository.insertLlamada(telefono);
            }
        }
    }
}