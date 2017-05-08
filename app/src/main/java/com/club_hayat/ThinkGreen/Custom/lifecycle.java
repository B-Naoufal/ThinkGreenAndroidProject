package com.club_hayat.ThinkGreen.Custom;

import android.app.Application;

/**
 * Created by Naoufal on 2/5/2017.
 */

public class lifecycle extends Application {
    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }

    private static boolean activityVisible;
}

