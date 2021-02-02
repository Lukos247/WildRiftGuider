package com.app.wildrift.presenter;

public class RuneListStruct {

    private String runeName;
    private String runeURL;
    private String runeDescription;

    public String getRuneName() {
        return runeName;
    }

    public void setRuneName(String runeName) {
        this.runeName = runeName;
    }

    public String getRuneURL() {
        return runeURL;
    }

    public void setRuneURL(String runeURL) {
        this.runeURL = runeURL;
    }

    public String getRuneDescription() {
        return runeDescription;
    }

    public void setRuneDescription(String runeDescription) {
        this.runeDescription = runeDescription;
    }

    public RuneListStruct(String name,String url, String description){
        runeName = name;
        runeURL = url;
        runeDescription = description;
    }





}
