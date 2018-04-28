package com.hariofspades.dagger2advanced.di;

import android.content.Context;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module(includes = OkHttpClientModule.class)
class PicassoModule {

  @Provides
  @Singleton
  static Picasso picasso(@AplicationContext Context context, OkHttp3Downloader okHttp3Downloader) {
    return new Picasso.Builder(context)
        .downloader(okHttp3Downloader)
        .build();
  }

  @Provides
  static OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient) {
    return new OkHttp3Downloader(okHttpClient);
  }
}
