package com.hariofspades.dagger2advanced.di;

import com.hariofspades.dagger2advanced.api.RandomUsersApi;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {RandomUsersModule.class, PicassoModule.class})
@Singleton
public interface RandomUsersComponent {

  RandomUsersApi randomUsersApi();

  Picasso picasso();
}
