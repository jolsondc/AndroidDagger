package com.jolly.androiddagger.DaggerModule;


import com.jolly.androiddagger.MainActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules={AppModule.class, NwModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
