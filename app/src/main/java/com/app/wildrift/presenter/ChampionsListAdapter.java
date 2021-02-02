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
import com.squareup.picasso.Picasso;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

import static bolts.Task.delay;


public class ChampionsListAdapter extends RecyclerView.Adapter<ChampionsListAdapter.ChampionsListViewHolder>implements View.OnClickListener {

        ArrayList<ChampionsListSctruct> championsListSctructs = new ArrayList<>();

    @Override
    public ChampionsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.champion_on_list_fragment ,parent,false);
        return new ChampionsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChampionsListViewHolder holder, int position) {
       holder.bind(championsListSctructs.get(position));
    }


    @Override
    public int getItemCount() {
        return championsListSctructs.size();
    }

    public void setItems(Collection<ChampionsListSctruct> list){
        championsListSctructs.addAll(list);
    }

    public void clearItems(){
        championsListSctructs.clear();
        notifyDataSetChanged();

    }

    @Override
    public void onClick(View view) {


    }

    public class ChampionsListViewHolder extends RecyclerView.ViewHolder{

        ImageView iconChampion;
        TextView nameChampion;
        private ChampionsListSctruct championGuideStruct;

        public ChampionsListViewHolder(@NonNull View itemView) {
            super(itemView);
            iconChampion =itemView.findViewById(R.id.champion_image_in_list);
            nameChampion = itemView.findViewById(R.id.champion_name_in_list);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    iconChampion.animate()
                            .alpha(0f).rotation(1200f)
                            .setDuration(300);

                    nameChampion.animate().alpha(0f).translationXBy(-1200f).setDuration(300);


                    Bundle bundle = new Bundle();
                    bundle.putInt("championId", championGuideStruct.getId());
                    bundle.putString("localization", championGuideStruct.getLocalization());


                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Navigation.findNavController(view).navigate(R.id.championFragment,bundle);

                        }
                    },300);


                }
            });
        }

        public void bind(ChampionsListSctruct championsListSctruct) {
            Picasso.get().load(championsListSctruct.getImageURL()).into(iconChampion);
            nameChampion.setText(championsListSctruct.getName());
            this.championGuideStruct = championsListSctruct;
        }
    }
}
