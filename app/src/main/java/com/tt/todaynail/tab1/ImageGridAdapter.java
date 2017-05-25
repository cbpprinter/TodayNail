package com.tt.todaynail.tab1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by dahye on 2017-05-25.
 */

public class ImageGridAdapter extends BaseAdapter {

    Context context = null;


    int[] mThumbIds = null;

    public ImageGridAdapter(Context context, int[] mThumbIds) {
        this.context = context;
        this.mThumbIds = mThumbIds;
    }

    public int getCount() {
        return (null != mThumbIds) ? mThumbIds.length : 0;
    }


    public Object getItem(int position) {
        return (null != mThumbIds) ? mThumbIds[position] : 0;
    }


    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = null;

        if (null != convertView)
            imageView = (ImageView) convertView;
        else {

            Bitmap bmp
                    = BitmapFactory.decodeResource(context.getResources(), mThumbIds[position]);
            bmp = Bitmap.createScaledBitmap(bmp, 320, 320, false);

            imageView = new ImageView(context);
            imageView.setAdjustViewBounds(true);
            imageView.setImageBitmap(bmp);


            ImageClickListener imageViewClickListener
                    = new ImageClickListener(context, mThumbIds[position]);
            imageView.setOnClickListener(imageViewClickListener);
        }

        return imageView;
    }
}