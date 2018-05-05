package com.hariofspades.dagger2advanced.di;

import com.hariofspades.dagger2advanced.activities.MainActivity;
import com.hariofspades.dagger2advanced.adapter.RandomUserAdapter;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
class MainActivityModule {

  @Provides
  @MainActivityScope
  RandomUserAdapter randomUserAdapter(MainActivity activity, Picasso picasso) {
    return new RandomUserAdapter(activity, picasso);
  }
}
