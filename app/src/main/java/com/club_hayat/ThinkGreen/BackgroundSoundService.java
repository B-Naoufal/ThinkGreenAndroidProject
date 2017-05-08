package com.club_hayat.ThinkGreen;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class BackgroundSoundService extends Service {
    private static final String TAG = null;
    MediaPlayer player;
    Context mContext;
    public IBinder onBind(Intent arg0) {

        return null;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.back_music_mignons);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);

    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return 1;
    }

    public void onStart(Intent intent, int startId) {
        // TO DO
    }
    public IBinder onUnBind(Intent arg0) {
        // TO DO Auto-generated method
        return null;
    }

    public void onStop() {
      mContext.stopService(new Intent(mContext, BackgroundSoundService.class));

    }
    public void onPause() {
        mContext.stopService(new Intent(mContext, BackgroundSoundService.class));

    }
    @Override
    public void onDestroy() {
        player.stop();
        player.release();
        super.onDestroy();

    }

    @Override
    public void onLowMemory() {

    }
}