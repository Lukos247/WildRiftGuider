package com.app.wildrift.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParentItem {
    @SerializedName("item")
    @Expose
    private String item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
