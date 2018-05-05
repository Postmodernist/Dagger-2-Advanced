package com.hariofspades.dagger2advanced.di;

import com.hariofspades.dagger2advanced.api.RandomUsersApi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = OkHttpClientModule.class)
class ApplicationModule {

  @Provides
  @Singleton
  static RandomUsersApi randomUsersApi(Retrofit retrofit) {
    return retrofit.create(RandomUsersApi.class);
  }

  @Provides
  @Singleton
  static Retrofit retrofit(OkHttpClient okHttpClient, @Named("base url") String baseUrl) {
    return new Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
  }
}
