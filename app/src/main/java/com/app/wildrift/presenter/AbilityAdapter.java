package com.app.wildrift.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.wildrift.R;
import com.app.wildrift.model.Ability;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;

public class AbilityAdapter extends RecyclerView.Adapter<AbilityAdapter.AbilityViewHolder> {


    ArrayList<Ability> abilities = new ArrayList<>();

    @NonNull
    @Override
    public AbilityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ability_layout ,parent,false);
        return new AbilityAdapter.AbilityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AbilityViewHolder holder, int position) {
    holder.bind(abilities.get(position));
    }

    @Override
    public int getItemCount() {
        return abilities.size();
    }

    public void setItems(Collection<Ability> list){
        abilities.addAll(list);
    }

    public class AbilityViewHolder extends RecyclerView.ViewHolder {


        //image_ability_icon
        //tv_ability_name
        //tv_ability_description
        private ImageView iconAbility;
        private TextView abilityName;
        private TextView abilityDescription;


        public AbilityViewHolder(@NonNull View itemView) {
            super(itemView);
            iconAbility = itemView.findViewById(R.id.image_ability_icon);
            abilityName = itemView.findViewById(R.id.tv_ability_name);
            abilityDescription = itemView.findViewById(R.id.tv_ability_description);

        }

        public void bind(Ability ab){
            if(!ab.getAbilityIcon().equals("")){
                Picasso.get().load(ab.getAbilityIcon()).into(iconAbility);
            }

            abilityName.setText(ab.getAbilityName());
            abilityDescription.setText(ab.getAbilityDescription());

        }
    }
}
