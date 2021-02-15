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
import com.app.wildrift.view.MainActivity;
import com.app.wildrift.view.MyAdverCallbacker;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

public class RuneListAdapter extends RecyclerView.Adapter<RuneListAdapter.RuneListViewHolder> {


    ArrayList<RuneListStruct> runeListStructs = new ArrayList<>();

    @NonNull
    @Override
    public RuneListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rune_on_list_fragment ,parent,false);
        return new RuneListAdapter.RuneListViewHolder(view);
    //    return new ChampionsListAdapter.ChampionsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RuneListViewHolder holder, int position) {
        holder.bind(runeListStructs.get(position));
    }

    @Override
    public int getItemCount() {
        return runeListStructs.size();
    }

    public void setItems(Collection<RuneListStruct> list){
        runeListStructs.addAll(list);
    }

    public class RuneListViewHolder extends RecyclerView.ViewHolder {


        ImageView imageView;
        TextView name;
        RuneListStruct runeListStruct;

        public RuneListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.rune_image_in_list);
            name = itemView.findViewById(R.id.rune_name_in_list);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    MyAdverCallbacker.showAdverCounter();

                    imageView.animate()
                            .alpha(0f).rotation(1200f)
                            .setDuration(300);

                    name.animate().alpha(0f).translationXBy(-1200f).setDuration(300);


                   Bundle bundle = new Bundle();
                   bundle.putInt("runeId", runeListStruct.getId());
                //   bundle.putString("localization", runeListStruct.get());


                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Navigation.findNavController(view).navigate(R.id.runeFragment,bundle);

                        }
                    },300);
                }
            });


        }

        public void bind(RuneListStruct struct){
            Picasso.get().load(struct.getRuneURL()).into(imageView);
            name.setText(struct.getRuneName());
            runeListStruct = struct;
        }
    }
}
