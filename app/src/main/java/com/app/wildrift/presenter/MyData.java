package com.app.wildrift.presenter;

import com.app.wildrift.model.Champion;
import com.app.wildrift.model.DataInfo;
import com.app.wildrift.model.ItemsList;
import com.app.wildrift.model.RunesList;
import com.app.wildrift.model.ServerAPi;

import java.util.List;

import retrofit2.Call;

public class MyData {


    private static ServerAPi serverAPi;
    public static Call<DataInfo> info;
    public static String appVersion;
    public static List<Champion> championList;
    public static List<ItemsList> itemsList;
    public static List<RunesList> runesList;

    public static void start(){

        serverAPi = DataInfo.Instance().create(ServerAPi.class);
        info = serverAPi.getInfo();

    }
}
