package com.club_hayat.ThinkGreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.club_hayat.ThinkGreen.CATEGORIES.Picture;
import com.club_hayat.ThinkGreen.CATEGORIES.PictureAdapter;

import java.util.ArrayList;

public class Favoris extends AppCompatActivity {

    ArrayList<Picture> picturesFavoris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris);

        Intent intent = getIntent();
        String choicecateg = intent.getStringExtra("choice") ;

        RecyclerView picturesRecycler = (RecyclerView) findViewById(R.id.favoris_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecycler.setLayoutManager(linearLayoutManager);
        PictureAdapter pictureAdapterRecyclerView = new PictureAdapter(buildPictures(choicecateg),R.layout.cardview_picture, Favoris.this);
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
    }
    public ArrayList<Picture> buildPictures(String string)
    {
        ArrayList<Picture> VAR= new ArrayList<>();
        VAR.add(new Picture(R.drawable.ampoulefl, "Soliflores from old bulbs", "Drill a small hole and pass the thread and hang it on the wall.", "9c62vgtGsAE"));
        VAR.add(new Picture(R.drawable.bchaussures, "Rangement bureau", "faire un rangement pour vos livres et vos cahiers avec une boîte à chaussures. C'est super rapide et très simple !", "SvCl-oQHRfk"));
        VAR.add(new Picture(R.drawable.soap, "soap dispenser ", "Making some awesome JAR SOAP DISPENSER .", "N5zk1OR43Fg"));
        VAR.add(new Picture(R.drawable.minion, "Minions", "Making Minions only by using cardboard", "gBTFl5yS3q4"));
        VAR.add(new Picture(R.drawable.flowerpot, "Flower Pot", "Idea of recycling of cardboard  in flower pot ","Qxl69uhhJmw"));
        VAR.add(new Picture(R.drawable.ampl, "Starry Cardboard Lampshade ", "Idea of recycling of cardboard  in a Starry Lampshade","CSXHNHSaLbc"));


        return VAR;
    }
}
