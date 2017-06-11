package com.jolly.androiddagger;

import android.app.Application;

import com.jolly.androiddagger.DaggerModule.AppComponent;
import com.jolly.androiddagger.DaggerModule.AppModule;
import com.jolly.androiddagger.DaggerModule.DaggerAppComponent;
import com.jolly.androiddagger.DaggerModule.NwModule;

/**
 * Created by Jollyboy on 10/06/17.
 */

public class MyApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .nwModule(new NwModule())
                .build();

    }


    public AppComponent getmAppComponent() {
        return mAppComponent;
    }



}
