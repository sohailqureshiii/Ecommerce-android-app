package com.example.shopisthan_ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapterr extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] text;
    private int[] logo;

    public MainAdapterr(Context c, String[] text, int[] logo){
        context = c;
        this.text = text;
        this.logo = logo;
    }

    @Override
    public int getCount() {
        return text.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }
        if (convertView == null){
            convertView = inflater.inflate(R.layout.row_layout,null);
        }
        ImageView imageView = convertView.findViewById(R.id.image_vieww);
        TextView textView = convertView.findViewById(R.id.textVieww);

        imageView.setImageResource(logo[position]);
        textView.setText(text[position]);
        return convertView;
    }
}
