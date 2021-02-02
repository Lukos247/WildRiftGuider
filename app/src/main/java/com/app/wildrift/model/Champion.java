package com.app.wildrift.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Champion {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("localization")
    @Expose
    private String localization;
    @SerializedName("championName")
    @Expose
    private String championName;
    @SerializedName("championIcon")
    @Expose
    private String championIcon;
    @SerializedName("championShortDescription")
    @Expose
    private String championShortDescription;
    @SerializedName("championType")
    @Expose
    private String championType;
    @SerializedName("championRecommendedRunesById")
    @Expose
    private List<ChampionRecommendedRunesById> championRecommendedRunesById = null;
    @SerializedName("championRecommendedItemsById")
    @Expose
    private List<ChampionRecommendedItemsById> championRecommendedItemsById = null;
    @SerializedName("abilities")
    @Expose
    private List<Ability> abilities = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getChampionName() {
        return championName;
    }

    public void setChampionName(String championName) {
        this.championName = championName;
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

    public List<ChampionRecommendedRunesById> getChampionRecommendedRunesById() {
        return championRecommendedRunesById;
    }

    public void setChampionRecommendedRunesById(List<ChampionRecommendedRunesById> championRecommendedRunesById) {
        this.championRecommendedRunesById = championRecommendedRunesById;
    }

    public List<ChampionRecommendedItemsById> getChampionRecommendedItemsById() {
        return championRecommendedItemsById;
    }

    public void setChampionRecommendedItemsById(List<ChampionRecommendedItemsById> championRecommendedItemsById) {
        this.championRecommendedItemsById = championRecommendedItemsById;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

}

