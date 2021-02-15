package com.app.wildrift.presenter;

public class ItemListSctuct {
    public ItemListSctuct(String icon, String name, String stats, String description, int id) {
        this.icon = icon;
        this.name = name;
        this.stats = stats;
        this.description = description;
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String icon;
    private String name;
    private String stats;
    private String description;
    private int id;

}
