package com.tt.todaynail;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private TabHost tabHost;

    private Integer[] mThumbIds = { R.drawable.view01,
            R.drawable.view02, R.drawable.view03,
            R.drawable.view04, R.drawable.view05,
            R.drawable.view06, R.drawable.view07
    };

    DisplayMetrics mMetrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator(getString(R.string.tab1));
        GridView gridview = (GridView) findViewById(R.id.gridView1);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(gridviewOnItemClickListener);

        mMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator(getString(R.string.tab2));

        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3");
        tab3.setContent(R.id.tab3);
        tab3.setIndicator(getString(R.string.tab3));

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
    }
    private GridView.OnItemClickListener gridviewOnItemClickListener
            = new GridView.OnItemClickListener() {

        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {

            Toast.makeText(HomeActivity.this,
                    arg0.getAdapter().getItem(arg2).toString(),
                    Toast.LENGTH_LONG).show();
        }
    };

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return mThumbIds[position];
        }

        public long getItemId(int position) {
            return position;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {

            int rowWidth = (mMetrics.widthPixels) / 3;

            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(rowWidth,rowWidth));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setPadding(1, 1, 1, 1);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.btn_camera){
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);

            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}