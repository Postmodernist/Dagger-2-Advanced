package com.hariofspades.dagger2advanced.interfaces;

import com.hariofspades.dagger2advanced.model.RandomUsers;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomUsersApi {
  @GET("api")
  Call<RandomUsers> getRandomUsers(@Query("results") int size);
}
