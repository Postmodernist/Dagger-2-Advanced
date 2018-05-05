package com.hariofspades.dagger2advanced.di;

import android.content.Context;
import android.support.annotation.NonNull;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module(includes = ContextModule.class)
class OkHttpClientModule {

  @Provides
  @Singleton
  static OkHttpClient okHttpClient(Cache cache, HttpLoggingInterceptor httpLoggingInterceptor) {
    return new OkHttpClient().newBuilder()
        .cache(cache)
        .addInterceptor(httpLoggingInterceptor)
        .build();
  }

  @Provides
  @Singleton
  static Cache cache(File cacheFile, @Named("cache size") int cacheSize) {
    return new Cache(cacheFile, cacheSize);
  }

  @Provides
  @Singleton
  static File file(@AplicationContext Context context) {
    File cacheFile = new File(context.getCacheDir(), "HttpCache");
    //noinspection ResultOfMethodCallIgnored
    cacheFile.mkdirs();
    return cacheFile;
  }

  @Provides
  @Singleton
  static HttpLoggingInterceptor httpLoggingInterceptor() {
    HttpLoggingInterceptor httpLoggingInterceptor = new
        HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
      @Override
      public void log(@NonNull String message) {
        Timber.i(message);
      }
    });
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return httpLoggingInterceptor;
  }
}
