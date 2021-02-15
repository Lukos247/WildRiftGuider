package com.app.wildrift.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ability {

    @SerializedName("abilityName")
    @Expose
    private String abilityName;
    @SerializedName("abilityDescription")
    @Expose
    private String abilityDescription;
    @SerializedName("abilityIcon")
    @Expose
    private String abilityIcon;

    public Ability(String abilityName, String abilityDescription, String abilityIcon) {
        this.abilityName = abilityName;
        this.abilityDescription = abilityDescription;
        this.abilityIcon = abilityIcon;
    }

    public Ability(String abilityName, String abilityIcon) {
        this.abilityName = abilityName;
        this.abilityIcon = abilityIcon;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
    }

    public String getAbilityDescription() {
        return abilityDescription;
    }

    public void setAbilityDescription(String abilityDescription) {
        this.abilityDescription = abilityDescription;
    }

    public String getAbilityIcon() {
        return abilityIcon;
    }

    public void setAbilityIcon(String abilityIcon) {
        this.abilityIcon = abilityIcon;
    }


}
