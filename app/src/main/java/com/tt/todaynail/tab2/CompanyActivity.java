package com.tt.todaynail.tab2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.tt.todaynail.R;

/**
 * Created by dahye on 2017-06-06.
 */

public class CompanyActivity extends AppCompatActivity  {


  /*  TextView cpname = (TextView) findViewById(R.id.Human_name);
    TextView cpadd = (TextView) findViewById(R.id.Human_gender);
  */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_image);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //ImageView imageView = (ImageView)findViewById(R.id.company_image);

        Intent intent = getIntent();
        Bitmap image;
        ImageView BigImage;
        byte[] arr = getIntent().getByteArrayExtra("image");
        image = BitmapFactory.decodeByteArray(arr, 0, arr.length);
        BigImage = (ImageView)findViewById(R.id.imageView2);


        BigImage.setImageBitmap(image);
        /*cpname.setText(intent.getStringExtra("name"));
        cpadd.setText(intent.getStringExtra("add"));
*/
        //imageView.setImageResource(intent.getIntExtra("image",0));

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
