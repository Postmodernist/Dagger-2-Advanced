package com.hariofspades.dagger2advanced.di;

import android.content.Context;

import com.hariofspades.dagger2advanced.R;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

  private final Context context;

  public ContextModule(Context context) {
    this.context = context;
  }

  @Provides
  @AplicationContext
  Context context() {
    return context.getApplicationContext();
  }

  @Provides
  @Named("base url")
  String baseUrl() {
    return context.getString(R.string.base_url);
  }

  @Provides
  @Named("cache size")
  int cacheSize() {
    return context.getResources().getInteger(R.integer.cache_size);
  }
}
