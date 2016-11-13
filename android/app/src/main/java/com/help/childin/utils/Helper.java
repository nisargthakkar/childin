package com.help.childin.utils;

import android.content.Context;
import android.graphics.Typeface;

import java.io.IOException;
import java.io.InputStream;

import retrofit2.Retrofit;

/**
 * Created by ramakrishna on 11/5/16.
 */

public class Helper {

    private Context context;

    public Helper(Context context){
        this.context = context;
    }

    public String loadJsonFromAssets(String fileName) throws IOException {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    public static Typeface getMyTypeFace(Context context){
        //return Typeface.createFromAsset(context.getAssets(),
        //        "Raleway-Regular.ttf");
        return Typeface.createFromAsset(context.getAssets(),
                "SourceSansPro-Regular.ttf");
    }

    public static Typeface getMyBoldTypeFace(Context context){
        //return Typeface.createFromAsset(context.getAssets(),
        //        "Raleway-Bold.ttf");
        return Typeface.createFromAsset(context.getAssets(),
                "SourceSansPro-Semibold.ttf");
    }

    public static Retrofit getRetrofitObj() {

        /*OkHttpClient okHttpClient = new OkHttpClient();
        //okHttpClient.connectTimeoutMillis(30, TimeUnit.SECONDS);
        //okHttpClient.setReadTimeout(60, TimeUnit.SECONDS);

        return new Retrofit.Builder()
                .baseUrl(AppConstants.ROOT_URL)
                //.addConverterFactory(GsonConverterFactory.create())
                //.client(okHttpClient)
                .build();*/
        return new Retrofit.Builder()
                .baseUrl(AppConstants.ROOT_URL)
                .build();
    }

}
