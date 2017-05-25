package com.tt.todaynail.tab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.tt.todaynail.R;

/**
 * Created by dahye on 2017-05-25.
 */

public class ImageActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nail_image);


        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        setImage(imageView);
    }

    private void setImage(ImageView imageView) {
        Intent receivedIntent = getIntent();

        int mThumbIds = (Integer)receivedIntent.getExtras().get("mThumbIds");
        imageView.setImageResource(mThumbIds);
    }
}
