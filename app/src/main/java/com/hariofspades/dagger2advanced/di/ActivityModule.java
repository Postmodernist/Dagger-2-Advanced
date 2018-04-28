package com.hariofspades.dagger2advanced.di;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

  private final Context context;

  public ActivityModule(Context context) {
    this.context = context;
  }

  @Provides
  @Singleton
  @Named("activity context")
  Context context() {
    return context;
  }
}
