package com.example.pokee.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import com.example.pokee.Model.Model;
import com.example.pokee.Model.PokieeDataModel;
import com.example.pokee.R;
import com.example.pokee.ViewModel.ViewModel;
import com.example.pokee.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding ;
    private ViewModel viewModel ;
    private CustomAdaptor customAdaptor = null;
    private LinearLayoutManager linearLayoutManager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setContentView(this.activityMainBinding.getRoot());
        this.viewModel = new ViewModelProvider(this).get(ViewModel.class);
        this.viewModel.setModel(new Model(this));
        this.viewModel.getData();
        this.viewModel.liveData.observe(this, new Observer<PokieeDataModel>() {
            @Override
            public void onChanged(PokieeDataModel pokieeDataModel) {
                customAdaptor = new CustomAdaptor(MainActivity.this,pokieeDataModel);
                Init_Recycel();
            }
        });

    }

    public void Init_Recycel()
    {

        activityMainBinding.PokeeRecycle.setAdapter(customAdaptor);
        this.linearLayoutManager = new LinearLayoutManager(this);
        this.activityMainBinding.PokeeRecycle.setLayoutManager(this.linearLayoutManager);
        customAdaptor.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("RecycleState",this.linearLayoutManager.onSaveInstanceState());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        this.linearLayoutManager.onRestoreInstanceState(savedInstanceState.getParcelable("RecycleState"));
    }
}