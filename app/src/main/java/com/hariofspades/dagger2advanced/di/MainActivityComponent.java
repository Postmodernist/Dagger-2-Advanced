package com.hariofspades.dagger2advanced.di;

import com.hariofspades.dagger2advanced.activities.MainActivity;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = MainActivityModule.class, dependencies = ApplicationComponent.class)
@MainActivityScope
public interface MainActivityComponent {

  void inject(MainActivity activity);

  @Component.Builder
  interface Builder {

    @BindsInstance
    Builder activity(MainActivity activity);

    Builder applicationComponent(ApplicationComponent component);

    MainActivityComponent build();
  }
}
