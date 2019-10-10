package com.apps.aggr.daggerapendice.di.module;

import com.apps.aggr.daggerapendice.di.scope.MensajeScope;
import com.apps.aggr.daggerapendice.model.Mensaje;

import dagger.Module;
import dagger.Provides;

@Module
public class MensajeModule {

    @MensajeScope
    @Provides
    public Mensaje getMensaje(){
        return new Mensaje("Aplicación Tiempo", "La aplicación número uno para saber el tiempo en tu ciudad");
    }

}
