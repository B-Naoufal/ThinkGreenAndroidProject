package com.club_hayat.ThinkGreen.CATEGORIES;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.club_hayat.ThinkGreen.R;
import com.club_hayat.ThinkGreen.Youtubeplayer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Naoufal on 2/23/2017.
 */

public class AdapterFavoris extends RecyclerView.Adapter<AdapterFavoris.FavorisViewHolder> {
    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;


    public AdapterFavoris(ArrayList<Picture> pictures, int resource, Activity activity ) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public FavorisViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false );

        return new FavorisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavorisViewHolder holder, int position) {

        final Picture picture = pictures.get(position);

        holder.usernameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);

        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(activity , Youtubeplayer.class);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP )
        {
            Explode explode = new Explode();
            explode.setDuration(1000);
            activity.getWindow().setExitTransition(explode);
            intent.putExtra("video_id", picture.getVideoId());
            activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity, v, activity.getString(R.string.transitionname_picture) ).toBundle());
        }else
        {
            intent.putExtra("video_id",picture.getVideoId());
            activity.startActivity(intent);
        }



        }
        });
        }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class FavorisViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;

        public FavorisViewHolder(View itemView) {
            super(itemView);
            pictureCard     = (ImageView) itemView.findViewById(R.id.pictureofFavoris);
            usernameCard    = (TextView)  itemView.findViewById(R.id.userNameCardFavoris);
            timeCard        = (TextView)  itemView.findViewById(R.id.timeCardFavoris);
        }
}







}
