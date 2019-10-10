package com.apps.aggr.daggerapendice;

import android.app.Application;

import com.apps.aggr.daggerapendice.di.component.ApplicationComponent;
import com.apps.aggr.daggerapendice.di.component.DaggerApplicationComponent;
import com.apps.aggr.daggerapendice.di.component.DaggerMensajeComponent;
import com.apps.aggr.daggerapendice.di.component.MensajeComponent;
import com.apps.aggr.daggerapendice.di.component.SharedPreferencesSubComponent;
import com.apps.aggr.daggerapendice.di.module.ApplicationContextModule;
import com.apps.aggr.daggerapendice.di.module.MensajeModule;
import com.apps.aggr.daggerapendice.di.module.SharedPreferencesModule;

public class BaseApplication extends Application {

    private MensajeComponent mensajeComponent;
    private ApplicationComponent applicationComponent;
    private SharedPreferencesSubComponent sharedPreferencesSubComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setUpApplicationComponent();
    }

    private void setUpApplicationComponent() {

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationContextModule(new ApplicationContextModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }

    public MensajeComponent getMensajeComponent(){
        if(mensajeComponent == null){
            setUpMensajeComponent();
        }
        return mensajeComponent;
    }

    public void clearMensajeComponent(){
        mensajeComponent = null;
    }

    private void setUpMensajeComponent() {
        mensajeComponent = DaggerMensajeComponent
                .builder()
                .mensajeModule(new MensajeModule())
                .build();
    }

    public SharedPreferencesSubComponent plusSharedPreferencesSubComponent(){
        if(sharedPreferencesSubComponent == null){
            sharedPreferencesSubComponent = applicationComponent
                    .plusSharedPreferencesSubComponent(new SharedPreferencesModule());
        }
        return sharedPreferencesSubComponent;
    }

}
