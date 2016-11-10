package com.techmighty.rupeeexchangeprocess;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import me.kaelaela.verticalviewpager.VerticalViewPager;
import me.kaelaela.verticalviewpager.transforms.StackTransformer;
import me.kaelaela.verticalviewpager.transforms.ZoomOutTransformer;

public class MainActivity extends AppCompatActivity {

    AdView mAdView;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        mAdView = (AdView) findViewById(R.id.adView);
        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.inter_id));


        AdRequest adRequest = new AdRequest.Builder()
                .build();

        mAdView.loadAd(adRequest);
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener(){
            public void onAdLoaded(){
                showInterstitial();
            }
        });



        initViewPager();
    }

    private void initViewPager() {
        VerticalViewPager viewPager = (VerticalViewPager) findViewById(R.id.vertical_viewpager);
        viewPager.setPageTransformer(false, new ZoomOutTransformer());
        viewPager.setPageTransformer(true, new StackTransformer());
        String title = "ContentFragment";
        viewPager.setAdapter(new ContentFragmentAdapter.Holder(getSupportFragmentManager())
                .add(ContentFragment.newInstance(title, 1))
                .add(ContentFragment.newInstance(title, 2))
                .add(ContentFragment.newInstance(title, 3))
                .add(ContentFragment.newInstance(title, 4))
                .add(ContentFragment.newInstance(title, 5))
                .add(ContentFragment.newInstance(title, 6))
                .add(ContentFragment.newInstance(title, 7))
                .add(ContentFragment.newInstance(title, 8))
                .add(ContentFragment.newInstance(title, 9))
                .add(ContentFragment.newInstance(title, 10))
                .add(ContentFragment.newInstance(title, 11))
                .add(ContentFragment.newInstance(title, 12))
                .add(ContentFragment.newInstance(title, 13))
                .add(ContentFragment.newInstance(title, 14))
                .add(ContentFragment.newInstance(title, 15))
                .set());
        //If you setting other scroll mode, the scrolled fade is shown from either side of display.
        //viewPager.setOverScrollMode(View.OVER_SCROLL_NEVER);
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
}

