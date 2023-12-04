package com.example.valotracker1;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("endpoint/{id}")
    Call<PlayerData> getPlayerData(@Path("id") String playerId);
}
