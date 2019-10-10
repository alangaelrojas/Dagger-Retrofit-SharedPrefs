package com.apps.aggr.daggerapendice.di.module;

import com.apps.aggr.daggerapendice.adapters.TiempoAdapter;
import com.apps.aggr.daggerapendice.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class AdapterModule {

    @ApplicationScope
    @Provides
    public TiempoAdapter getTiempoAdapter(){
        return new TiempoAdapter();
    }
}
