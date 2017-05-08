package com.club_hayat.ThinkGreen.CATEGORIES;

import android.support.v7.app.*;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.club_hayat.ThinkGreen.Custom.CustomObject;
import com.club_hayat.ThinkGreen.R;
import com.example.library.FocusResizeScrollListener;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        MyAdapter myAdapter = new MyAdapter(this, (int) getResources().getDimension(R.dimen.custom_item_height));
        myAdapter.addItems(addItems());
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(myAdapter);
            recyclerView.addOnScrollListener(new FocusResizeScrollListener<>(myAdapter, linearLayoutManager));
        }
    }

    private List<CustomObject> addItems() {
        List<CustomObject> items = new ArrayList<>();
        items.add(new CustomObject("CARTON", "15 TUTOS", R.drawable.image01));
        items.add(new CustomObject("Plastique", "10 TUTOS", R.drawable.image02));
        items.add(new CustomObject("papier", "8 TUTOS", R.drawable.image03));
        items.add(new CustomObject("CANETTES & CONSERVE", "8 TUTOS", R.drawable.image04));
        items.add(new CustomObject("VERRE", "5 TUTOS", R.drawable.image05));
        items.add(new CustomObject("TISSU", "6 TUTOS", R.drawable.image06));
        items.add(new CustomObject("bois", "10 TUTOS", R.drawable.bois));
        return items;
    }

}

