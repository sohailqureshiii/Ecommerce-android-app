package com.example.shopisthan_ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class IntroViewPagerAdapter extends PagerAdapter {

    Context mcontext;
    List<ScreenItem> mListScreen;

    public IntroViewPagerAdapter(Context mcontext, List<ScreenItem> mListScreen) {
        this.mcontext = mcontext;
        this.mListScreen = mListScreen;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_screen,null);

        ImageView imaSlide = layoutScreen.findViewById(R.id.intro_img);
        TextView title = layoutScreen.findViewById(R.id.intro_title);
        TextView description = layoutScreen.findViewById(R.id.introduction_description);
        TextView description2 = layoutScreen.findViewById(R.id.introduction_description2);

        title.setText(mListScreen.get(position).getTitle());
        description.setText(mListScreen.get(position).getDescription());
        description2.setText(mListScreen.get(position).getDescription2());
        imaSlide.setImageResource(mListScreen.get(position).getImg());

        container.addView(layoutScreen);

        return  layoutScreen;

    }

    @Override
    public int getCount() {
        return mListScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View)object);
    }
}
