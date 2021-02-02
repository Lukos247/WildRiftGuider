package com.app.wildrift.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataInfo {


    private static String url = "https://raw.githubusercontent.com/Lukos247/WildRiftGuider/main/";
    private static Retrofit retrofit;

    public static Retrofit Instance(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }



        return retrofit;
    }

    @SerializedName("AppVersion")
    @Expose
    private String appVersion;
    @SerializedName("champion")
    @Expose
    private List<Champion> champion = null;
    @SerializedName("runesList")
    @Expose
    private List<RunesList> runesList = null;
    @SerializedName("itemsList")
    @Expose
    private List<ItemsList> itemsList = null;

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public List<Champion> getChampion() {
        return champion;
    }

    public void setChampion(List<Champion> champion) {
        this.champion = champion;
    }

    public List<RunesList> getRunesList() {
        return runesList;
    }

    public void setRunesList(List<RunesList> runesList) {
        this.runesList = runesList;
    }

    public List<ItemsList> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemsList> itemsList) {
        this.itemsList = itemsList;
    }




}
