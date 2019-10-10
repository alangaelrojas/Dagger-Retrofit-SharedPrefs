package com.apps.aggr.daggerapendice.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.apps.aggr.daggerapendice.di.scope.SharedPreferencesScope;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPreferencesModule {

    public static final String SHARED_PREF = "shared_pref";

    @SharedPreferencesScope
    @Provides
    SharedPreferences provideSharedPrefs(Context context){
        return context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
    }


}
