package com.ad.pspsegundapractica.model.room.entity;

import androidx.room.Embedded;
import androidx.room.Ignore;


public class LlamadaAmigoPOJO {

    @Embedded
    private AmigoPOJO amigoPOJO;

    private long count;

    @Ignore
    public LlamadaAmigoPOJO() {
    }

    public LlamadaAmigoPOJO(AmigoPOJO amigoPOJO, long count) {
        this.amigoPOJO = amigoPOJO;
        this.count = count;
    }

    public AmigoPOJO getAmigoPOJO() {
        return amigoPOJO;
    }

    public void setAmigoDao(AmigoPOJO amigoPOJO) {
        this.amigoPOJO = amigoPOJO;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}