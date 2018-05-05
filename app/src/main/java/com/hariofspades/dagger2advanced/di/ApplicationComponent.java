package com.hariofspades.dagger2advanced.di;

import android.app.Application;

import com.hariofspades.dagger2advanced.api.RandomUsersApi;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {ApplicationModule.class, PicassoModule.class})
@Singleton
public interface ApplicationComponent {

  Picasso picasso();

  RandomUsersApi randomUserApi();

  @Component.Builder
  interface Builder {

    @BindsInstance
    Builder application(Application application);

    ApplicationComponent build();
  }
}
