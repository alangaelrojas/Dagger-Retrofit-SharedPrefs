package com.apps.aggr.daggerapendice.model;

public class Mensaje {
    private String mensajeTitle;
    private String mensajeDescription;

    public Mensaje(String mensajeTitle, String mensajeDescription) {
        this.mensajeTitle = mensajeTitle;
        this.mensajeDescription = mensajeDescription;
    }

    public String getMensajeTitle() {
        return mensajeTitle;
    }

    public void setMensajeTitle(String mensajeTitle) {
        this.mensajeTitle = mensajeTitle;
    }

    public String getMensajeDescription() {
        return mensajeDescription;
    }

    public void setMensajeDescription(String mensajeDescription) {
        this.mensajeDescription = mensajeDescription;
    }
}
