package com.app.wildrift.presenter;

import com.app.wildrift.model.Ability;
import com.app.wildrift.model.ChampionRecommendedItemsById;
import com.app.wildrift.model.ChampionRecommendedRunesById;

import java.util.ArrayList;

public class ChampionGuideStruct {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChampionIcon() {
        return championIcon;
    }

    public void setChampionIcon(String championIcon) {
        this.championIcon = championIcon;
    }

    public String getChampionShortDescription() {
        return championShortDescription;
    }

    public void setChampionShortDescription(String championShortDescription) {
        this.championShortDescription = championShortDescription;
    }

    public String getChampionType() {
        return championType;
    }

    public void setChampionType(String championType) {
        this.championType = championType;
    }

    public ArrayList<ChampionRecommendedRunesById> getChampionRecommendedRunesById() {
        return championRecommendedRunesById;
    }

    public void setChampionRecommendedRunesById(ArrayList<ChampionRecommendedRunesById> championRecommendedRunesById) {
        this.championRecommendedRunesById = championRecommendedRunesById;
    }

    public ArrayList<ChampionRecommendedItemsById> getChampionRecommendedItemsById() {
        return championRecommendedItemsById;
    }

    public void setChampionRecommendedItemsById(ArrayList<ChampionRecommendedItemsById> championRecommendedItemsById) {
        this.championRecommendedItemsById = championRecommendedItemsById;
    }

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<Ability> abilities) {
        this.abilities = abilities;
    }

    String name;
    String championIcon;
    String championShortDescription;
    String championType;
    ArrayList<ChampionRecommendedRunesById> championRecommendedRunesById;
    ArrayList<ChampionRecommendedItemsById> championRecommendedItemsById;
    ArrayList<Ability> abilities;

    public ChampionGuideStruct(String name, String championIcon, String championShortDescription, String championType, ArrayList<ChampionRecommendedRunesById> championRecommendedRunesById, ArrayList<ChampionRecommendedItemsById> championRecommendedItemsById, ArrayList<Ability> abilities) {
        this.name = name;
        this.championIcon = championIcon;
        this.championShortDescription = championShortDescription;
        this.championType = championType;
        this.championRecommendedRunesById = championRecommendedRunesById;
        this.championRecommendedItemsById = championRecommendedItemsById;
        this.abilities = abilities;
    }
}
