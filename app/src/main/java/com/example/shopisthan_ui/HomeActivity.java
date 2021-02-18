package com.example.shopisthan_ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    GridView gridView;
    String [] text = {"Men", "Women", "Kids", "Trending", "Discount","New","Offers", "HandMade"};

    int [] logo = {R.drawable.toyscategory,R.drawable.sportscategory,R.drawable.shoescategory,R.drawable.handcraftcategory,R.drawable.furniturecategory,R.drawable.bookscategory,
            R.drawable.appliancescategory,R.drawable.fashioncategory,R.drawable.bookscategory,R.drawable.toyscategory};

    private RecyclerView recyclerView;
    RecyclerView newrecyclerView;

    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

//    RecyclerView phoneRecycler,categories;
//    RecyclerView.Adapter adapter;
//    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);




        gridView = findViewById(R.id.grid_view);
        MainAdapterr mAdapterr = new MainAdapterr(HomeActivity.this, text, logo);
        gridView.setAdapter(mAdapterr);

        ImageSlider imageSlider = findViewById(R.id.slider);

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.homebanner));
        slideModels.add(new SlideModel(R.drawable.homebanner));
        slideModels.add(new SlideModel(R.drawable.homebanner));
        slideModels.add(new SlideModel(R.drawable.homebanner));
        slideModels.add(new SlideModel(R.drawable.homebanner));
        imageSlider.setImageList(slideModels,true);

        newrecyclerView = findViewById(R.id.recycler_view);

        Integer[] langLogo = {R.drawable.appliancescategory,R.drawable.bookscategory,R.drawable.fashioncategory,R.drawable.furniturecategory,
                R.drawable.handcraftcategory,R.drawable.shoescategory,R.drawable.sportscategory,R.drawable.toyscategory};

        String[] langName = {"APPLIANCES","BOOKS","FASHION","FURNITURE","HANDCRAFT","SHOES","SPORTS","TOYS"};

        mainModels  = new ArrayList<>();
        for (int i =0;i<langLogo.length;i++){
            MainModel model = new MainModel(langLogo[i],langName[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                HomeActivity.this,LinearLayoutManager.HORIZONTAL,false
        );
        newrecyclerView.setLayoutManager(layoutManager);
        newrecyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter(HomeActivity.this,mainModels);
        newrecyclerView.setAdapter(mainAdapter);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:

                        return true;

                    case R.id.store:
                        return true;

                    case R.id.cart:
//                        startActivity(new Intent(getApplicationContext(),FavActivity.class));
//                        overridePendingTransition(0,0);
                        return true;

                    case R.id.settings:
//                        startActivity(new Intent(getApplicationContext(),SettingsActivity.class));
//                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }

}

