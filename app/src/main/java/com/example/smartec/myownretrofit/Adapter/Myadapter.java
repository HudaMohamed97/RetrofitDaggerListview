package com.example.smartec.myownretrofit.Adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartec.myownretrofit.Model.model;
import com.example.smartec.myownretrofit.R;
import com.example.smartec.myownretrofit.databinding.MrrowBinding;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Smartec on 3/7/2018.
 */
public class Myadapter extends ArrayAdapter<model> {
    List<model> myarray;
    Context context;
    public Myadapter(@NonNull Context context, List<model> myarray) {
        super(context,0,myarray);
        this.context=context;
        this.myarray=myarray;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        model user = getItem(position);
       /* // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mrrow, parent, false);
        }*/
        LayoutInflater myinflat=LayoutInflater.from(parent.getContext());
        MrrowBinding myrow= DataBindingUtil.inflate(myinflat,R.layout.mrrow,parent,false);
        myrow.setBindMe(myarray.get(position));
        return myrow.getRoot();
        // Lookup view for data population
        /*TextView tvName = (TextView) convertView.findViewById(R.id.textView);
        TextView tvHome = (TextView) convertView.findViewById(R.id.textView1);
        ImageView myview=(ImageView) convertView.findViewById(R.id.myimage);
        TextView mytry = (TextView) convertView.findViewById(R.id.textView2);

        Bitmap image=getBitmapFromURL(user.getBio());
        // Populate the data into the template view using the data object
        tvName.setText(user.getName());
        tvHome.setText(user.getTeam());
        myview.setImageBitmap(image);
        mytry.setText("hi"+image);*/


        // Return the completed view to render on screen
        //return convertView;
    }
    public Bitmap getBitmapFromURL(String src) {
        try {
            java.net.URL url = new java.net.URL(src);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Toast.makeText(context, "from here", Toast.LENGTH_SHORT).show();
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
