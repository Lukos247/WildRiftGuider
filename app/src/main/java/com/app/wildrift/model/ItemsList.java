package com.app.wildrift.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemsList {

    @SerializedName("localization")
    @Expose
    private String localization;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("itemName")
    @Expose
    private String itemName;
    @SerializedName("itemStats")
    @Expose
    private String itemStats;
    @SerializedName("itemDescription")
    @Expose
    private String itemDescription;
    @SerializedName("parentItems")
    @Expose
    private List<ParentItem> parentItems = null;

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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemStats() {
        return itemStats;
    }

    public void setItemStats(String itemStats) {
        this.itemStats = itemStats;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public List<ParentItem> getParentItems() {
        return parentItems;
    }

    public void setParentItems(List<ParentItem> parentItems) {
        this.parentItems = parentItems;
    }

}
