package com.apps.aggr.daggerapendice.di.module;

import android.app.Application;
import android.content.Context;

import com.apps.aggr.daggerapendice.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContextModule {

    private Application application;

    public ApplicationContextModule(Application application){
        this.application = application;
    }

    @ApplicationScope
    @Provides
    public Application provideApplication(){
        return application;
    }

    @ApplicationScope
    @Provides
    public Context provideContext(){
        return application.getApplicationContext();
    }
}
