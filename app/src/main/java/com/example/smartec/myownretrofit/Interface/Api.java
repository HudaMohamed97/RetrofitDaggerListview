package com.example.smartec.myownretrofit.Interface;

import com.example.smartec.myownretrofit.AppModule;
import com.example.smartec.myownretrofit.MainActivity;
import com.example.smartec.myownretrofit.RetroiftModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Smartec on 2/27/2018.
 */
@Singleton
@Component(modules = {AppModule.class , RetroiftModule.class})
public interface Api {
    void inject(MainActivity myactivity);

}
