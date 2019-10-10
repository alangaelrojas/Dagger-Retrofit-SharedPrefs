package com.apps.aggr.daggerapendice.di.component;

import com.apps.aggr.daggerapendice.di.module.MensajeModule;
import com.apps.aggr.daggerapendice.di.scope.MensajeScope;
import com.apps.aggr.daggerapendice.ui.MainActivity;

import dagger.Component;

@MensajeScope
@Component(modules = MensajeModule.class)
public interface MensajeComponent {
    void inject(MainActivity mainActivity);
}
