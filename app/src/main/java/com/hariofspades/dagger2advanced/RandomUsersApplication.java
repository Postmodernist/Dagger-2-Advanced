package com.hariofspades.dagger2advanced;

import android.app.Activity;
import android.app.Application;

import com.hariofspades.dagger2advanced.di.ApplicationComponent;
import com.hariofspades.dagger2advanced.di.ContextModule;
import com.hariofspades.dagger2advanced.di.DaggerApplicationComponent;

import timber.log.Timber;

public class RandomUsersApplication extends Application {

  private ApplicationComponent applicationComponent;

  public static ApplicationComponent getApplicationComponent(Activity activity) {
    final RandomUsersApplication application = (RandomUsersApplication) activity.getApplication();
    return application.applicationComponent;
  }

  @Override
  public void onCreate() {
    super.onCreate();

    Timber.plant(new Timber.DebugTree());

    applicationComponent = DaggerApplicationComponent.builder()
        .contextModule(new ContextModule(this))
        .build();
  }
}
