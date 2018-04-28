package com.hariofspades.dagger2advanced.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hariofspades.dagger2advanced.api.RandomUsersApi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = OkHttpClientModule.class)
class RandomUsersModule {

  @Provides
  @Singleton
  static RandomUsersApi randomUsersApi(Retrofit retrofit) {
    return retrofit.create(RandomUsersApi.class);
  }

  @Provides
  @Singleton
  static Retrofit retrofit(OkHttpClient okHttpClient, @Named("base url") String baseUrl, Gson gson) {
    return new Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
  }

  @Provides
  static Gson gson() {
    GsonBuilder gsonBuilder = new GsonBuilder();
    return gsonBuilder.create();
  }
}
