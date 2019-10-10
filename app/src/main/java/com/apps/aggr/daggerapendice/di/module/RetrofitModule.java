package com.apps.aggr.daggerapendice.di.module;

import com.apps.aggr.daggerapendice.api.ApiClient;
import com.apps.aggr.daggerapendice.di.scope.ApplicationScope;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {
    private static final String BASE_URL = "https://samples.openweathermap.org/";

    @ApplicationScope
    @Provides
    GsonConverterFactory provideGsonConverterFactory(){
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
        return gsonConverterFactory;
    }

    @ApplicationScope
    @Provides
    HttpLoggingInterceptor provideHttplogginInterceptor (){
        HttpLoggingInterceptor loggingInterceptor= new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;

    }

    @ApplicationScope
    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    @ApplicationScope
    @Provides
    Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory converterFactory){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();
    }

    @ApplicationScope
    @Provides
    ApiClient provideApiClient(Retrofit retrofit){
        return retrofit.create(ApiClient.class);
    }

}
