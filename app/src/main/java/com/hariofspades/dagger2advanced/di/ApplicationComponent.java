package com.hariofspades.dagger2advanced.di;

import com.hariofspades.dagger2advanced.api.RandomUsersApi;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {ApplicationModule.class, PicassoModule.class})
@Singleton
public interface ApplicationComponent {

  RandomUsersApi randomUsersApi();

  Picasso picasso();
}
