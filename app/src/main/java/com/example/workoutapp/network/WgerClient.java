package com.example.workoutapp.network;

import static com.example.workoutapp.constants.Constants.WGER_API_KEY;
import static com.example.workoutapp.constants.Constants.WGER_BASE_URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WgerClient {

    private static Retrofit retrofit = null;

    public static WgerApi getClient() {

        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(chain -> {
                        Request newRequest = chain.request().newBuilder()
                                .addHeader("Authorization", WGER_API_KEY)
                                .build();
                        return chain.proceed(newRequest);
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(WGER_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(WgerApi.class);
    }
}
