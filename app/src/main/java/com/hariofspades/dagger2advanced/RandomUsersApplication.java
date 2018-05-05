package com.hariofspades.dagger2advanced;

import android.app.Application;

import com.hariofspades.dagger2advanced.di.ApplicationComponent;
import com.hariofspades.dagger2advanced.di.DaggerApplicationComponent;

import timber.log.Timber;

public class RandomUsersApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    Timber.plant(new Timber.DebugTree());

    applicationComponent = DaggerApplicationComponent.builder().application(this).build();
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }
}
