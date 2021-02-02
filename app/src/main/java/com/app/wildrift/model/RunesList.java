package com.app.wildrift.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RunesList {

    @SerializedName("localization")
    @Expose
    private String localization;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("runeName")
    @Expose
    private String runeName;
    @SerializedName("runeDescription")
    @Expose
    private String runeDescription;
    @SerializedName("runeIcon")
    @Expose
    private String runeIcon;

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRuneName() {
        return runeName;
    }

    public void setRuneName(String runeName) {
        this.runeName = runeName;
    }

    public String getRuneDescription() {
        return runeDescription;
    }

    public void setRuneDescription(String runeDescription) {
        this.runeDescription = runeDescription;
    }

    public String getRuneIcon() {
        return runeIcon;
    }

    public void setRuneIcon(String runeIcon) {
        this.runeIcon = runeIcon;
    }
}
