package com.example.pokee.Model;

import com.example.pokee.APIModels.GameIndex;

import java.util.ArrayList;

public class PokieeDataModel {
    private ArrayList<GameIndex> list = new ArrayList<>();
    private String PIC ;

    public PokieeDataModel(ArrayList<GameIndex> list, String PIC) {
        this.list = list;
        this.PIC = PIC;
    }

    public ArrayList<GameIndex> getList() {
        return list;
    }

    public void setList(ArrayList<GameIndex> list) {
        this.list = list;
    }

    public String getPIC() {
        return PIC;
    }

    public void setPIC(String PIC) {
        this.PIC = PIC;
    }
}
