package com.app.wildrift.presenter;

public class ChampionsListSctruct {

    private String imageURL;

    private String localization;

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public ChampionsListSctruct(String imageURL, String name,int id,String localization) {
        this.imageURL = imageURL;
        this.id = id;
        this.name = name;
        this.localization = localization;
    }
}
