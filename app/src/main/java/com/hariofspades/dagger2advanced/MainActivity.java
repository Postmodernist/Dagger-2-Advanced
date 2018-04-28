package com.hariofspades.dagger2advanced;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hariofspades.dagger2advanced.adapter.RandomUserAdapter;
import com.hariofspades.dagger2advanced.interfaces.RandomUsersApi;
import com.hariofspades.dagger2advanced.model.RandomUsers;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;

import butterknife.BindInt;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

  @BindString(R.string.base_url)
  String baseUrl;

  @BindInt(R.integer.cache_size)
  int cacheSize;

  @BindView(R.id.recyclerView)
  RecyclerView recyclerView;

  private Retrofit retrofit;
  private RandomUserAdapter randomUserAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    Timber.plant(new Timber.DebugTree());

    File cacheFile = new File(getCacheDir(), "HttpCache");
    Cache cache = new Cache(cacheFile, cacheSize);
    //noinspection ResultOfMethodCallIgnored
    cacheFile.mkdirs();

    HttpLoggingInterceptor httpLoggingInterceptor = new
        HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
      @Override
      public void log(@NonNull String message) {
        Timber.i(message);
      }
    });
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

    OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
        .cache(cache)
        .addInterceptor(httpLoggingInterceptor)
        .build();

    OkHttp3Downloader okHttp3Downloader = new OkHttp3Downloader(okHttpClient);
    Picasso picasso = new Picasso.Builder(this).downloader(okHttp3Downloader).build();

    retrofit = new Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();

    // Setup RecyclerView
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    randomUserAdapter = new RandomUserAdapter(this, picasso);
    recyclerView.setAdapter(randomUserAdapter);
    populateUsers();
  }

  // ---

  private void populateUsers() {
    Call<RandomUsers> randomUsersCall = getRandomUserService().getRandomUsers(10);
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

  public RandomUsersApi getRandomUserService() {
    return retrofit.create(RandomUsersApi.class);
  }
}
