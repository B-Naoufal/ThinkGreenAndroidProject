package com.club_hayat.ThinkGreen;

import android.content.Intent;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class MainActivity extends AwesomeSplash {

    @Override
    public void initSplash(ConfigSplash configSplash) {



        configSplash.setBackgroundColor(R.color.fill); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(1000);//int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        configSplash.setPathSplash(Path.logo); //set path String
        configSplash.setOriginalHeight(512); //in relation to your svg (path) resource
        configSplash.setOriginalWidth(512); //in relation to your svg (path) resource
        configSplash.setAnimPathStrokeDrawingDuration(2500);
        configSplash.setPathSplashStrokeSize(4); //I advise value be <5
        configSplash.setPathSplashStrokeColor(R.color.white); //any color you want form colors.xml
        configSplash.setAnimPathFillingDuration(1500);
        configSplash.setPathSplashFillColor(R.color.whitef); //path object filling color

        configSplash.setTitleSplash("Enjoy & Recycle");
        configSplash.setTitleTextColor(R.color.whitef);
        configSplash.setTitleTextSize(40f); //float value
        configSplash.setAnimTitleDuration(1500);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);
        configSplash.setTitleFont("fonts/germania_one.ttf"); //provide string to your font located in assets/fonts/


    }

    @Override
    public void animationsFinished() {

        Intent myIntent = new Intent(this, HomeActivity.class);
        startActivity(myIntent);
        finish();

    }

}
