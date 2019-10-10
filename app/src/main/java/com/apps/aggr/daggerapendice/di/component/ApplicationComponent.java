package com.apps.aggr.daggerapendice.di.component;

import com.apps.aggr.daggerapendice.di.module.AdapterModule;
import com.apps.aggr.daggerapendice.di.module.ApplicationContextModule;
import com.apps.aggr.daggerapendice.di.module.RetrofitModule;
import com.apps.aggr.daggerapendice.di.module.SharedPreferencesModule;
import com.apps.aggr.daggerapendice.di.scope.ApplicationScope;
import com.apps.aggr.daggerapendice.ui.SecondActivity;

import dagger.Component;

@ApplicationScope
@Component(modules = {ApplicationContextModule.class, RetrofitModule.class, AdapterModule.class})
public interface ApplicationComponent {

    void inject(SecondActivity secondActivity);

    SharedPreferencesSubComponent plusSharedPreferencesSubComponent(SharedPreferencesModule sharedPreferencesModule);

}
