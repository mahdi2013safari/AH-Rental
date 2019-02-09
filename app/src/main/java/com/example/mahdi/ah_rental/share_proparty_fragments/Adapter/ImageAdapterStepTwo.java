package com.example.mahdi.ah_rental.share_proparty_fragments.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.mahdi.ah_rental.R;

public class ImageAdapterStepTwo extends BaseAdapter {

    private Context context;

    public ImageAdapterStepTwo(Context c){
        context = c;
    }

    @Override
    public int getCount() {
        return arrayImages.length;
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
        ImageButton imageButton;
        if(convertView == null){
            imageButton = new ImageButton(context);
            imageButton.setLayoutParams(new GridView.LayoutParams(150, 150));
            imageButton.setScaleType(ImageButton.ScaleType.CENTER_CROP);
            imageButton.setPadding(8, 8, 8, 8);
        }else{
            imageButton = (ImageButton) convertView;
        }

        imageButton.setImageResource(arrayImages[position]);
        return imageButton;
    }

    private Integer[] arrayImages = {
            R.drawable.four, R.drawable.two,
            R.drawable.one, R.drawable.two,
            R.drawable.one, R.drawable.one,
    };
}
