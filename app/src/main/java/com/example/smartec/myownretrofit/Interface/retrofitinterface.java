package com.example.smartec.myownretrofit.Interface;

import com.example.smartec.myownretrofit.Model.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Smartec on 2/26/2018.
 */

public interface retrofitinterface {
   String BASE_URL="https://simplifiedcoding.net/demos/";


    @GET("marvel")
    Call<List<model>> getData();




}
