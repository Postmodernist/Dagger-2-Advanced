package com.hariofspades.dagger2advanced.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hariofspades.dagger2advanced.R;
import com.hariofspades.dagger2advanced.RandomUsersApplication;
import com.hariofspades.dagger2advanced.adapter.RandomUserAdapter;
import com.hariofspades.dagger2advanced.api.RandomUsersApi;
import com.hariofspades.dagger2advanced.di.DaggerMainActivityComponent;
import com.hariofspades.dagger2advanced.model.RandomUsers;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.recyclerView)
  RecyclerView recyclerView;

  @Inject
  RandomUserAdapter randomUserAdapter;

  @Inject
  RandomUsersApi randomUsersApi;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    configureDagger();
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    // Setup RecyclerView
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(randomUserAdapter);

    populateUsers();
  }

  private void configureDagger() {
    DaggerMainActivityComponent.builder()
        .activity(this)
        .applicationComponent(((RandomUsersApplication) getApplication()).getApplicationComponent())
        .build()
        .inject(this);
  }

  private void populateUsers() {
    Call<RandomUsers> randomUsersCall = randomUsersApi.getRandomUsers(10);
    randomUsersCall.enqueue(new Callback<RandomUsers>() {

      @Override
      public void onResponse(@NonNull Call<RandomUsers> call, @NonNull Response<RandomUsers> response) {
        if (response.isSuccessful()) {
          RandomUsers users = response.body();
          if (users != null) {
            randomUserAdapter.setItems(users.getResults());
          }
        }
      }

      @Override
      public void onFailure(@NonNull Call<RandomUsers> call, @NonNull Throwable t) {
        Timber.i(t.getMessage());
      }
    });
  }
}
