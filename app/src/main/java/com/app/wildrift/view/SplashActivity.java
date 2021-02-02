package com.app.wildrift.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.wildrift.R;
import com.app.wildrift.model.DataInfo;
import com.app.wildrift.presenter.MyData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        MyData.start();
        getServerInfo();

    }


    private void getServerInfo() {

        MyData.info.enqueue(new Callback<DataInfo>() {
            @Override
            public void onResponse(Call<DataInfo> call, Response<DataInfo> response) {
                try {
                    DataInfo body = response.body();
                    MyData.appVersion = body.getAppVersion();
                    MyData.championList = body.getChampion();
                    MyData.itemsList = body.getItemsList();
                    MyData.runesList = body.getRunesList();
                    startApp();
                }catch (Exception e){
                    getServerInfo();
                }
            }

            @Override
            public void onFailure(Call<DataInfo> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Please, check your internet connection o try later", Toast.LENGTH_LONG);
            }
        });


    }





    private void startApp() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.nav_default_enter_anim, R.anim.nav_default_exit_anim);
        finish();

    }
}