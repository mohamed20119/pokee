package com.example.pokee.ViewModel;

import androidx.lifecycle.MutableLiveData;

import com.example.pokee.Model.Model;
import com.example.pokee.Model.PokieeDataModel;

public class ViewModel extends androidx.lifecycle.ViewModel {


    public MutableLiveData<PokieeDataModel> liveData = new MutableLiveData<>();
    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    public void getData()
    {
       this.liveData =  this.model.getPokeeFromAPI();

    }

}
