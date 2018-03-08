package com.example.smartec.myownretrofit;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.smartec.myownretrofit.Adapter.Myadapter;
import com.example.smartec.myownretrofit.Interface.retrofitinterface;
import com.example.smartec.myownretrofit.Model.model;
import com.example.smartec.myownretrofit.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;
    ListView mylist;
    ActivityMainBinding Mybinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        Mybinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        mylist=(ListView)findViewById(R.id.mylist);
// Create the adapter to convert the array to views

// Attach the adapter to a ListView

      /*/  Retrofit object = new Retrofit.Builder()
                .baseUrl(retrofitinterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        retrofitinterface Api=object.create(retrofitinterface.class);
        Call<List<model>> myresult=Api.getData();
        myresult.enqueue(new Callback<List<model>>() {

            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                Toast.makeText(MainActivity.this, "successsss", Toast.LENGTH_SHORT).show();
                List<model> heroList = response.body();
                String[] heroes = new String[heroList.size()];
                Log.e("reeee","before loop");
                for (int i = 0; i < heroList.size(); i++) {
                    heroes[i] = heroList.get(i).getName();
                    Log.e("reeee","from response");
                    Toast.makeText(MainActivity.this, "successsss"+heroes[i], Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failuer", Toast.LENGTH_SHORT).show();
            }
        });
/*/

        ((MyApplication) getApplication()).getNetComponent().inject(this);
        getHeroes();


    }

    private void getHeroes() {
        Toast.makeText(MainActivity.this, "doneeeeee", Toast.LENGTH_SHORT).show();
        retrofitinterface myApi=retrofit.create(retrofitinterface.class);
        Call<List<model>> myresult=myApi.getData();
        myresult.enqueue(new Callback<List<model>>() {

            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                Toast.makeText(MainActivity.this, "successsss", Toast.LENGTH_SHORT).show();
                List<model> heroList = response.body();
                Toast.makeText(MainActivity.this, "check listtttt"+ heroList.get(0), Toast.LENGTH_SHORT).show();
                Myadapter adapter = new Myadapter(getApplicationContext(),heroList);
                Mybinding.mylist.setAdapter(adapter);
               // mylist.setAdapter(adapter);
                /*String[] heroes = new String[heroList.size()];
                ArrayList<model>hero=new ArrayList<>();
                Log.e("reeee","before loop");
                for (int i = 0; i < heroList.size(); i++) {
                    heroes[i] = heroList.get(i).getName();
                    //mylist.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,heroes));
                 //   Log.e("reeee","from response");
                    Toast.makeText(MainActivity.this, "successsss"+heroes[i], Toast.LENGTH_SHORT).show();

                }*/
            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failuer", Toast.LENGTH_SHORT).show();
            }
        });

    }
}