package com.example.imagegallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public ImageAdapter(ArrayList arrayList, Context context) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(this.context);
        imageView.setImageResource(arrayList.get(i));
        imageView.setScaleType(ImageView.ScaleType.FIT_END);
        imageView.setLayoutParams(new Gallery.LayoutParams(200,200));
        return imageView;
    }
}
