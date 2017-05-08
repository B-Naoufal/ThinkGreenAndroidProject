package com.club_hayat.ThinkGreen;

import android.animation.ObjectAnimator;
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

import com.github.mzule.fantasyslide.SideBar;
import com.github.mzule.fantasyslide.SimpleFantasyListener;
import com.github.mzule.fantasyslide.Transformer;

public class ActionBar extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final DrawerArrowDrawable indicator = new DrawerArrowDrawable(this);
        indicator.setColor(Color.WHITE);
        getSupportActionBar().setHomeAsUpIndicator(indicator);

        setTransformer();
        // setListener();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerLayout.setScrimColor(Color.GRAY);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if (((ViewGroup) drawerView).getChildAt(1).getId() == R.id.leftSideBar) {
                    indicator.setProgress(slideOffset);
                }
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

        /*public void onClick(View view) {
            if (view instanceof TextView) {
                String title = ((TextView) view).getText().toString();
                if (title.startsWith("星期")) {
                    Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(UniversalActivity.newIntent(this, title));
                }
        }*/
}
