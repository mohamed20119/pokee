package com.example.pokee.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokee.APIModels.GameIndex;
import com.example.pokee.Model.PokieeDataModel;
import com.example.pokee.R;
import com.example.pokee.databinding.CustomRecycleBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdaptor extends RecyclerView.Adapter<CustomAdaptor.RecycleBind> {

    private PokieeDataModel dataModel ;
    private Context context;

    public CustomAdaptor( Context context,PokieeDataModel pokieeDataModel) {
        this.dataModel = pokieeDataModel;
        this.context = context;
    }

    @NonNull
    @Override
    public RecycleBind onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomRecycleBinding customRecycleBinding = DataBindingUtil.inflate(LayoutInflater.from(this.context), R.layout.custom_recycle,parent,false);
        return new RecycleBind(customRecycleBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleBind holder, int position) {
        /*holder.binding.PokeeName.setText(this.list.get(position).getVersion().getName());
        Picasso.get().load(this.PIC).into(holder.binding.PokeePic);**/
        holder.binding.PokeeName.setText(this.dataModel.getList().get(position).getVersion().getName());
        Picasso.get().load(this.dataModel.getPIC()).into(holder.binding.PokeePic);

    }

    @Override
    public int getItemCount() {
        return this.dataModel.getList().size();
    }

    public class RecycleBind extends RecyclerView.ViewHolder
    {
        CustomRecycleBinding binding ;
        public RecycleBind(@NonNull View itemView) {
            super(itemView);
            this.binding = DataBindingUtil.getBinding(itemView);

        }
    }
}
