package com.club_hayat.ThinkGreen;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.club_hayat.ThinkGreen.CATEGORIES.CategoriesActivity;
import com.club_hayat.ThinkGreen.Custom.CircleImageView;
import com.club_hayat.ThinkGreen.Custom.lifecycle;
import com.github.mzule.fantasyslide.SideBar;
import com.github.mzule.fantasyslide.SimpleFantasyListener;
import com.github.mzule.fantasyslide.Transformer;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final DrawerArrowDrawable indicator = new DrawerArrowDrawable(this);
        indicator.setColor(Color.WHITE);
        getSupportActionBar().setHomeAsUpIndicator(indicator);

        setTransformer();
        setListener();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if (((ViewGroup) drawerView).getChildAt(1).getId() == R.id.leftSideBar) {
                    indicator.setProgress(slideOffset);
                }
            }
        });


        LinearLayout LL =(LinearLayout) findViewById(R.id.userInfo) ;
        LL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent myIntent = new Intent(HomeActivity.this, About_Us.class);
                startActivity(myIntent);

            }

        });
        ImageView image = (ImageView) findViewById(R.id.recycl_draw);

        image.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent myIntent = new Intent(HomeActivity.this, CategoriesActivity.class);
                startActivity(myIntent);

            }

        });
        ImageView about = (ImageView) findViewById(R.id.empeco_draw);

        about.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent myIntent = new Intent(HomeActivity.this, OpenWeb.class);
                startActivity(myIntent);

            }

        });
        ImageView notre_terre = (ImageView) findViewById(R.id.terre_draw);

        notre_terre.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent myIntent = new Intent(HomeActivity.this, NotreTerre.class);
                startActivity(myIntent);

            }

        });
        ImageView fav = (ImageView) findViewById(R.id.favoris);

        fav.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent myIntent = new Intent(HomeActivity.this, Favoris.class);
                startActivity(myIntent);

            }

        });
        ImageView co2 = (ImageView) findViewById(R.id.co2_draw);

        co2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent myIntent = new Intent(HomeActivity.this, EmissionCO2.class);
                startActivity(myIntent);

            }

        });
    }

    private void setListener() {
        SideBar leftSideBar = (SideBar) findViewById(R.id.leftSideBar);
        leftSideBar.setFantasyListener(new SimpleFantasyListener() {
            @Override
            public boolean onHover(@Nullable View view) {
                return false;

            }

            @Override
            public boolean onSelect(View view) {
                return false;
            }

            @Override
            public void onCancel() {
            }
        });
    }

    private void setTransformer() {
        final float spacing = getResources().getDimensionPixelSize(R.dimen.spacing);
        SideBar rightSideBar = (SideBar) findViewById(R.id.rightSideBar);
        rightSideBar.setTransformer(new Transformer() {
            private View lastHoverView;

            @Override
            public void apply(ViewGroup sideBar, View itemView, float touchY, float slideOffset, boolean isLeft) {
                boolean hovered = itemView.isPressed();
                if (hovered && lastHoverView != itemView) {
                    animateIn(itemView);
                    animateOut(lastHoverView);
                    lastHoverView = itemView;
                }
            }

            private void animateOut(View view) {
                if (view == null) {
                    return;
                }
                ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", -spacing, 0);
                translationX.setDuration(200);
                translationX.start();
            }

            private void animateIn(View view) {
                ObjectAnimator translationX = ObjectAnimator.ofFloat(view, "translationX", 0, -spacing);
                translationX.setDuration(200);
                translationX.start();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        }
        return true;
    }

    public void onClick(View view) {
            if (view instanceof TextView) {
                String title = ((TextView) view).getText().toString();
                if (title.startsWith("HOME")) {
                    Intent myIntent = new Intent(HomeActivity.this, HomeActivity.class);
                    startActivity(myIntent);
                }
                if (title.startsWith("FAVORIS")) {
                    Intent myIntent = new Intent(HomeActivity.this, Favoris.class);
                    startActivity(myIntent);
                }
                if (title.startsWith("TUTORIELS")) {
                    Intent myIntent = new Intent(HomeActivity.this, CategoriesActivity.class);
                    startActivity(myIntent);
                }
                if (title.startsWith("COP")) {
                    Intent myIntent = new Intent(HomeActivity.this, NotreTerre.class);
                    startActivity(myIntent);
                }


            }
        if (view instanceof CircleImageView){
            Intent myIntent = new Intent(HomeActivity.this, About_Us.class);
            startActivity(myIntent);
        }
    }



    protected void onResume() {
        super.onResume();
        lifecycle.activityResumed();
        Intent svc=new Intent(this, BackgroundSoundService.class);
        stopService(svc);
    }

    @Override
    protected void onPause() {
        super.onPause();
        lifecycle.activityPaused();
        Intent svc=new Intent(this, BackgroundSoundService.class);
        stopService(svc);

    }

}
