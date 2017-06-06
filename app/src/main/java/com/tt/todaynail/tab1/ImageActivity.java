package com.tt.todaynail.tab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.tt.todaynail.R;

/**
 * Created by dahye on 2017-05-25.
 */

public class ImageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nail_image);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
       /* mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("도안 상세보기");
        mToolbar.setNavigationIcon(R.mipmap.ic_launcher);
    //    setSupportActionBar(mToolbar);*/


        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        setImage(imageView);
    }

    private void setImage(ImageView imageView) {
        Intent receivedIntent = getIntent();

        int mThumbIds = (Integer)receivedIntent.getExtras().get("mThumbIds");
        imageView.setImageResource(mThumbIds);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
