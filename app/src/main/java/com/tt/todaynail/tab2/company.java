package com.tt.todaynail.tab2;

import android.graphics.Bitmap;

/**
 * Created by dahye on 2017-05-25.
 */

public class company {

    public String name;
    public String add;
    public Bitmap image;

    public company(String name, String add, Bitmap image){
        this.image=image;
        this.name =  name;
        this.add = add;

    }
}
