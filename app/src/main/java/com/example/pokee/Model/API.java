package com.example.pokee.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("ditto")
    public Call<PokeeModel> getPokee();
}
