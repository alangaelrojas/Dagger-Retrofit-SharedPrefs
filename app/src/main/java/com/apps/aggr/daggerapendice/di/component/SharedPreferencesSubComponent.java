package com.apps.aggr.daggerapendice.di.component;

import com.apps.aggr.daggerapendice.di.module.SharedPreferencesModule;
import com.apps.aggr.daggerapendice.di.scope.SharedPreferencesScope;
import com.apps.aggr.daggerapendice.ui.FourthActivity;
import com.apps.aggr.daggerapendice.ui.ThirdActivity;

import dagger.Subcomponent;

@SharedPreferencesScope
@Subcomponent(modules = SharedPreferencesModule.class)
public interface SharedPreferencesSubComponent {
    void inject(ThirdActivity thirdActivity);
    void inject(FourthActivity fourthActivity);
}
