package com.tt.todaynail.tab1;

import android.content.Context;
import android.content.Intent;
import android.view.View;

/**
 * Created by dahye on 2017-05-25.
 */

public class ImageClickListener implements View.OnClickListener {

    Context context;


    int mThumbIds;

    public ImageClickListener(Context context, int mThumbIds) {
        this.context = context;
        this.mThumbIds = mThumbIds;
    }

    public void onClick(View v) {

        Intent intent = new Intent(context, ImageActivity.class);
        intent.putExtra("mThumbIds", mThumbIds);
        context.startActivity(intent);
    }
}