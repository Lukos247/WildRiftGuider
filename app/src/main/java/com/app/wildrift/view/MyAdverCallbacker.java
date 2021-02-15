package com.app.wildrift.view;

public class MyAdverCallbacker{

    private static AdverShower callback;
    private static int valueAd = 0;


    public interface AdverShower{
        void onDoneAdver();
    }

    MyAdverCallbacker(AdverShower callback){this.callback = callback;}

    public static void showAdverCounter(){
        valueAd++;
        if(valueAd==3) {
            callback.onDoneAdver();
            valueAd = 0;
        }


    }


}
