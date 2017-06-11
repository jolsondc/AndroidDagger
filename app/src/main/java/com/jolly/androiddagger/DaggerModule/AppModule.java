package com.jolly.androiddagger.DaggerModule;



import com.jolly.androiddagger.MyApplication;
import com.jolly.androiddagger.Network.Http;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
public class AppModule {

MyApplication myApplication;
    public AppModule(MyApplication myApplication){
        this.myApplication=myApplication;
    }
    @Provides
    @Singleton
    MyApplication providesApplication() {
        return this.myApplication;
    }

    @Provides
    @Singleton
    Http retroInterface(Retrofit retrofit){
        return retrofit.create(Http.class);
    }


}
