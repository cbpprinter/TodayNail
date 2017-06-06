package com.tt.todaynail.tab2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.tt.todaynail.R;

/**
 * Created by dahye on 2017-06-06.
 */

public class CompanyActivity extends Activity {


  /*  TextView cpname = (TextView) findViewById(R.id.Human_name);
    TextView cpadd = (TextView) findViewById(R.id.Human_gender);
  */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_image);

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

}
