package com.app.wildrift.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChampionRecommendedItemsById {

    @SerializedName("itemOne")
    @Expose
    private String itemOne;
    @SerializedName("itemTwo")
    @Expose
    private String itemTwo;
    @SerializedName("itemThree")
    @Expose
    private String itemThree;
    @SerializedName("itemFour")
    @Expose
    private String itemFour;
    @SerializedName("itemFive")
    @Expose
    private String itemFive;
    @SerializedName("itemSix")
    @Expose
    private String itemSix;
    @SerializedName("itemWard")
    @Expose
    private String itemWard;

    public String getItemOne() {
        return itemOne;
    }

    public void setItemOne(String itemOne) {
        this.itemOne = itemOne;
    }

    public String getItemTwo() {
        return itemTwo;
    }

    public void setItemTwo(String itemTwo) {
        this.itemTwo = itemTwo;
    }

    public String getItemThree() {
        return itemThree;
    }

    public void setItemThree(String itemThree) {
        this.itemThree = itemThree;
    }

    public String getItemFour() {
        return itemFour;
    }

    public void setItemFour(String itemFour) {
        this.itemFour = itemFour;
    }

    public String getItemFive() {
        return itemFive;
    }

    public void setItemFive(String itemFive) {
        this.itemFive = itemFive;
    }

    public String getItemSix() {
        return itemSix;
    }

    public void setItemSix(String itemSix) {
        this.itemSix = itemSix;
    }

    public String getItemWard() {
        return itemWard;
    }

    public void setItemWard(String itemWard) {
        this.itemWard = itemWard;
    }

}
