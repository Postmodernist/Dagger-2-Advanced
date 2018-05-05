package com.hariofspades.dagger2advanced.di;

import android.app.Application;
import android.content.Context;

import com.hariofspades.dagger2advanced.R;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
class ContextModule {

  @Provides
  @AplicationContext
  Context context(Application application) {
    return application.getApplicationContext();
  }

  @Provides
  @Named("base url")
  String baseUrl(@AplicationContext Context context) {
    return context.getString(R.string.base_url);
  }

  @Provides
  @Named("cache size")
  int cacheSize(@AplicationContext Context context) {
    return context.getResources().getInteger(R.integer.cache_size);
  }
}
