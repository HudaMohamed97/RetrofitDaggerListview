package com.example.smartec.myownretrofit;

import android.app.Application;

import com.example.smartec.myownretrofit.Interface.*;

/**
 * Created by Smartec on 2/27/2018.
 */

public class MyApplication extends Application
{
private Api myretrofit;


    @Override
    public void onCreate() {
        super.onCreate();
        myretrofit= DaggerApi.builder()
                .appModule(new  AppModule(this))
                .retroiftModule(new RetroiftModule("https://simplifiedcoding.net/demos/"))
                .build();



    }
    public Api getNetComponent() {
        return myretrofit;
    }
}
