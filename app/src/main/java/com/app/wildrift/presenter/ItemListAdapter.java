package com.app.wildrift.presenter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.app.wildrift.R;
import com.app.wildrift.model.Ability;
import com.app.wildrift.model.ItemsList;
import com.app.wildrift.view.MyAdverCallbacker;
import com.google.android.gms.ads.mediation.Adapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {

    ArrayList<ItemListSctuct> arrayList = new ArrayList<ItemListSctuct>();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_on_list_fragment,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        holder.bind(arrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public void setItems(Collection<ItemListSctuct> list){
        arrayList.addAll(list);
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {


        ImageView icon;
        TextView name;
        ItemListSctuct listSctuct;

        public ItemViewHolder(@NonNull View itemView) {

            super(itemView);
            icon = itemView.findViewById(R.id.item_image_in_list);
            name = itemView.findViewById(R.id.item_name_in_list);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    MyAdverCallbacker.showAdverCounter();

                    icon.animate()
                            .alpha(0f).rotation(1200f)
                            .setDuration(300);

                    name.animate().alpha(0f).translationXBy(-1200f).setDuration(300);

                    listSctuct.getId();
                    Bundle bundle = new Bundle();
                    bundle.putInt("itemId", listSctuct.getId());
                    //   bundle.putString("localization", runeListStruct.get());


                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Navigation.findNavController(view).navigate(R.id.itemFragment,bundle);

                        }
                    },300);
                }
            });
        }


        public void bind(ItemListSctuct sctruct){

            Picasso.get().load(sctruct.getIcon()).into(icon);
            name.setText(sctruct.getName());
            listSctuct = sctruct;

        }
    }

}
