package com.example.pokee.Model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.pokee.APIModels.GameIndex;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model {
    private Context context ;

    public Model(Context context) {
        this.context = context;
    }

    public MutableLiveData<PokieeDataModel> getPokeeFromAPI(){
       final MutableLiveData<PokieeDataModel> liveData = new MutableLiveData<>();
       Retrofit retrofit = new Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/pokemon/").addConverterFactory(GsonConverterFactory.create()).build();
       API api = retrofit.create(API.class);
       api.getPokee().enqueue(new Callback<PokeeModel>() {
           @Override
           public void onResponse(Call<PokeeModel> call, Response<PokeeModel> response) {
               // PIC : response.body().getSprites().getBackDefault().toString()
               // NAME : response.body().getName()

               liveData.setValue(new PokieeDataModel((ArrayList<GameIndex>) response.body().getGameIndices(),response.body().getSprites().getBackDefault().toString()));
           }

           @Override
           public void onFailure(Call<PokeeModel> call, Throwable t) {
               Log.e("Field",t.getMessage().toString());
               Toast.makeText(context,t.getMessage().toString(),Toast.LENGTH_LONG).show();
           }
       });
    return liveData;
   }
}
