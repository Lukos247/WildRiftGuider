package com.app.wildrift.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChampionRecommendedRunesById {

    @SerializedName("runeOne")
    @Expose
    private String runeOne;
    @SerializedName("runeTwo")
    @Expose
    private String runeTwo;
    @SerializedName("runeThree")
    @Expose
    private String runeThree;
    @SerializedName("runeFour")
    @Expose
    private String runeFour;

    public String getRuneOne() {
        return runeOne;
    }

    public void setRuneOne(String runeOne) {
        this.runeOne = runeOne;
    }

    public String getRuneTwo() {
        return runeTwo;
    }

    public void setRuneTwo(String runeTwo) {
        this.runeTwo = runeTwo;
    }

    public String getRuneThree() {
        return runeThree;
    }

    public void setRuneThree(String runeThree) {
        this.runeThree = runeThree;
    }

    public String getRuneFour() {
        return runeFour;
    }

    public void setRuneFour(String runeFour) {
        this.runeFour = runeFour;
    }

}
