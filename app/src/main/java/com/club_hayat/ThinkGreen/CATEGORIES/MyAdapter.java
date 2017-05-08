package com.club_hayat.ThinkGreen.CATEGORIES;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.club_hayat.ThinkGreen.Custom.CustomObject;
import com.club_hayat.ThinkGreen.R;
import com.example.library.FocusResizeAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends FocusResizeAdapter<RecyclerView.ViewHolder> {

    private List<CustomObject> items;

    Context context;

    public MyAdapter(Context context, int height) {
        super(context, height);
        this.context=context;
        items = new ArrayList<>();
    }

    public void addItems(List<CustomObject> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getFooterItemCount() {

        return items.size();

    }

    @Override
    public RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_custom, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindFooterViewHolder(RecyclerView.ViewHolder holder, int position) {
        CustomObject customObject = items.get(position);
        fill((MyViewHolder)holder, customObject);
    }

    private void fill(MyViewHolder holder, CustomObject customObject) {
        holder.image.setImageResource(customObject.getDrawable());
        holder.titleTextView.setText(customObject.getTitle());
        holder.subtitleTextView.setText(customObject.getSubTitle());
    }

    @Override
    public void onItemBigResize(RecyclerView.ViewHolder viewHolder, int position, int dyAbs) {

    }

    @Override
    public void onItemBigResizeScrolled(RecyclerView.ViewHolder viewHolder, int position, int dyAbs) {

    }

    @Override
    public void onItemSmallResizeScrolled(RecyclerView.ViewHolder viewHolder, int position, int dyAbs) {
    }

    @Override
    public void onItemSmallResize(RecyclerView.ViewHolder viewHolder, int position, int dyAbs) {
    }

    @Override
    public void onItemInit(RecyclerView.ViewHolder viewHolder) {
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView titleTextView;
        TextView subtitleTextView;

        public MyViewHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.image_custom_cell);
            titleTextView = (TextView) v.findViewById(R.id.title_custom_item);
            subtitleTextView = (TextView) v.findViewById(R.id.subtitle_custom_item);

            image.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        CustomObject clickedDataItem = items.get(pos);
                        if (clickedDataItem.getTitle()=="CARTON"){
                            Intent intent = new Intent(context , CARTON.class);
                            intent.putExtra("choice", clickedDataItem.getTitle());
                            context.startActivity(intent);
                        }
                        Intent intent = new Intent(context , CARTON.class);
                        intent.putExtra("choice", clickedDataItem.getTitle());
                        context.startActivity(intent);
                        Toast.makeText(view.getContext(), "You clicked " + clickedDataItem.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }
}
