package com.app.wildrift.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.app.wildrift.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.Task;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    public  MyAdverCallbacker myAdverCallbacker;
    ReviewInfo reviewInfo;
    ReviewManager manager;
    Activity activity;

    private int launchCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        myAdverCallbacker = new MyAdverCallbacker(callback);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
        loaderData();
        launchCounter++;
        saveData();





        if(launchCounter == 3 || launchCounter == 5){
            initView();
       }


        final BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this, R.id.fragment_manager);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        navController.navigate(R.id.championsListFragment);
        

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.championsBottomMenu:
                        navController.navigate(R.id.championsListFragment);
                        break;
                    case R.id.runesBottomMenu:
                        navController.navigate(R.id.runesListFragment);
                        break;
                    case R.id.itemsBottomMenu:
                        navController.navigate(R.id.itemsListFragment);
                        break;

                }

               item.setChecked(true);

                return false;
            }
        });

        AdView adView = new AdView(this);

        adView.setAdSize(AdSize.BANNER);
        mInterstitialAd = new InterstitialAd(this);

        adView.setAdUnitId(getString(R.string.adver_banner_id));
        mInterstitialAd.setAdUnitId(getString(R.string.adver_interstitial_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




    }

    MyAdverCallbacker.AdverShower callback = new MyAdverCallbacker.AdverShower() {
        @Override
        public void onDoneAdver() {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.setAdListener(new AdListener(){
                    @Override
                    public void onAdClosed() {
                        mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    }
                });
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
        }
    };

    private void initView(){

        manager = ReviewManagerFactory.create(this);
        Task<ReviewInfo> request = manager.requestReviewFlow();
        request.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // We can get the ReviewInfo object
                reviewInfo = task.getResult();
                askForReview();
            } else {
                // There was some problem, continue regardless of the result.
            }
        });

    }
    private void askForReview(){
        if(manager!=null && reviewInfo != null) {
            Task<Void> flow = manager.launchReviewFlow(activity, reviewInfo);
            flow.addOnCompleteListener(task -> {
                // The flow has finished. The API does not indicate whether the user
                // reviewed or not, or even whether the review dialog was shown. Thus, no
                // matter the result, we continue our app flow.
            });
        }
    }
    private void loaderData(){
       SharedPreferences sharedPreferences = getSharedPreferences("DataPrefs",MODE_PRIVATE);
        launchCounter = sharedPreferences.getInt("launchCounter",0);

    }
    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("DataPrefs",MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("launchCounter",launchCounter);
        edit.apply();

    }


}

