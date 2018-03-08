package com.example.smartec.myownretrofit;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Smartec on 2/27/2018.
 */
@Module
public class AppModule {

    private Application myapplication;

    public AppModule(Application myapplication) {
        this.myapplication = myapplication;
    }
   @Provides
   @Singleton
    Application AppProvider(){
        return myapplication;
    }
}
